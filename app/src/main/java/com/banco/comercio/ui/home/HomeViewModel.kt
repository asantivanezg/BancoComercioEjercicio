package com.banco.comercio.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.banco.comercio.data.repository.UserDataRepository
import com.banco.comercio.domain.model.User
import com.banco.comercio.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repo: UserDataRepository) : ViewModel() {

    private val _userList = MutableLiveData<Resource<List<User>>>()
    val userList: LiveData<Resource<List<User>>> get() = _userList

    fun getUserList() {
        val job = viewModelScope.launch(Dispatchers.IO) {
            _userList.postValue(Resource.loading())
            val res = repo.getUserList()
            _userList.postValue(res)
        }
    }
}