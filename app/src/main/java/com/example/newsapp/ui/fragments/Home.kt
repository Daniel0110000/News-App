package com.example.newsapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.R
import com.example.newsapp.databinding.FragmentHomeBinding
import com.example.newsapp.domain.model.News
import com.example.newsapp.ui.adapters.RecyclerNewsAdapter
import com.example.newsapp.ui.viewModels.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Home : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: NewsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        initUI()

        return binding.root

    }

    private fun initUI(){
        viewModel.generalNews.observe(viewLifecycleOwner){ news ->
            if(news != null){
                initRecyclerView(news)
            }else{
                view?.findViewById<ConstraintLayout>(R.id.network_error_layout)!!.visibility = View.VISIBLE
            }
        }

        viewModel.isLoading.observe(viewLifecycleOwner){ isLoading ->
            if(isLoading){
                binding.homeProgressBar.visibility = View.VISIBLE
                binding.recyclerGeneralNews.visibility = View.GONE
            }else{
                binding.homeProgressBar.visibility = View.GONE
                binding.recyclerGeneralNews.visibility = View.VISIBLE
            }
        }

    }

    private fun initRecyclerView(newsList: ArrayList<News>){
        binding.recyclerGeneralNews.apply {
            hasFixedSize()
            layoutManager = LinearLayoutManager(context)
            adapter = RecyclerNewsAdapter(newsList)
        }
    }


}