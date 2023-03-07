package com.example.youtubelightkotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubelightkotlin.R
import com.example.youtubelightkotlin.databinding.ItemFeedCommonBinding
import com.example.youtubelightkotlin.databinding.ItemFeedShortsBinding
import com.example.youtubelightkotlin.model.Feed
import com.example.youtubelightkotlin.model.ObjectType

class FeedAdapter(private var context: Context, private var feeds: ArrayList<Feed>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class CommonFeedViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding: ItemFeedCommonBinding = ItemFeedCommonBinding.bind(view)
        var feedProfile = binding.feedProfile
        var feedVideo = binding.feedVideo
    }

    class ShortsFeedViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding: ItemFeedShortsBinding = ItemFeedShortsBinding.bind(view)
        var shorts = binding.feedShorts
    }

    private fun commonInit(holder: CommonFeedViewHolder, feed: Feed) {
        holder.feedProfile.setImageResource(feed.profile)
        holder.feedVideo.setImageResource(feed.video)
    }

    private fun shortsInit(holder: ShortsFeedViewHolder, feed: Feed) {
        holder.shorts.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        val adapter = ShortAdapter(feed.short2s)
        holder.shorts.adapter = adapter
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == ObjectType.shortsFeed)
            ShortsFeedViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_feed_shorts, parent, false))
        else
            CommonFeedViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_feed_common, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CommonFeedViewHolder) commonInit(holder, feeds[position])
        if (holder is ShortsFeedViewHolder) shortsInit(holder, feeds[position])
    }

    override fun getItemCount(): Int {
        return feeds.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (feeds[position].short2s.size > 0) ObjectType.shortsFeed
        else ObjectType.commonFeed
    }
}
