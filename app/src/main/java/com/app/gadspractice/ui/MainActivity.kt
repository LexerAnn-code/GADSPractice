package com.app.gadspractice.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.gadspractice.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager.adapter=MyFragmentAdapter(supportFragmentManager)
tablayout.setupWithViewPager(viewPager)

    }


    override fun onBackPressed() {
        finish()
    }
}