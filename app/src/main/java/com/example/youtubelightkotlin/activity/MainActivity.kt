package com.example.youtubelightkotlin.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubelightkotlin.R
import com.example.youtubelightkotlin.adapter.FeedAdapter
import com.example.youtubelightkotlin.adapter.FilterAdapter
import com.example.youtubelightkotlin.databinding.ActivityMainBinding
import com.example.youtubelightkotlin.model.Feed
import com.example.youtubelightkotlin.model.Filter
import com.example.youtubelightkotlin.model.ObjectType
import com.example.youtubelightkotlin.model.Short2

class MainActivity : AppCompatActivity() {

    private var context: Context = this
    private lateinit var binding: ActivityMainBinding
    private lateinit var filterList: RecyclerView
    private lateinit var feedList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        supportActionBar!!.hide()

        filterList = binding.filterList
        feedList = binding.feedList

        filterList.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        feedList.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        val short2s = ArrayList<Short2>()
        val filters = ArrayList<Filter>()
        val feeds = ArrayList<Feed>()

        shortLoad(short2s)
        filterLoad(filters)
        feedLoad(short2s, feeds)

        val filterAdapter = FilterAdapter(filters)
        val feedAdapter = FeedAdapter(context, feeds)

        filterList.adapter = filterAdapter
        feedList.adapter = feedAdapter
    }

    private fun filterLoad(filters: ArrayList<Filter>) {
        filters.add(Filter(ObjectType.exploreFilter, ""))
        filters.add(Filter(ObjectType.verticalLineFilter, ""))
        filters.add(Filter(ObjectType.commonFilter, "Computer Programming"))
        filters.add(Filter(ObjectType.commonFilter, "Android Native"))
        filters.add(Filter(ObjectType.commonFilter, "Mobile Development"))
    }

    private fun feedLoad(short2s: ArrayList<Short2>, feeds: java.util.ArrayList<Feed>) {
        feeds.add(Feed(R.drawable.image1, R.drawable.video1))
        feeds.add(Feed(short2s))
        feeds.add(Feed(R.drawable.image2, R.drawable.video2))
        feeds.add(Feed(R.drawable.image3, R.drawable.video3))
        feeds.add(Feed(R.drawable.image1, R.drawable.video1))
        feeds.add(Feed(R.drawable.image2, R.drawable.video2))
        feeds.add(Feed(short2s))
        feeds.add(Feed(R.drawable.image3, R.drawable.video3))
    }

    private fun shortLoad(short2s: ArrayList<Short2>) {
        short2s.add(Short2(R.drawable.short_video1, "Drawing App | HTML CSS & JavaScript", "79K views"))
        short2s.add(Short2(R.drawable.short_video2, "Software engineer status for WhatsApp coder status 2022 programmers #coding #viral #shorts", "1.4M views"))
        short2s.add(Short2(R.drawable.short_video3, "Albert Einstein doing physics | very rare video footage #shorts", "3.3M views"))
        short2s.add(Short2(R.drawable.short_video1, "Drawing App | HTML CSS & JavaScript", "79K views"))
        short2s.add(Short2(R.drawable.short_video2, "Software engineer status for WhatsApp coder status 2022 programmers #coding #viral #shorts", "1.4M views"))
        short2s.add(Short2(R.drawable.short_video3, "Albert Einstein doing physics | very rare video footage #shorts", "3.3M views"))
        short2s.add(Short2(R.drawable.short_video1, "Drawing App | HTML CSS & JavaScript", "79K views"))
        short2s.add(Short2(R.drawable.short_video2, "Software engineer status for WhatsApp coder status 2022 programmers #coding #viral #shorts", "1.4M views"))
        short2s.add(Short2(R.drawable.short_video3, "Albert Einstein doing physics | very rare video footage #shorts", "3.3M views"))
    }
}
