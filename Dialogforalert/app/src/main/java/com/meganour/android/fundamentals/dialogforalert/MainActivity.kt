package com.meganour.android.fundamentals.dialogforalert

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickAlertMe(view: View) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.alert_title))
        builder.setMessage(getString(R.string.alert_prompt))
        builder.setPositiveButton(getString(R.string.ok_button)) { dialog, which ->
            Toast.makeText(
                applicationContext,
                getString(R.string.ok_pressed),
                Toast.LENGTH_SHORT
            ).show()
        }
        builder.setNegativeButton(getString(R.string.cancel_button)) { dialog, which ->
            Toast.makeText(
                applicationContext,
                getString(R.string.cancel_pressed),
                Toast.LENGTH_SHORT
            ).show()
        }
        builder.show()
    }
}
