package com.example.breakingbad

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.breakingbad.data.CharacterEntity
import com.example.breakingbad.databinding.ListItemBinding

class CharacterListAdapter(private val characterList: List<CharacterEntity>,
                           private val listener: ListItemListener) :

    RecyclerView.Adapter<CharacterListAdapter.ViewHolder>() {

    val selectedCharacter = arrayListOf<CharacterEntity>()

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
        val character = characterList[position]
        with(holder.binding) {
            nameText.text = character.name
            root.setOnClickListener{
                listener.onItemClick(character)
            }
        }
    }

    override fun getItemCount() = characterList.size

    interface ListItemListener {
        fun onItemClick(character: CharacterEntity)
    }
}