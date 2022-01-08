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

class ChallengeFragment(private val viewModel: EchoViewModel, private val challengeId: Int) : Fragment() {
    private lateinit var binding: FragmentChallengeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_challenge, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getChallenge(challengeId)

        subscribeUI()
        setupUI()
    }

    private fun subscribeUI() {
        viewModel.challenge.observe(requireActivity()) {
            binding.challenge = it
        }
        viewModel.joinSuccess.observe(requireActivity()) {
            if (it) {
                // TODO
            }
        }
    }

    private fun setupUI() {
        binding.lifecycleOwner = this
        binding.btnCommon.setOnClickListener {
            viewModel.joinChallenge(challengeId)
        }
    }
}