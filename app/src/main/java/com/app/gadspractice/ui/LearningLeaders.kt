package com.app.gadspractice.ui
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.app.gadspractice.learnersRecycler.RecyclerViewLearn
import com.app.gadspractice.R
import com.app.gadspractice.util.debugger
import com.app.gadspractice.viewmodel.ApiViewModel
import com.app.gadspractice.databinding.FrraglearnBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class LearningLeaders : Fragment() {
    private lateinit var binding:FrraglearnBinding
    private lateinit var adapter: RecyclerViewLearn
    val viewModelsy by viewModel<ApiViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.frraglearn, container, false)
        adapter= RecyclerViewLearn()
        binding.adapterLearn=adapter
       binding.viewModel=viewModelsy
        binding.lifecycleOwner=viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
viewModelsy.allLearningLeaders.observe(viewLifecycleOwner, Observer {
adapter.submitList(it)
    debugger("LEARN->>>$it")
})
        super.onViewCreated(view, savedInstanceState)
    }

}