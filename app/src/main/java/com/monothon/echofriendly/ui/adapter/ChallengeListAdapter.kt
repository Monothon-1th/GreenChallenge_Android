package com.monothon.echofriendly.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.monothon.echofriendly.data.Challenge
import com.monothon.echofriendly.databinding.ItemChallengeBinding

/**
 * Created by Yeji on 2022/01/08.
 */
class ChallengeListAdapter : RecyclerView.Adapter<ChallengeListAdapter.ChallengeViewHolder>() {
    private var challengeList: List<Challenge> = listOf()

    fun resetList(list: List<Challenge>) {
        challengeList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChallengeViewHolder =
        ChallengeViewHolder(ItemChallengeBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ChallengeViewHolder, position: Int) {
        holder.bind(challengeList[position])
    }

    override fun getItemCount(): Int = challengeList.size

    class ChallengeViewHolder(private val binding: ItemChallengeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(challenge: Challenge) {
            binding.challenge = challenge
        }
    }
}