package com.app.gadspractice.learnersRecycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.app.gadspractice.network.LeadersApiResponse
import com.app.gadspractice.databinding.LeaningitemBinding
import com.app.gadspractice.databinding.TopskillitemBinding
import com.app.gadspractice.network.SkillsApiResponse


class RecyclerViewSkill :androidx.recyclerview.widget.ListAdapter<SkillsApiResponse, ViewHolderSkill>(
    DIFF_UTIL) {
    companion object{
        private val DIFF_UTIL:DiffUtil.ItemCallback<SkillsApiResponse> =
            object:DiffUtil.ItemCallback<SkillsApiResponse>(){
                override fun areItemsTheSame(
                    oldItem: SkillsApiResponse,
                    newItem: SkillsApiResponse
                ): Boolean {
                    return oldItem.name==newItem.name
                }
                override fun areContentsTheSame(
                    oldItem: SkillsApiResponse,
                    newItem: SkillsApiResponse
                ): Boolean {
                    return oldItem == newItem
                }

            }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderSkill {
        val layoutInflater= LayoutInflater.from(parent.context)
        val binding= TopskillitemBinding.inflate(layoutInflater)
        return ViewHolderSkill(binding)
    }
    override fun onBindViewHolder(holder:ViewHolderSkill, position: Int) {
        val current=getItem(position)
        holder.binding.learningSkill=current
        holder.binding.executePendingBindings()

    }
}