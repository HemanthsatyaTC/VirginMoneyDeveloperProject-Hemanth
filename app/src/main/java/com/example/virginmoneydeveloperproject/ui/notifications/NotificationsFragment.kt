package com.example.virginmoneydeveloperproject.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.virginmoneydeveloperproject.data.model.rooms.RoomsView
import com.example.virginmoneydeveloperproject.databinding.FragmentNotificationsBinding
import com.example.virginmoneydeveloperproject.ui.adapter.PeopleAdapter
import com.example.virginmoneydeveloperproject.ui.adapter.RoomsAdapter
import com.example.virginmoneydeveloperproject.ui.home.HomeViewModel

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val roomViewModel: NotificationsViewModel by viewModels()
        roomViewModel.details.observe(viewLifecycleOwner){
            binding.apply {
                roomRecycle.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = RoomsAdapter(it)

                }
            }

        }
        roomViewModel.getrooms()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}