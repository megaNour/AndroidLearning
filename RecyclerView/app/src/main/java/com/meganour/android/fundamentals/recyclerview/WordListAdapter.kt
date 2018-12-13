package com.meganour.android.fundamentals.recyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import java.util.*
import android.view.LayoutInflater
import android.widget.TextView

class WordListAdapter
    (val mContext: Context, val mWordList: LinkedList<String>) :
    RecyclerView.Adapter<WordListAdapter.WordViewHolder>()
    , View.OnClickListener{

    private val positionMap : MutableMap<View, WordViewHolder> =  HashMap()

    override fun onClick(v: View?) {
        val layoutPosition = positionMap.get(v)?.layoutPosition
        val textView = v as TextView
        layoutPosition?.let {
            mWordList.set(it, "Clicked " + textView.text)
        }
        notifyDataSetChanged()
    }

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
        val wordViewHolder = WordViewHolder(mItemView, this)
        return wordViewHolder
    }

    inner class WordViewHolder(itemView: View, val adapter: WordListAdapter) : RecyclerView.ViewHolder(itemView)
    {

        val wordItemView: TextView = itemView.findViewById(R.id.word)

        init{
            positionMap.put(wordItemView, this)
            wordItemView.setOnClickListener(adapter)
        }
    }

}