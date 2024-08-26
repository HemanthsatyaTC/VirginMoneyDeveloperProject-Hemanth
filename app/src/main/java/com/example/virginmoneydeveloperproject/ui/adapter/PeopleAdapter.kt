package com.example.virginmoneydeveloperproject.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.virginmoneydeveloperproject.R
import com.example.virginmoneydeveloperproject.data.model.people.PeopleDataItemModel
import com.example.virginmoneydeveloperproject.databinding.PeopleDetailsBinding
import dagger.hilt.android.AndroidEntryPoint


class PeopleAdapter(
    private val peopleList: List<PeopleDataItemModel>):
    RecyclerView.Adapter<PeopleAdapter.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = PeopleDetailsBinding.bind(view)
        init {
            binding.apply {  }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.people_details, parent, false)
        return MyViewHolder(view)
    }

    @SuppressLint("CheckResult")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentUser = peopleList[position]
        holder.binding.apply{
//            viewMoreDetails.setOnClickListener {
//                // Navigate to DashboardFragment using the action defined in nav_graph.xml
//                findNavController().navigate(R.id.action_navigation_home_to_navigation_dashboard)
//            }
            firstName.text = currentUser.firstName
            lastName.text = currentUser.lastName
            idnumber.text = currentUser.id
            email.text = currentUser.email
            Glide.with(holder.itemView.context)
                .load(currentUser.avatar)
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageView)


        }


    }

    override fun getItemCount(): Int {
        return peopleList.size
    }
}