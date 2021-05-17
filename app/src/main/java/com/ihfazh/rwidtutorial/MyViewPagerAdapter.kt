package com.ihfazh.rwidtutorial

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ihfazh.rwidtutorial.databinding.SimpleViewBinding

class MyViewPagerAdapter: RecyclerView.Adapter<MyViewPagerAdapter.ViewHolder>() {
    private val data = arrayOf(
            "First text",
            "Second Text",
            "Third Text"
    )

    class ViewHolder(private val binding: SimpleViewBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(s: String) {
            binding.text.text = s
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SimpleViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}