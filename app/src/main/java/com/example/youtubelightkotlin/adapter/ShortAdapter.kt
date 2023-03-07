package com.example.youtubelightkotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubelightkotlin.R
import com.example.youtubelightkotlin.databinding.ItemShortViewBinding
import com.example.youtubelightkotlin.model.Short2

class ShortAdapter internal constructor(private var shorts: ArrayList<Short2>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class ShortViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding: ItemShortViewBinding = ItemShortViewBinding.bind(view)
        var video = binding.shortVideo
        var title = binding.shortTitle
        var views = binding.shortViews
    }

    private fun init(holder: ShortViewHolder, _short2: Short2) {
        holder.video.setImageResource(_short2.video)
        holder.title.text = _short2.title
        holder.views.text = _short2.views
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ShortViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_short_view, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ShortViewHolder) init(holder, shorts[position])
    }

    override fun getItemCount(): Int {
        return shorts.size
    }
}
