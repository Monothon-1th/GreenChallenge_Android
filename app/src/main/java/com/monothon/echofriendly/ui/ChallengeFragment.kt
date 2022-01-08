package com.monothon.echofriendly.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.monothon.echofriendly.R
import com.monothon.echofriendly.databinding.FragmentChallengeBinding
import com.monothon.echofriendly.viewmodel.EchoViewModel

class ChallengeFragment(private val viewModel: EchoViewModel) : Fragment() {
    private lateinit var binding: FragmentChallengeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_challenge, container, false)
        return inflater.inflate(R.layout.fragment_challenge, container, false)
    }
}