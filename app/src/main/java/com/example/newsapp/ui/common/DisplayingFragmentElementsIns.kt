package com.example.newsapp.ui.common

import android.content.Intent
import android.view.View
import android.widget.ProgressBar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.domain.model.News
import com.example.newsapp.ui.activities.DescriptionNews
import com.example.newsapp.ui.adapters.NewClickListener
import com.example.newsapp.ui.adapters.RecyclerNewsAdapter
import com.example.newsapp.ui.viewModels.NewsViewModel

class DisplayingFragmentElementsIns constructor(
    private val viewModel: NewsViewModel,
    private val fragment: Fragment,
    private val recyclerView: RecyclerView,
    private val progressBar: ProgressBar,
    private val category: String
): NewClickListener{

        fun initUICategories(){
            viewModel.getNewsByCategory(category)
            viewModel.newsByCategory.observe(fragment.viewLifecycleOwner){ news ->
                if(news != null){
                    initRecyclerView(news)
                }else{
                    fragment.requireView().findViewById<ConstraintLayout>(R.id.network_error_layout).visibility = View.VISIBLE
                }
            }

            viewModel.isLoading.observe(fragment.viewLifecycleOwner){ isLoading ->
                loading(isLoading)
            }

        }

    private fun initRecyclerView(newsList: ArrayList<News>){
        recyclerView.hasFixedSize()
        recyclerView.layoutManager = LinearLayoutManager(fragment.context)
        recyclerView.adapter = RecyclerNewsAdapter(newsList, this)
    }

    private fun loading(isLoading: Boolean){
        if(isLoading){
            progressBar.visibility = View.VISIBLE
            recyclerView.visibility = View.GONE
        }else{
            progressBar.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE
        }
    }

    override fun onItemClickListener(url: String) {
        val context = fragment.requireContext()
        val descriptionNews = Intent(context, DescriptionNews::class.java)
        descriptionNews.putExtra("url", url)
        context.startActivity(descriptionNews)
    }
}