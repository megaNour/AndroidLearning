package com.meganour.android.fundamentals.implicitintentreceiver

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        intent.data?.let {uri ->
            text_uri_message.text = "URI " + uri.toString()
        }
    }
}
