package com.example.newsapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.domain.model.News
import com.squareup.picasso.Picasso

class RecyclerNewsAdapter(
    private val newsList: ArrayList<News>,
    private val listener: NewClickListener,
) : RecyclerView.Adapter<RecyclerNewsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_rows_design, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.print(position)
    }

    override fun getItemCount(): Int = newsList.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val titleNews: TextView = itemView.findViewById(R.id.title_news)
        private val descriptionNews: TextView = itemView.findViewById(R.id.description_news)
        private val imageNews: ImageView = itemView.findViewById(R.id.image_news)
        private val publishedNews: TextView = itemView.findViewById(R.id.published_news)

        fun print(position: Int) {

            titleNews.text = newsList[position].title

            if (newsList[position].description?.isNotEmpty() == true) {
                descriptionNews.text = newsList[position].description
            } else {
                descriptionNews.text = "Null"
            }

            if (newsList[position].image?.isNotEmpty() == true) {
                Picasso.get()
                    .load(newsList[position].image)
                    .into(imageNews)
            } else {
                imageNews.scaleType = ImageView.ScaleType.FIT_CENTER
                imageNews.setImageResource(R.drawable.ic_app)
            }

            publishedNews.text = newsList[position].publishedAt

            itemView.setOnClickListener {
                listener.onItemClickListener(newsList[position].url)
            }

        }

    }

}