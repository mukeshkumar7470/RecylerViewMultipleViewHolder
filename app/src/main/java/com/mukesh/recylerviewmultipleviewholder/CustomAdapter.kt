package com.mukesh.recylerviewmultipleviewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(val mList: List<DataModel>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        private fun bindHeaderData(item: DataModel.HeaderData) {
            val heading: TextView = itemView.findViewById(R.id.heading)
            val desc: TextView = itemView.findViewById(R.id.desc)

            heading.text = item.title
            desc.text = item.description
        }

        private fun bindItemsViewModel(item: DataModel.ItemsViewModel) {
            val name: TextView = itemView.findViewById(R.id.name)
            val email: TextView = itemView.findViewById(R.id.email)

            name.text = item.name
            email.text = item.email
        }

        fun bind(dataModel: DataModel) {
            when (dataModel) {
                is DataModel.HeaderData -> bindHeaderData(dataModel)
                is DataModel.ItemsViewModel -> bindItemsViewModel(dataModel)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val layout = when (viewType) {
            TYPE_HEADER -> R.layout.header_layout
            TYPE_ITEM -> R.layout.item_list
            else -> throw IllegalArgumentException("Invalid view type")
        }

        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mList[position])
    }

    override fun getItemViewType(position: Int): Int {
        return when (mList[position]) {
            is DataModel.HeaderData -> TYPE_HEADER
            else -> TYPE_ITEM
        }
    }

    companion object {
        private const val TYPE_HEADER = 0
        private const val TYPE_ITEM = 1
    }

}