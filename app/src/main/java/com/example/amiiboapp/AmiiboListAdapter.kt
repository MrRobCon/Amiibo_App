package com.example.amiiboapp

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.amiiboapp.data.AmiiboEntity
import com.example.amiiboapp.databinding.ListItemBinding

class AmiiboListAdapter(private val amiiboList: List<AmiiboEntity>) :
    RecyclerView.Adapter<AmiiboListAdapter.ViewHolder>() {

    val selectedAmiibo = arrayListOf<AmiiboEntity>()

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val binding = ListItemBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val amiibo = amiiboList[position]
        with(holder.binding) {
            nameText.text = amiibo.name
        }
    }

    override fun getItemCount() = amiiboList.size

}