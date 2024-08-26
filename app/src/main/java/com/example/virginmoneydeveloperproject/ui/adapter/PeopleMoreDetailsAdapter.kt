package com.example.virginmoneydeveloperproject.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.virginmoneydeveloperproject.R
import com.example.virginmoneydeveloperproject.data.model.people.PeopleDataItemModel
import com.example.virginmoneydeveloperproject.databinding.PeopleDetailsBinding
import com.example.virginmoneydeveloperproject.databinding.PeopleMoreDetailsBinding

class PeopleMoreDetailsAdapter(private val peopleList: List<PeopleDataItemModel>):
    RecyclerView.Adapter<PeopleMoreDetailsAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = PeopleMoreDetailsBinding.bind(view)
        init {
            binding.apply {  }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.people_more_details, parent, false)
        return MyViewHolder(view)
    }


    @SuppressLint("CheckResult")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentUser = peopleList[position]
        holder.binding.apply{
            idNum.text = currentUser.id
            dateCreated.text = currentUser.createdAt
            title.text = currentUser.jobtitle
            color.text = currentUser.favouriteColor
        }

    }

    override fun getItemCount(): Int {
        return peopleList.size
    }
}