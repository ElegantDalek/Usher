package com.example.usher

import android.content.Intent
import android.media.Image
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView


class TicketAdapter (private val dataSet: List<String>):

    RecyclerView.Adapter<TicketAdapter.TicketViewHolder>() {

    class TicketViewHolder(val view: MaterialCardView): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketViewHolder {
        val cardView = LayoutInflater.from(parent.context)
            .inflate(R.layout.ticket_card, parent, false) as MaterialCardView

        return TicketViewHolder(cardView)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: TicketViewHolder, position: Int) {
        val text: TextView = holder.view.findViewById(R.id.ticket_name)
        val image: ImageView = holder.view.findViewById(R.id.ticket_qr)
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