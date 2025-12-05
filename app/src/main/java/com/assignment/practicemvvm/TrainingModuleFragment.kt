package com.assignment.practicemvvm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.assignment.practicemvvm.adapters.TrainersAdapter
import com.assignment.practicemvvm.databinding.FragmentMoviesBinding

import com.assignment.practicemvvm.viemodels.MoviesViewModel


class TrainingModuleFragment : Fragment() {

    private val viewModel: MoviesViewModel by viewModels()
    private lateinit var binding: FragmentMoviesBinding
    lateinit  var    adapter : TrainersAdapter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

 }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMoviesBinding.inflate(inflater,container,false)

        adapter = TrainersAdapter { module ->

          val action = TrainingModuleFragmentDirections.Companion.actionListToDetail(module)
          findNavController().navigate(action)

        }

        binding.movieListRV.adapter = adapter
        viewModel.modules.observe(viewLifecycleOwner) { modules ->
            adapter.submitList(modules)
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
       viewModel.reloadModule()

    }

}