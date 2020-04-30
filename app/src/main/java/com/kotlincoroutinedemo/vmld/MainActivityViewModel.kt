package com.kotlincoroutinedemo.vmld

import androidx.lifecycle.*
import com.kotlincoroutinedemo.UserRepository
import kotlinx.coroutines.Dispatchers

/**
 * Created by Mayur Solanki (mayursolanki120@gmail.com) on 30/04/20, 6:02 PM.
 */
class MainActivityViewModel : ViewModel() {

     var userRepository = UserRepository()
//     var liveData : MutableLiveData<List<User>> = MutableLiveData()

    var user : LiveData<List<User>>  = liveData<List<User>>(Dispatchers.IO) {
        var result = userRepository.getDataFromApi()
        emit(result)
    }


//    fun callApiGetUserData(){
//        // Automatically manage according to viewmodel lifecycle, dispose on viewmodel clear
//        viewModelScope.launch(){
//            var userList : List<User>? = null
//            withContext(Dispatchers.IO) {
//                userList  = userRepository.getDataFromApi()
//            }
//
//            liveData.value = userList
//        }
//    }

}