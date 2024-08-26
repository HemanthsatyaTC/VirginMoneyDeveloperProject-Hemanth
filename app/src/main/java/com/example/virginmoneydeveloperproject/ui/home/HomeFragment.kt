package com.example.virginmoneydeveloperproject.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.virginmoneydeveloperproject.R
import com.example.virginmoneydeveloperproject.data.model.people.PeopleDataItemModel
import com.example.virginmoneydeveloperproject.databinding.FragmentHomeBinding
import com.example.virginmoneydeveloperproject.ui.adapter.PeopleAdapter
import dagger.hilt.android.AndroidEntryPoint


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
//        val root: View = binding.root


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val homeViewModel: HomeViewModel by viewModels()

        homeViewModel.details.observe(viewLifecycleOwner){
            binding.apply {
                peopleRecycle.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = PeopleAdapter(it)

                }
            }

        }
        homeViewModel.getdetails()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}