package com.ihfazh.rwidtutorial

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.ihfazh.rwidtutorial.databinding.FragmentWebviewBinding

class WebViewFragment: Fragment() {
    private lateinit var binding: FragmentWebviewBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentWebviewBinding.inflate(inflater)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.webview){
            loadUrl("https://remoteworker.id/blog/blog-1")
            settings.javaScriptEnabled = true
            settings.mixedContentMode = WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE
            webViewClient = MyWebViewClient(requireActivity().applicationContext, binding.progressBar, binding.errorAnim)
        }
    }
}