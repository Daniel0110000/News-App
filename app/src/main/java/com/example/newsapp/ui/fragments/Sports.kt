package com.example.newsapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.newsapp.R
import com.example.newsapp.databinding.FragmentSportsBinding
import com.example.newsapp.domain.utilities.Constants.SPORTS
import com.example.newsapp.ui.commons.ViewModelInstances.Companion.initUICategories
import com.example.newsapp.ui.viewModels.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Sports : Fragment() {

    private var _binding: FragmentSportsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: NewsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSportsBinding.inflate(inflater, container, false)

        initUICategories(
            viewModel,
            this,
            binding.recyclerSports,
            binding.sportsProgressBar,
            SPORTS
        )

        return binding.root

    }
}