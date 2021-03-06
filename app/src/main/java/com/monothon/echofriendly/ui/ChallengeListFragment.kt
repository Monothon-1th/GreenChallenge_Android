package com.monothon.echofriendly.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.monothon.echofriendly.R
import com.monothon.echofriendly.databinding.FragmentChallengeListBinding
import com.monothon.echofriendly.ui.adapter.ChallengeListAdapter
import com.monothon.echofriendly.viewmodel.EchoViewModel

class ChallengeListFragment(private val viewModel: EchoViewModel) : Fragment() {
    private lateinit var binding: FragmentChallengeListBinding
    private val listAdapter: ChallengeListAdapter = ChallengeListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_challenge_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getChallengeList()

        configureUI()
        subscribeUI()
    }

    private fun configureUI() {
        binding.lifecycleOwner = this
        binding.challengeList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            binding.challengeList.adapter = listAdapter
        }
        listAdapter.onItemClick = {
            parentFragmentManager.beginTransaction()
                .replace(R.id.layout_container, ChallengeFragment(viewModel, it.id))
                .commit()
        }
    }

    private fun subscribeUI() {
        viewModel.challengeList.observe(requireActivity()) { listAdapter.resetList(it) }
    }
}