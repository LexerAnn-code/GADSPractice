package com.app.gadspractice.network

import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface GadsApi {
//Making a GET request to the Learning Leaders api

 @GET("/api/hours")
  fun getLearningLeaders():Deferred<MutableList<LeadersApiResponse>>
@GET(" /api/skilliq")
suspend fun  getAllTopSkill():Deferred<MutableList<SkillsApiResponse>>


}