package com.app.gadspractice.network

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SubmitInfo(
  @SerializedName("Email Address")
  @Expose
  val emailAddress:String,
  @SerializedName("Name")
  @Expose
  val name:String,
  @SerializedName("Last Name")
  @Expose
  val lastName:String,
  @SerializedName("Link to project")
  @Expose
  val linkToProject:String

):Parcelable
