package com.app.gadspractice

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.lifecycle.Observer
import com.app.gadspractice.Util.debugger
import com.app.gadspractice.ViewModel.ApiViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val homeViewModel by viewModel<ApiViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        homeViewModel.allLearningLeaders.observe(this, Observer {
            debugger("Message->>>$it")
        })
        homeViewModel.allSkillLeaders.observe(this, Observer {
            debugger("Message->>$it")
        })
        return super.onCreateView(name, context, attrs)
    }
}