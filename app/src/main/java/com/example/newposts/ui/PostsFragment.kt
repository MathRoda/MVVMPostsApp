package com.example.newposts.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.newposts.databinding.PostsFragmentBinding

class PostsFragment : Fragment() {


    private val viewModel: PostsViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = PostsFragmentBinding.inflate(inflater)

        viewModel.getPostsList()

        binding.lifecycleOwner =this
        binding.viewModel = viewModel
        binding.rvPosts.adapter = PostsAdapter()


        return binding.root
    }


}