package com.ihfazh.rwidtutorial

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import com.ihfazh.rwidtutorial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    @SuppressLint("SetJavaScriptEnabled", "InlinedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding.webview){
            loadUrl("https://remoteworker.id/blog/blog-1")
            settings.javaScriptEnabled = true
            settings.mixedContentMode = WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE
            webViewClient = MyWebViewClient(applicationContext, binding.progressBar, binding.errorAnim)
        }
    }

    override fun onBackPressed() {
        if (binding.webview.canGoBack()){
            binding.webview.goBack()
        } else {
            super.onBackPressed()
        }
    }
}