package com.app.gadspractice.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.app.gadspractice.R
import com.app.gadspractice.databinding.FragmentSkilliqLeadersBinding
import com.app.gadspractice.databinding.FragskillBinding
import com.app.gadspractice.databinding.FrraglearnBinding
import com.app.gadspractice.learnersRecycler.RecyclerViewLearn
import com.app.gadspractice.learnersRecycler.RecyclerViewSkill
import com.app.gadspractice.util.debugger
import com.app.gadspractice.viewmodel.ApiViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SkilliqLeaders : Fragment() {
    private lateinit var binding:FragskillBinding
    private lateinit var adapter: RecyclerViewSkill
    val viewModelsy by viewModel<ApiViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragskill, container, false)
        adapter= RecyclerViewSkill()
        binding.adapterSkill=adapter
        binding.viewModel=viewModelsy
        binding.lifecycleOwner=viewLifecycleOwner


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModelsy.AoadSkills().observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
            debugger("LEARN->>>$it")
        })

        super.onViewCreated(view, savedInstanceState)
    }
    }