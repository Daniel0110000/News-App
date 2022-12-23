package com.example.newsapp.ui.activities

import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.newsapp.databinding.ActivityDescriptionNewsBinding

class DescriptionNews : AppCompatActivity() {

    private lateinit var binding: ActivityDescriptionNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDescriptionNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()

    }

    private fun initUI(){
        val url: String = intent.getStringExtra("url").toString()
        binding.webDescriptionNews.apply {
            settings.javaScriptEnabled = true
            loadUrl(url)
            webViewClient = WebViewClient()
        }

        binding.backLayout.setOnClickListener {
            finish()
        }

    }
}