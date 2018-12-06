package com.android.learning.twoactivities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    companion object {
        val LOG_TAG = MainActivity::class.java.simpleName
        val EXTRA_MESSAGE = "com.android.learning.twoactivities.extra.MESSAGE"
        val TEXT_REQUEST = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");
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

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putInt("reply_visible", (text_header_reply.visibility))
        outState?.putString("reply_text", reply_textView.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        text_header_reply.visibility = savedInstanceState?.getInt("reply_visible") ?: View.INVISIBLE
        reply_textView.visibility = text_header_reply.visibility
        reply_textView.text = savedInstanceState?.getString("reply_text")
    }

    public fun launchSecondActivity(view: View) {
        Log.d(LOG_TAG, "launchSecondary")
        intent = Intent(this, Main2Activity::class.java)
        intent.putExtra(EXTRA_MESSAGE, editText_main.text.toString())
        startActivityForResult(intent, TEXT_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                super.onActivityResult(requestCode, resultCode, data)
                text_header_reply.visibility = View.VISIBLE
                reply_textView.text = data?.getStringExtra(Main2Activity.EXTRA_REPLY)
                reply_textView.visibility = View.VISIBLE
            }
        }
    }
}
