package com.example.newsapp.ui.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.domain.model.News
import com.example.newsapp.domain.usecases.SearchNewsUseCase
import com.example.newsapp.domain.utilities.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SearchNewsViewModel
    @Inject
    constructor(
        private val searchNewsUseCase: SearchNewsUseCase
    ): ViewModel() {

    val q = MutableLiveData<String>()
    val searchNewsResult = MutableLiveData<ArrayList<News>?>()
    val isEmptyData = MutableLiveData<Boolean>()

    init {
        q.value = ""
    }

    fun search(){
        viewModelScope.launch(Dispatchers.IO) {
            if(q.value?.isNotEmpty() == true){
                when (val newsResource = searchNewsUseCase(q.value!!)){
                    is Resource.Success -> withContext(Dispatchers.Main){
                        searchNewsResult.value = newsResource.data
                    }
                    is Resource.Error -> withContext(Dispatchers.Main){
                        searchNewsResult.value = null
                    }
                }
            }else{
                withContext(Dispatchers.Main){
                    isEmptyData.value = true
                }
            }
        }
    }

}