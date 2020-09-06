package com.app.gadspractice.Network

import androidx.lifecycle.LiveData
import retrofit2.http.GET

interface GadsApi {
//Making a GET request to the Learning Leaders api
 @GET("/api/hours")
 suspend fun getLearningLeaders():MutableList<LeadersApiResponse>
@GET(" /api/skilliq")
suspend fun  getAllTopSkill():MutableList<SkillsApiResponse>

}