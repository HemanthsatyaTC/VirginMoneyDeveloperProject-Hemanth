package com.example.virginmoneydeveloperproject.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.virginmoneydeveloperproject.databinding.FragmentDashboardBinding
import com.example.virginmoneydeveloperproject.ui.adapter.PeopleAdapter
import com.example.virginmoneydeveloperproject.ui.adapter.PeopleMoreDetailsAdapter
import com.example.virginmoneydeveloperproject.ui.home.HomeViewModel

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dashViewModel: DashboardViewModel by viewModels()
        dashViewModel.details.observe(viewLifecycleOwner){
            binding.apply {
                peopleMoreDetails.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = PeopleMoreDetailsAdapter(it)

                }
            }

        }
        dashViewModel.getdetails()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}