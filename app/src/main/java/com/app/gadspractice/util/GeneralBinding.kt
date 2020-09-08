package com.app.gadspractice.util

import android.widget.ImageView
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

@BindingAdapter("setImageUrl")
fun setImages(imageView: ImageView,url:String?){
    Glide.with(imageView.context)
        .load(url)
        .into(imageView)
}
@BindingAdapter("setAdapter")
fun recyclerView(recyclerNews:RecyclerView,adapter: RecyclerView.Adapter<*>) {
    recyclerNews.adapter= adapter
}
@BindingAdapter(value = ["setupVisibility"])
fun ProgressBar.progressVisibility(loadingState: LoadingState?){
    loadingState?.let {
        isVisible = when(it?.status){
            LoadingState.Status.RUNNING -> true
            LoadingState.Status.SUCCESS -> false
            LoadingState.Status.FAILED->false
            else -> false
        }
    }
}