package com.assignment.practicemvvm.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.assignment.practicemvvm.databinding.ItemMoviesBinding
import com.assignment.practicemvvm.models.TrainingListModel


class TrainersAdapter(
        private val onClick: (TrainingListModel) -> Unit) : ListAdapter<TrainingListModel, TrainersAdapter.ModuleViewHolder>(DiffCallback()) {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModuleViewHolder {
            val binding = ItemMoviesBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
            return ModuleViewHolder(binding)
        }


        override fun onBindViewHolder(holder: ModuleViewHolder, position: Int) {
            val module = getItem(position)
            holder.bind(module)
        }

        inner class ModuleViewHolder(private val binding: ItemMoviesBinding) :
            RecyclerView.ViewHolder(binding.root) {

            init {
                binding.root.setOnClickListener {
                    val module = getItem(bindingAdapterPosition)
                    onClick(module)
                }
            }

            fun bind(module: TrainingListModel) {
                binding.tvName.text = module.title
                binding.description.text = module.description
                binding.status.text = if (module.status) "Completed" else "Pending"
            }
        }

        class DiffCallback : DiffUtil.ItemCallback<TrainingListModel>() {
            override fun areItemsTheSame(old: TrainingListModel, new: TrainingListModel): Boolean {
                return old.id == new.id
            }

            override fun areContentsTheSame(old: TrainingListModel, new: TrainingListModel): Boolean {
                return old == new
            }
        }
    }
