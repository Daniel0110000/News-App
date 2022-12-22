package com.example.newsapp.ui.commons

import android.view.View
import android.widget.ProgressBar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.ui.commons.ProgressBarIns.Companion.loading
import com.example.newsapp.ui.commons.RecyclerViewIns.Companion.initRecyclerView
import com.example.newsapp.ui.viewModels.NewsViewModel

class ViewModelInstances {
    companion object{
        fun initUICategories(viewModel: NewsViewModel, fragment: Fragment, recyclerView: RecyclerView, progressBar: ProgressBar, category: String){
            viewModel.getNewsByCategory(category)
            viewModel.newsByCategory.observe(fragment.viewLifecycleOwner){ news ->
                if(news != null){
                    initRecyclerView(news, recyclerView)
                }else{
                    fragment.requireView().findViewById<ConstraintLayout>(R.id.network_error_layout).visibility = View.VISIBLE
                }
            }

            viewModel.isLoading.observe(fragment.viewLifecycleOwner){ isLoading ->
                loading(isLoading, recyclerView, progressBar)
            }

        }
    }
}