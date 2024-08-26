package com.example.virginmoneydeveloperproject.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.virginmoneydeveloperproject.R
import com.example.virginmoneydeveloperproject.data.model.rooms.RoomsViewItemModel
import com.example.virginmoneydeveloperproject.databinding.PeopleDetailsBinding
import com.example.virginmoneydeveloperproject.databinding.RoomDetailsBinding
import com.example.virginmoneydeveloperproject.ui.adapter.PeopleAdapter.MyViewHolder

class RoomsAdapter (private val roomsList: List<RoomsViewItemModel>):
    RecyclerView.Adapter<RoomsAdapter.MyViewHolder>(){

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = RoomDetailsBinding.bind(view)
        init {
            binding.apply {  }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.room_details, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return roomsList.size
    }
    @SuppressLint("CheckResult")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentUser = roomsList[position]
        holder.binding.apply{
            idNum.text = currentUser.id
            date.text = currentUser.createdAt
            occupied.isChecked = currentUser.isOccupied == true
            maxOccupancy.text = currentUser.maxOccupancy.toString()


        }
    }
}