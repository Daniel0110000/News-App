package com.example.newsapp.ui.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.domain.model.News
import com.example.newsapp.domain.usecases.GetNewsUseCase
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
        private val getNewsUseCase: GetNewsUseCase
    ): ViewModel() {

    val generalNews = MutableLiveData<ArrayList<News>?>()
    val isLoading = MutableLiveData<Boolean>()

    init {
        getGeneralNews()
        isLoading.value = true
    }

    private fun getGeneralNews(){
        viewModelScope.launch(Dispatchers.IO) {
            when(val newsResource = getNewsUseCase()){
                is Resource.Success -> withContext(Dispatchers.Main){
                    generalNews.value = newsResource.data
                    isLoading.value = false
                }
                is Resource.Error -> withContext(Dispatchers.Main){
                    isLoading.value = false
                    generalNews.value = null
                }
            }
        }
    }

}