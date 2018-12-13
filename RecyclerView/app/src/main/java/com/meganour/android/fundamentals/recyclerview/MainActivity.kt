package com.meganour.android.fundamentals.recyclerview

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private val mWordList = LinkedList<String>()
    lateinit private var mAdapter : WordListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        for (i in 0..19) {
            mWordList.addLast("Word $i")
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            val listSize = mWordList.size
            mWordList.addLast("Added " + mWordList.size)
//            Snackbar.make(view, "Added a new word !", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
            mAdapter.notifyItemInserted(listSize)
            mRecyclerView.smoothScrollToPosition(listSize)
        }

        mAdapter = WordListAdapter(this, mWordList)
        mRecyclerView.adapter = mAdapter
        mRecyclerView.layoutManager = LinearLayoutManager(this)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
