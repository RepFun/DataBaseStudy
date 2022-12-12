package com.iaa.databasestudy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.iaa.databasestudy.databinding.FragmentAlbumsListBinding



class AlbumListFragment : Fragment() {

    lateinit var binding: FragmentAlbumsListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlbumsListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = AlbumResponseListAdapter()
        binding.recyclerView.adapter = adapter

        val viewModel = ViewModelProvider(requireActivity())[AlbumListViewModel::class.java]
        viewModel.getAll().observe(requireActivity()){
            if (it != null) {
                adapter.items = it
            }
        }

    }

}