package com.nadillla.newsapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nadillla.newsapp.DetailBeritaActivity
import com.nadillla.newsapp.R
import com.nadillla.newsapp.model.Berita
import com.nadillla.newsapp.network.BeritaService
import kotlinx.android.synthetic.main.item_berita.view.*


class BeritaAdapter (var article : ArrayList<Berita>?) : RecyclerView.Adapter<BeritaAdapter.BeritaHolder>(){

    class BeritaHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val img = itemView.itemImg
        val textJudul = itemView.itemJudul
        val textPenulis = itemView.itemPenulis


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeritaAdapter.BeritaHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_berita,parent,false)

        val holder = BeritaHolder(view)
        return  holder
    }

    override fun getItemCount(): Int {

        return article?.size?: 0

    }

    override fun onBindViewHolder(holder: BeritaAdapter.BeritaHolder, position: Int) {

        holder.textJudul.text=article?.get(position)?.title
        holder.textPenulis.text=article?.get(position)?.author

        Glide.with(holder.itemView.context).load(article?.get(position)?.urlToImage).into(holder.img)

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context,DetailBeritaActivity::class.java)

            intent.putExtra("url",article?.get(position)?.url)
            holder.itemView.context.startActivity(intent)


        }
    }


}