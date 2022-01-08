package com.monothon.echofriendly.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.monothon.echofriendly.data.Feed
import com.monothon.echofriendly.databinding.ItemFeedBinding

/**
 * Created by Yeji on 2022/01/08.
 */
class FeedListAdapter : RecyclerView.Adapter<FeedListAdapter.FeedViewHolder>() {
    private var feedList: List<Feed> = listOf()

    var onItemClick: (Feed) -> Unit = {}

    fun resetList(list: List<Feed>) {
        feedList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder =
        FeedViewHolder(ItemFeedBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        val feed = feedList[position]
        holder.bind(feed)
        holder.itemView.setOnClickListener { onItemClick(feed) }
    }

    override fun getItemCount(): Int = feedList.size

    class FeedViewHolder(private val binding: ItemFeedBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(feed: Feed) {
            binding.feed = feed
        }
    }
}