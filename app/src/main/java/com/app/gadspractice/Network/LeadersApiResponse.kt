package com.app.gadspractice.Network

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LeadersApiResponse(
@SerializedName("name")
@Expose
val name:String,
@SerializedName("hours")
@Expose
val hours:String,
@SerializedName("country")
@Expose
val country:String,
@SerializedName("badgeUrl")
@Expose
val badgeUrl:String
):Parcelable