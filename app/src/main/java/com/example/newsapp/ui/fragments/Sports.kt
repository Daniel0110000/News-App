package com.example.newsapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.newsapp.databinding.FragmentSportsBinding
import com.example.newsapp.domain.utilities.Constants.SPORTS
import com.example.newsapp.ui.common.DisplayingFragmentElementsIns
import com.example.newsapp.ui.viewModels.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Sports : Fragment() {

    private var _binding: FragmentSportsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: NewsViewModel by viewModels()

    private lateinit var displayingFragmentElementsIns: DisplayingFragmentElementsIns

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSportsBinding.inflate(inflater, container, false)

        displayingFragmentElementsIns = DisplayingFragmentElementsIns(
            viewModel,
            this,
            binding.recyclerSports,
            binding.sportsProgressBar,
            SPORTS
        )

        displayingFragmentElementsIns.initUICategories()

        return binding.root

    }
}