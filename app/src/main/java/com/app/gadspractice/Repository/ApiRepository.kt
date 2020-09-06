package com.app.gadspractice.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.gadspractice.Network.GadsApi
import com.app.gadspractice.Network.LeadersApiResponse
import com.app.gadspractice.Network.SkillsApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ApiRepository (private val gadsApi: GadsApi){
suspend fun getAllLeadersLearners():MutableList<LeadersApiResponse>{
return gadsApi.getLearningLeaders()
}
    suspend fun  getAllSkillLearners():MutableList<SkillsApiResponse>{
        return    gadsApi.getAllTopSkill()
        }
}