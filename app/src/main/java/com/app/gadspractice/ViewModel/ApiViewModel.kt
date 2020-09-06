package com.app.gadspractice.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.gadspractice.Network.LeadersApiResponse
import com.app.gadspractice.Network.SkillsApiResponse
import com.app.gadspractice.Repository.ApiRepository
import com.app.gadspractice.Util.debugger
import kotlinx.coroutines.launch
import java.lang.Exception

class ApiViewModel (private val apiRepository: ApiRepository):ViewModel(){

    private val _allLearningLeaders = MutableLiveData<MutableList<LeadersApiResponse>>()
    val allLearningLeaders: LiveData<MutableList<LeadersApiResponse>> get() = _allLearningLeaders

    private val _allSkillLeaders = MutableLiveData<MutableList<SkillsApiResponse>>()
    val allSkillLeaders: LiveData<MutableList<SkillsApiResponse>> get() = _allSkillLeaders


    init {
fetchData()

}

    private fun fetchData() {
viewModelScope.launch {
try {
    _allLearningLeaders.postValue(apiRepository.getAllLeadersLearners());
    _allSkillLeaders.postValue(apiRepository.getAllSkillLearners())
    debugger("Reading")
}
catch (e:Exception){

}
}
    }

}