package com.example.newsapp.ui.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.domain.model.News
import com.example.newsapp.domain.usecases.GetGeneralNewsUseCase
import com.example.newsapp.domain.usecases.GetNewsByCategoryUseCase
import com.example.newsapp.domain.utilities.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class NewsViewModel
@Inject
constructor(
    private val getGeneralNewsUseCase: GetGeneralNewsUseCase,
    private val getNewsByCategoryUseCase: GetNewsByCategoryUseCase
) : ViewModel() {

    val generalNews = MutableLiveData<ArrayList<News>?>()
    val newsByCategory = MutableLiveData<ArrayList<News>?>()
    val isLoading = MutableLiveData<Boolean>()

    init {
        getGeneralNews()
        isLoading.value = true
    }

    private fun getGeneralNews() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val newsResource = getGeneralNewsUseCase()) {
                is Resource.Success -> withContext(Dispatchers.Main) {
                    generalNews.value = newsResource.data
                    isLoading.value = false
                }
                is Resource.Error -> withContext(Dispatchers.Main) {
                    isLoading.value = false
                    generalNews.value = null
                }
            }
        }
    }

    fun getNewsByCategory(category: String) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val newsResource = getNewsByCategoryUseCase(category)) {
                is Resource.Success -> withContext(Dispatchers.Main) {
                    newsByCategory.value = newsResource.data
                    isLoading.value = false
                }
                is Resource.Error -> withContext(Dispatchers.Main) {
                    newsByCategory.value = null
                    isLoading.value = false
                }
            }
        }
    }

}