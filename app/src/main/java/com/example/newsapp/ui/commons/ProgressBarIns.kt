package com.example.newsapp.ui.commons

import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView

class ProgressBarIns {

    companion object{
        fun loading(isLoading: Boolean, recyclerView: RecyclerView, progressBar: ProgressBar){
            if(isLoading){
                progressBar.visibility = View.VISIBLE
                recyclerView.visibility = View.GONE
            }else{
                progressBar.visibility = View.GONE
                recyclerView.visibility = View.VISIBLE
            }
        }
    }

}