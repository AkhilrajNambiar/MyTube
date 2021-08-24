package com.example.wordsappfromscratch

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class WordAdapter(private val letterID: String, private val context: Context): RecyclerView.Adapter<WordAdapter.WordViewHolder>(){

    private val filteredWords: List<String>
    init {
        val allWords = context.resources.getStringArray(R.array.words).toList()

        filteredWords = allWords
            .filter { it.startsWith(letterID, ignoreCase = true)}
            .shuffled()
            .take(5)
            .sorted()
    }

    class WordViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val button: Button =  view.findViewById(R.id.buttons)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return WordViewHolder(layout)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val item = filteredWords[position]
        holder.button.text = item
        val context = holder.itemView.context
        holder.button.setOnClickListener{
            val queryURL: Uri = Uri.parse("${WordListFragment.SEARCH_PREFIX}${item}")
            //Setting up the intent to call this query URL
            val intent = Intent(Intent.ACTION_VIEW, queryURL)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return filteredWords.size
    }
}