package com.assignment.practicemvvm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.assignment.practicemvvm.databinding.FragmentDetailBinding
import com.assignment.practicemvvm.viemodels.DetailViewModel
import kotlin.getValue


class DetailFragment : Fragment() {

    private val viewModel: DetailViewModel by viewModels()
    val args: DetailFragmentArgs by navArgs()
lateinit var binding: FragmentDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater,container,false)


        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.module.observe(viewLifecycleOwner) { m ->
            if (m != null) {
                binding.titleTV.text = "Item: "+ m.title
                binding.desceiptionTV.text = m.description
                binding.statusTV.text = if (m.status) "Status: Completed" else "Status : Pending"
            }
        }

        viewModel.load(args.trainerData.id)

        binding.markStatus.setOnClickListener {
            viewModel.toggleCompleted()
        }
    }
}