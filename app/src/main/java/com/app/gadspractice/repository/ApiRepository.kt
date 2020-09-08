package com.app.gadspractice.repository

import com.app.gadspractice.network.GadsApi
import com.app.gadspractice.network.LeadersApiResponse
import com.app.gadspractice.network.SkillsApiResponse
import com.app.gadspractice.util.debugger

class ApiRepository ( val gadsApi: GadsApi){
suspend fun getAllLeadersLearners():MutableList<LeadersApiResponse>{
return gadsApi.getLearningLeaders().await()
}
    suspend fun  getAllSkillLearners():MutableList<SkillsApiResponse>{
        debugger("Reading 2")
        return    gadsApi.getAllTopSkill().await()

        }
}