package com.example.newsapp.ui.commons

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.domain.model.News
import com.example.newsapp.ui.adapters.RecyclerNewsAdapter

class RecyclerViewIns {

    companion object{
        fun initRecyclerView(newsList: ArrayList<News>, recyclerView: RecyclerView){
            recyclerView.apply {
                hasFixedSize()
                layoutManager = LinearLayoutManager(context)
                adapter = RecyclerNewsAdapter(newsList)
            }
        }
    }

}