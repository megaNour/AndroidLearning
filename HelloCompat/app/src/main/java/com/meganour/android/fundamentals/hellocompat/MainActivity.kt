package com.meganour.android.fundamentals.hellocompat

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private val mColorArray = arrayOf(
        "red",
        "pink",
        "purple",
        "deep_purple",
        "indigo",
        "blue",
        "light_blue",
        "cyan",
        "teal",
        "green",
        "light_green",
        "lime",
        "yellow",
        "amber",
        "orange",
        "deep_orange",
        "brown",
        "grey",
        "blue_grey",
        "black"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        savedInstanceState?.getInt("color")?.let { hello_textview.setTextColor(it) }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putInt("color", hello_textview.currentTextColor)
    }

    fun changeColor(view: View) {
        val colorResourceName = resources.getIdentifier(
            mColorArray[Random().nextInt(20)],
            "color",
            applicationContext.packageName
        )
        val color = ContextCompat.getColor(this, colorResourceName);
        hello_textview.setTextColor(color)
    }
}
