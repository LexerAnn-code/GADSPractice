package com.app.gadspractice.network
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface GadsSubmitApi {

    companion object{
        const val formResponse="formResponse"
    }
    @FormUrlEncoded
    @POST()
   suspend fun SubmitWork(
       // @Url url:String,
        @Field("Email Address")emailAddress:String?,
        @Field("Name")name:String?,
        @Field("Last Name")lastName:String?,
        @Field("Link to project")LinkToProject:String?

    ):Call<ResponseBody>}








