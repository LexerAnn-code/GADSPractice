package com.app.gadspractice.repository

import androidx.lifecycle.LiveData

interface ResponsesSubmit {
fun onSuccess(loginResponse:LiveData<String>)
}