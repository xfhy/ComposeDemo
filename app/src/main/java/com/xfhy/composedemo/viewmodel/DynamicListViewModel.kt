package com.xfhy.composedemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author : guoliang08
 * Create time : 2024/12/4 19:04
 * Description :
 */
class DynamicListViewModel : ViewModel() {

    val items = MutableLiveData<List<String>>().apply {
        value = listOf("Item 1", "Item 2")
    }

    fun addItem(item: String) {
        items.value?.let {
            val newList = it.toMutableList()
            newList.add(item)
            items.postValue(newList)
        }
    }

}