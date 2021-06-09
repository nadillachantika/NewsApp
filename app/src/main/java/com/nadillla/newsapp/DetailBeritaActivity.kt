package com.nadillla.newsapp

import android.content.Context
import android.net.ConnectivityManager
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_detail_berita.*
import kotlinx.android.synthetic.main.activity_detail_berita.progressbardetail
import kotlinx.android.synthetic.main.activity_detail_berita.view.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_detail_berita.*

class DetailBeritaActivity : AppCompatActivity() {

    private lateinit var webView:WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_berita)

        progressbardetail.visibility = View.VISIBLE


        //btn back
        setSupportActionBar(toolbar)
        toolbar.setNavigationIcon(R.drawable.back)
        toolbar.setNavigationOnClickListener( View.OnClickListener {
            finish()
        } )


        val url = intent.getStringExtra("url")
        webView = findViewById(R.id.webView)

        if(isConnect()){

            progressbardetail.visibility = View.GONE
            webView.apply {
                if (url != null) {
                    loadUrl(url)
                    settings.javaScriptEnabled = true
                }
            }

        }
        else{
            progressbar.visibility = View.GONE
            Toast.makeText(this, "Device is not connected", Toast.LENGTH_SHORT).show()
        }

        }

    override fun onBackPressed() {
        if (webView.canGoBack()){
            webView.goBack()
        }else{
            super.onBackPressed()
        }
    }

    fun isConnect(): Boolean {
        val connect: ConnectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        return connect.activeNetworkInfo != null && connect.activeNetworkInfo!!.isConnected


    }

}


