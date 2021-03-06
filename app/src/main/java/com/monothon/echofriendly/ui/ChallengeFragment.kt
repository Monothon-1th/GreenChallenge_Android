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

    private var participants = 0

    private fun subscribeUI() {
        viewModel.challenge.observe(requireActivity()) {
            binding.challenge = it
            participants = it.participants
        }
        viewModel.joinSuccess.observe(requireActivity()) {
            if (it) {
                viewModel.getUsername()
                binding.challengeDesc.visibility = View.INVISIBLE
                binding.imageEarth.setImageResource(R.drawable.earth_after)
                binding.participantsNum.text = (participants + 1).toString()
                binding.btnCommon.text = "인증하기"
                binding.btnCommon.setTextColor(resources.getColor(R.color.white))
                binding.btnBg.setImageResource(R.drawable.btn_certification)
            }
        }
        viewModel.username.observe(requireActivity()) {
            binding.thanksFor.visibility = View.VISIBLE
            binding.userName.text = it
        }
    }

    private fun setupUI() {
        binding.lifecycleOwner = this
        binding.btnCommon.setOnClickListener {
            if (binding.btnCommon.text == "동참하기") viewModel.joinChallenge(challengeId)
            else {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.layout_container, FeedListFragment(viewModel))
                    .commit()
            }
        }
    }
}