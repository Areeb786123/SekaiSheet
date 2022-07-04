package com.areeb.sekaisheet.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.areeb.sekaisheet.Activites.DetailsActivity

import com.areeb.sekaisheet.R
import com.areeb.sekaisheet.UnsplashModels.UnsplashModelsItem
import com.bumptech.glide.Glide


class homeAdapter(
    var context: Context,
) : RecyclerView.Adapter<homeAdapter.ViewHolder>() {


    var ImagesListOfPixa = listOf<UnsplashModelsItem>()
    private val dummyList = arrayListOf("hhe;", "secon", "three", "ogjfgnjfn")


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var wallpaper_img = itemView.findViewById<ImageView>(R.id.wallpaper_img)
        var photographer = itemView.findViewById<TextView>(R.id.photographerName)
        var recyclerItemUrl = itemView.findViewById<CardView>(R.id.shim_home_recy_item)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.home_item_view, parent, false)

        val viewHolder = ViewHolder(view)

        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var ImageList: UnsplashModelsItem = ImagesListOfPixa.get(position)
//        holder.photographer.setText(List.user.name)
        Glide.with(context).load(ImageList.urls.regular).into(holder.wallpaper_img);

        holder.photographer.setText(ImageList.user.name)

        holder.recyclerItemUrl.setOnClickListener {
            var DetailsActivityIntent = Intent(context,DetailsActivity::class.java)
            DetailsActivityIntent.putExtra("wallpaper_link",ImageList.urls.full)
            context.startActivity(DetailsActivityIntent)
        }



//
//        holder.photographer.setText(dummyList[position])


    }

    override fun getItemCount(): Int {
        return ImagesListOfPixa.size
    }


}