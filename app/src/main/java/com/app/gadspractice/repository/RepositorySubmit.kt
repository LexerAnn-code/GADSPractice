package com.app.gadspractice.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.gadspractice.network.GadsSubmitApi
import com.app.gadspractice.util.debugger
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response

class RepositorySubmit (private val gadsSubmitApi: GadsSubmitApi){
    companion object{
        const val url="https://docs.google.com/forms/d/e/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse"
    }
    val submitLoginResponse=MutableLiveData<String>()
    suspend fun submitWork(emailAddress:String?,name:String?,lastName:String?,LinkToProject:String?):LiveData<String>{
        gadsSubmitApi.SubmitWork(emailAddress,name,lastName,LinkToProject).enqueue(object : retrofit2.Callback<ResponseBody>{
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    submitLoginResponse.value=t.message
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
if (response.isSuccessful){
    submitLoginResponse.value=response.body()?.string()
        debugger("${response.body().toString()}")
}
                else{
    submitLoginResponse.value=response.errorBody()?.string()
}
            }

        })
return submitLoginResponse
    }

}