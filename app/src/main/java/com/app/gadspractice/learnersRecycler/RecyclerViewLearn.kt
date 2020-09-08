package com.app.gadspractice.learnersRecycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.app.gadspractice.network.LeadersApiResponse
import com.app.gadspractice.databinding.LeaningitemBinding


class RecyclerViewLearn :androidx.recyclerview.widget.ListAdapter<LeadersApiResponse, ViewHolderLearn>(
DIF_UTIL) {
    companion object{
        private val DIF_UTIL:DiffUtil.ItemCallback<LeadersApiResponse> =
            object:DiffUtil.ItemCallback<LeadersApiResponse>(){
                override fun areItemsTheSame(
                    oldItem: LeadersApiResponse, newItem: LeadersApiResponse ): Boolean =oldItem.name==newItem.name
                override fun areContentsTheSame(
                    oldItem: LeadersApiResponse, newItem: LeadersApiResponse
                ): Boolean =oldItem.hours==newItem.hours
            }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderLearn {
        val layoutInflater= LayoutInflater.from(parent.context)
        val binding= LeaningitemBinding.inflate(layoutInflater)
        return ViewHolderLearn(binding)
    }
    override fun onBindViewHolder(holder:ViewHolderLearn, position: Int) {
        val current=getItem(position)
        holder.binding.learningData=current
        holder.binding.executePendingBindings()

    }
}