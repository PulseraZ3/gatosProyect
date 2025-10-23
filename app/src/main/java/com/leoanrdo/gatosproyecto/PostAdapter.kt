package com.leoanrdo.gatosproyecto

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(private val listarPost: List<Post>): RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    class PostViewHolder(val view: View): RecyclerView.ViewHolder(view){
        val tvNombreUser = view.findViewById<TextView>(R.id.tvNombreUser)
        val tvNombreRealUser = view.findViewById<TextView>(R.id.tvNombreRealUser)
        val tvContenido = view.findViewById<TextView>(R.id.tvContenido)
        val cbLike = view.findViewById<CheckBox>(R.id.cbLike)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post,
                parent,
                false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val postActual = listarPost[position]
        holder.tvNombreUser.text = postActual.name
        holder.tvNombreRealUser.text = postActual.username
        holder.tvContenido.text = postActual.content
        holder.cbLike.text = postActual.likes.toString()
    }

    override fun getItemCount(): Int {
        return listarPost.size
    }



}