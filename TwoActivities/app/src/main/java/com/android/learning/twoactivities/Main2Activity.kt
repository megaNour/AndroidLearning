package com.android.learning.twoactivities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main2.*


class Main2Activity : AppCompatActivity() {

    companion object {
        val EXTRA_REPLY = "com.android.learning.twoactivities.extra.REPLY"
        val LOG_TAG = Main2Activity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        received_textView.text = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)
    }

    fun returnReply(view: View) {
        intent = Intent()
        intent.putExtra(EXTRA_REPLY, editText_second.text.toString())
        setResult(RESULT_OK, intent)
        Log.d(LOG_TAG, "End Main2")
        finish()
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(LOG_TAG, "onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "onDestroy")
    }
}
