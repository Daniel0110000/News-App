package com.example.newsapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.R
import com.example.newsapp.databinding.FragmentScienceBinding
import com.example.newsapp.domain.model.News
import com.example.newsapp.domain.utilities.Constants.SCIENCE
import com.example.newsapp.ui.adapters.RecyclerNewsAdapter
import com.example.newsapp.ui.commons.ViewModelInstances.Companion.initUICategories
import com.example.newsapp.ui.viewModels.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Science : Fragment() {

    private var _binding: FragmentScienceBinding? = null
    private val binding get() = _binding!!

    private val viewModel: NewsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentScienceBinding.inflate(inflater, container, false)

        initUICategories(
            viewModel,
            this,
            binding.recyclerScience,
            binding.scienceProgressBar,
            SCIENCE
        )

        return binding.root

    }
}