package com.monothon.echofriendly.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.monothon.echofriendly.R
import com.monothon.echofriendly.databinding.FragmentFeedListBinding
import com.monothon.echofriendly.ui.adapter.FeedListAdapter
import com.monothon.echofriendly.viewmodel.EchoViewModel

class FeedListFragment(private val viewModel: EchoViewModel) : Fragment() {
    private lateinit var binding: FragmentFeedListBinding
    private val listAdapter = FeedListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_feed_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getFeedList()

        configureUI()
        subscribeUI()
    }

    private fun configureUI() {
        binding.lifecycleOwner = this
        binding.feedList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            binding.feedList.adapter = listAdapter
        }
        binding.fab.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.layout_container, CertificationFragment(viewModel))
                .commit()
        }
    }

    private fun subscribeUI() {
        viewModel.feedList.observe(requireActivity()) { listAdapter.resetList(it) }
    }
}