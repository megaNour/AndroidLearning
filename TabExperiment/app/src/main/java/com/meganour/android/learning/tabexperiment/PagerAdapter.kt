package com.meganour.android.learning.tabexperiment

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter


class PagerAdapter(fm: FragmentManager, internal var mNumOfTabs: Int) : FragmentStatePagerAdapter(fm) {

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    override fun getItem(position: Int): Fragment? {
        when(position) {
            0 -> return TabFragment1()
            1 -> return TabFragment2()
            2 -> return TabFragment3()
        }
        return null
    }

    /**
     * Return the number of views available.
     */
    override fun getCount(): Int {
        return mNumOfTabs
    }
}