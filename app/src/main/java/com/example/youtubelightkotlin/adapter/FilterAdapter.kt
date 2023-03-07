package com.example.youtubelightkotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubelightkotlin.R
import com.example.youtubelightkotlin.databinding.ItemFilterCommonBinding
import com.example.youtubelightkotlin.model.Filter
import com.example.youtubelightkotlin.model.ObjectType

class FilterAdapter(private val filters: ArrayList<Filter>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class CommonFilterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title = ItemFilterCommonBinding.bind(view).filterTitle }
    class VLineFilterViewHolder(view: View) : RecyclerView.ViewHolder(view)
    class ExploreFilterViewHolder(view: View) : RecyclerView.ViewHolder(view)

    private fun commonInit(holder: CommonFilterViewHolder, filter: Filter) {
        holder.title.text = filter.title
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ObjectType.commonFilter -> CommonFilterViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_filter_common, parent, false))
            ObjectType.exploreFilter -> ExploreFilterViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_filter_explore, parent, false))
            else -> VLineFilterViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_filter_vertical_line, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CommonFilterViewHolder) commonInit(holder, filters[position])
    }

    override fun getItemCount(): Int {
        return filters.size
    }

    override fun getItemViewType(position: Int): Int {
        return filters[position].filterType
    }
}
