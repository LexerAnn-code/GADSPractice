package com.app.gadspractice.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyFragmentAdapter (fm:FragmentManager):FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> LearningLeaders()
            else -> return SkilliqLeaders()


        }
    }

    override fun getCount(): Int {
        return 2
    }


    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Learning Leaders"
            else -> return "Skill IQ Leaders"
        }
    }
}