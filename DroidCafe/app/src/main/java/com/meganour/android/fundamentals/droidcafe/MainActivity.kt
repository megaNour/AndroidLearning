package com.meganour.android.fundamentals.droidcafe

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        val EXTRA_ORDER = "extra.main.order"
    }

    private var order: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
/*
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
       }*/
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    fun orderDonut(view: View) {
        order = toastIt(getString(R.string.donut_order_message))
    }

    fun orderIcecreamSandwitch(view: View) {
        order = toastIt(getString(R.string.ice_cream_order_message))
    }

    fun orderFroyo(view: View) {
        order = toastIt(getString(R.string.froyo_order_message))
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

    fun order(view: View) {
        order?.let {
            intent = Intent(this, OrderActivity::class.java)
            intent.putExtra(EXTRA_ORDER, order)
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_order -> {
                toastIt(getString(R.string.order_action))
                order?.let {
                    intent = Intent(this, OrderActivity::class.java)
                    intent.putExtra(EXTRA_ORDER, order)
                    startActivity(intent)
                }
            }
            R.id.action_status -> toastIt(getString(R.string.status_action))
            R.id.action_favorite -> toastIt(getString(R.string.favorite_action))
            R.id.action_contact -> toastIt(getString(R.string.contact_action))
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        return super.onContextItemSelected(item)
    }

}
