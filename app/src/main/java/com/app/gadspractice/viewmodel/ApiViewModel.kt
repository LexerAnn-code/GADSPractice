package com.app.gadspractice.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.gadspractice.network.LeadersApiResponse
import com.app.gadspractice.network.SkillsApiResponse
import com.app.gadspractice.repository.ApiRepository
import com.app.gadspractice.repository.RepositorySubmit
import com.app.gadspractice.util.LoadingState
import com.app.gadspractice.util.debugger
import com.app.gadspractice.repository.ResponsesSubmit
import kotlinx.coroutines.launch

class ApiViewModel(
    private val apiRepository: ApiRepository,
    private val repositorySubmit: RepositorySubmit
) : ViewModel() {
    var email: String? = null
    var firstName: String? = null
    var lastName: String? = null
    var linkToProject: String? = null
    var responseSubmit: ResponsesSubmit? = null
    private val _allLearningLeaders = MutableLiveData<MutableList<LeadersApiResponse>>()
    val allLearningLeaders: LiveData<MutableList<LeadersApiResponse>> get() = _allLearningLeaders

    private val _allSkillLeaders = MutableLiveData<MutableList<SkillsApiResponse>>()
    val allSkillLeaders: LiveData<MutableList<SkillsApiResponse>> get() = _allSkillLeaders

    private val _loadingState = MutableLiveData<LoadingState>()
    val loadingState: LiveData<LoadingState> get() = _loadingState

    //Set ClickListener to submit the work
    private fun submitData() {
        viewModelScope.launch {
            val submitResponse =
                repositorySubmit.submitWork(email, firstName, lastName, linkToProject)
            //responseSubmit?.onSuccess(submitResponse)
            _loadingState.value = LoadingState.success(submitResponse)
        }
    }

    init {
        fetchData()

    }
     fun AoadSkills():LiveData<MutableList<SkillsApiResponse>>{
        viewModelScope.launch {
            _loadingState.value = LoadingState.LOADING
            _allSkillLeaders.postValue(apiRepository.getAllSkillLearners())
            _loadingState.value = LoadingState.LOADED
        }
        return  allSkillLeaders
    }

    private fun fetchData() {
        viewModelScope.launch {
            try {
                _loadingState.value = LoadingState.LOADING
                _allLearningLeaders.postValue(apiRepository.getAllLeadersLearners())

                _loadingState.value = LoadingState.LOADED
                debugger("Reading")
            } catch (e: Exception) {
                _loadingState.value = LoadingState.error(e.message)
                debugger("Error->>>>${e.localizedMessage}")

            }
        }
    }

}