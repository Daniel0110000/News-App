package com.example.newsapp.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.R
import com.example.newsapp.databinding.ActivitySearchNewsBinding
import com.example.newsapp.domain.model.News
import com.example.newsapp.ui.adapters.NewClickListener
import com.example.newsapp.ui.adapters.RecyclerNewsAdapter
import com.example.newsapp.ui.viewModels.SearchNewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchNews : AppCompatActivity(), NewClickListener {

    private lateinit var binding: ActivitySearchNewsBinding

    private val viewModel: SearchNewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.search = viewModel
        initUI()
    }

    private fun initUI() {
        binding.backLayout.setOnClickListener {
            finish()
        }

        viewModel.searchNewsResult.observe(this) { news ->
            if (news != null) {
                if (news.size > 0) {
                    initRecyclerView(news)
                    visibleOrGoneLayouts(View.GONE, View.VISIBLE, View.GONE, false)
                } else {
                    visibleOrGoneLayouts(View.GONE, View.GONE, View.VISIBLE, false)
                }
            } else {
                visibleOrGoneLayouts(View.GONE, View.GONE, View.GONE, true)
            }
        }

        viewModel.isEmptyData.observe(this) { isEmpty ->
            if (isEmpty) {
                visibleOrGoneLayouts(View.VISIBLE, View.GONE, View.GONE, false)
            }
        }
    }

    private fun initRecyclerView(newsList: ArrayList<News>) {
        binding.recyclerSearchNews.apply {
            hasFixedSize()
            layoutManager = LinearLayoutManager(this@SearchNews)
            adapter = RecyclerNewsAdapter(newsList, this@SearchNews)
        }
    }

    private fun visibleOrGoneLayouts(
        sdLayout: Int,
        rsLayout: Int,
        nfLayout: Int,
        networkMessage: Boolean
    ) {
        binding.searchDescriptionLayout.visibility = sdLayout
        binding.recyclerSearchNews.visibility = rsLayout
        binding.newsNotFoundLayout.visibility = nfLayout
        if (networkMessage) {
            findViewById<ConstraintLayout>(R.id.network_error_layout).visibility = View.VISIBLE
        } else {
            findViewById<ConstraintLayout>(R.id.network_error_layout).visibility = View.GONE
        }
    }

    override fun onItemClickListener(url: String) {
        val descriptionNews = Intent(this, DescriptionNews::class.java)
        descriptionNews.putExtra("url", url)
        startActivity(descriptionNews)
    }
}