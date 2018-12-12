package com.meganour.android.fundamentals.recyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import java.util.*
import android.view.LayoutInflater
import android.widget.TextView

class WordListAdapter
    (val mContext: Context, val mWordList: LinkedList<String>) :
    RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {

    val mInflater = LayoutInflater.from(mContext)

    override fun getItemCount(): Int {
        return mWordList.size
    }

    override fun onBindViewHolder(holder: WordListAdapter.WordViewHolder, position: Int) {
        val mCurrent = mWordList.get(position)
        holder.wordItemView.text = mCurrent
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordListAdapter.WordViewHolder {
        val mItemView = mInflater.inflate(R.layout.wordlist_item, parent, false)
        return WordViewHolder(mItemView, this)
    }

    inner class WordViewHolder(viewItemView: View, adapter: WordListAdapter) : RecyclerView.ViewHolder(viewItemView),
        View.OnClickListener {

        val wordItemView: TextView = itemView.findViewById(R.id.word);
        val mAdapter = adapter

        init{
            wordItemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            mWordList.set(layoutPosition, "Clicked " + wordItemView.text)
            mAdapter.notifyDataSetChanged()
        }
    }

}