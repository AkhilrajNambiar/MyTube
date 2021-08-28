package com.example.moviebuff

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.moviebuff.model.actorModel
import com.google.android.material.card.MaterialCardView

class NameAdapter(private val context: Context, private val dataset: List<actorModel>):RecyclerView.Adapter<NameAdapter.NameViewHolder>() {

    class NameViewHolder(view: View): RecyclerView.ViewHolder(view){
        val actorName:TextView = view.findViewById<TextView>(R.id.actor_name)
        val actorImage:ImageView = view.findViewById<ImageView>(R.id.actor_image)
        val actorCard: MaterialCardView = view.findViewById(R.id.actorDetailCard)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return NameViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        val item = dataset[position]
        holder.actorImage.setImageResource(item.actorImageID)
        holder.actorName.text = context.resources.getString(item.actorNameID)
        holder.actorCard.setOnClickListener{
            val action = ActorFragmentDirections.actionActorFragmentToMoviesFragment(actorName = holder.actorName.text.toString())
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}