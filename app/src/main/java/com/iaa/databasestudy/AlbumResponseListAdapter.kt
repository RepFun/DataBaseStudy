package com.iaa.databasestudy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iaa.databasestudy.R
import com.iaa.databasestudy.databinding.AlbumListItemBinding
import com.iaa.databasestudy.model.AlbumData

class AlbumResponseListAdapter : RecyclerView.Adapter<AlbumResponseListAdapter.ViewHolder>() {

    var items: List<AlbumData> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    private var itemClick: (AlbumData) -> Unit = {}
    fun itemClick(listener: (AlbumData) -> Unit) {
        itemClick = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.albums_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.album = items[position]
        holder.itemView.setOnClickListener {
            itemClick(items[position])
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var binding = AlbumListItemBinding.bind(view)

    }
}