package com.example.newsapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.newsapp.R
import com.example.newsapp.databinding.FragmentTechnologyBinding
import com.example.newsapp.domain.model.News
import com.example.newsapp.ui.commons.ViewModelInstances.Companion.initUICategories
import com.example.newsapp.ui.viewModels.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Technology : Fragment() {

    private var _binding: FragmentTechnologyBinding? = null
    private val binding get() = _binding!!

    private val viewModel: NewsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentTechnologyBinding.inflate(inflater, container, false)

        initUICategories(
            viewModel,
            this,
            binding.recyclerTechnology,
            binding.technologyProgressBar,
            "technology"
        )

        return binding.root

    }

}