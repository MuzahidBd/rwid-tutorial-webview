package com.ihfazh.rwidtutorial

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Build
import android.view.View
import android.webkit.*
import android.widget.ProgressBar
import androidx.annotation.RequiresApi
import com.airbnb.lottie.LottieAnimationView

class MyWebViewClient(private val context: Context, private val progressBar: ProgressBar, private val errorAnim: LottieAnimationView): WebViewClient(){
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
        if (url != null){
            if (url.contains("intent://")){
                val intent = Intent.parseUri(url, Intent.URI_INTENT_SCHEME)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(intent)
                return true
            }
        }
        return super.shouldOverrideUrlLoading(view, url)
    }
    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
        progressBar.visibility = View.GONE
    }

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)
        errorAnim.visibility = View.GONE
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onReceivedError(
        view: WebView?,
        request: WebResourceRequest?,
        error: WebResourceError?
    ) {

        if (error?.errorCode == ERROR_HOST_LOOKUP){
            errorAnim.visibility = View.VISIBLE
            view?.loadUrl("about:blank")
        } else {
            errorAnim.visibility = View.GONE
        }

        super.onReceivedError(view, request, error)
    }
}