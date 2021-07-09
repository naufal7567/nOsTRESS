package org.nostress.behappy.viewpager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import org.nostress.behappy.R

class ViewPagerAdapter_Gejala_Stres(private val title: List<String>, private val image: List<Int>)
    : RecyclerView.Adapter<ViewPagerAdapter_Gejala_Stres.Pager2ViewHolder>() {

    inner class Pager2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val itemTitle: TextView = itemView.findViewById(R.id.tvTitle_gejala_stres)
        val itemImage: ImageView = itemView.findViewById(R.id.iv_info_gejala_stres)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewPagerAdapter_Gejala_Stres.Pager2ViewHolder {
        return Pager2ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_info_gejala_stres, parent, false))
    }

    override fun onBindViewHolder(
        holder: ViewPagerAdapter_Gejala_Stres.Pager2ViewHolder,
        position: Int
    ) {
        holder.itemTitle.text = title[position]
        holder.itemImage.setImageResource(image[position])
    }

    override fun getItemCount(): Int {
        return title.size
    }

}