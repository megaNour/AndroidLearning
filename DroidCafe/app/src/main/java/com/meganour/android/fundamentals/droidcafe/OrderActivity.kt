package com.meganour.android.fundamentals.droidcafe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_order.*
import android.widget.ArrayAdapter



class OrderActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    companion object {
       var activated = false
    }
    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if (activated) toastIt(parent?.getItemAtPosition(position).toString())
        activated = true
    }

    private lateinit var order: String
    private var deliveryMode: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        order = intent.getStringExtra(MainActivity.EXTRA_ORDER)
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.labels_array,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        label_spinner.adapter = adapter
        label_spinner.onItemSelectedListener = this
    }

    fun onRadioButtonClicked(view: View) {
        when(view) {
            sameday -> toastIt(sameday.text.toString())
            nextday -> toastIt(nextday.text.toString())
            pickup -> toastIt(pickup.text.toString())
            else -> { toastIt("default") }
        }
    }

    fun toastIt(message: String): String {
        Toast.makeText(
            applicationContext,
            message,
            Toast.LENGTH_SHORT
        )
            .show()
        return message
    }
}
