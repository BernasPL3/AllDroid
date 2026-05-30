package com.alldroid.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RomAdapter(
    private val roms: List<Rom>
) : RecyclerView.Adapter<RomAdapter.RomViewHolder>() {

    class RomViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView) {

        val cover: ImageView =
            itemView.findViewById(R.id.imgCover)

        val title: TextView =
            itemView.findViewById(R.id.txtTitle)

        val system: TextView =
            itemView.findViewById(R.id.txtSystem)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RomViewHolder {

        val view = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.item_rom,
                parent,
                false
            )

        return RomViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: RomViewHolder,
        position: Int
    ) {

        val rom = roms[position]

        holder.title.text = rom.title
        holder.system.text = rom.system
        holder.cover.setImageResource(
            rom.coverRes
        )
    }

    override fun getItemCount(): Int {
        return roms.size
    }
}
