package com.assignment.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.assignment.data.repository.Resource
import com.assignment.data.models.Data
import com.assignment.data.models.Images
import com.assignment.data.repository.MainRepository
import kotlinx.coroutines.Dispatchers

class ImageViewModel(private val mainRepository: MainRepository) : ViewModel() {
    private var imageLiveData = MutableLiveData<List<Images>>()

    fun getSearchedImage(searchText: String, sort: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            val response = mainRepository.getSearchImages(searchText, sort, window = "all")
            if(response.success && response.data.isNotEmpty()){
                emit(Resource.success(data = mainRepository.getSearchImages(searchText, sort, window = "all")))
            }else{
                emit(Resource.error(data = null, message = "Error Occurred!"))
            }
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

    fun getImagesOnly(dataList: List<Data>) {
        val imageData = ArrayList<Images>()
        if(dataList.isEmpty()) {
            setImageData(imageData)
            return
        }
        for (item in dataList){
            if(item.images.isEmpty()) {
                setImageData(imageData)
                break
            }
            for (imageUrl in item.images){
                if (imageUrl.type.equals("image/png", true) ||
                    imageUrl.type.equals("image/jpeg", true) ||
                    imageUrl.type.equals("gif", true)){
                    imageData.add(imageUrl)
                }
            }
        }
        setImageData(imageData)
    }

    private fun setImageData(imageData: ArrayList<Images>) {
        imageLiveData.value = imageData
    }

    fun observeMovieLiveData(): LiveData<List<Images>> {
        return imageLiveData
    }
}