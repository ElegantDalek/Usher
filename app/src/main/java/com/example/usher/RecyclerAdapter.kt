package com.example.usher

import android.content.Intent
import android.media.Image
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView


const val TITLE_INTENT = "title_message"

class CardData (private val title: String, private val description: String, private val image: Int)

class RecyclerAdapter (private val dataSet: List<String>):

    RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {

    class RecyclerViewHolder(val view: MaterialCardView): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val cardView = LayoutInflater.from(parent.context)
            .inflate(R.layout.big_card, parent, false) as MaterialCardView

        return RecyclerViewHolder(cardView)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val text: TextView = holder.view.findViewById(R.id.big_card_text_title)
        val image: ImageView = holder.view.findViewById(R.id.image_bigcard)
        val title = dataSet[position]
        text.text = title
//        if (position == 0) image.setImageResource(R.drawable.bookbinder)

        holder.view.setOnClickListener {
            val context = it.context
//            val intent = Intent(context, InfoActivity::class.java)
//            intent.putExtra(TITLE_INTENT, title)
//            context.startActivity(intent)
        }
    }
}