package com.canerture.wtechretrofit.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.canerture.wtechretrofit.adapters.OnemliYapilacaklarAdapter
import com.canerture.wtechretrofit.databinding.FragmentOnemliYapilacaklarBinding
import com.canerture.wtechretrofit.viewmodel.OnemliYapilacaklarViewModel

class OnemliYapilacaklarFragment : Fragment() {

    private lateinit var binding: FragmentOnemliYapilacaklarBinding

    private val viewModel: OnemliYapilacaklarViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnemliYapilacaklarBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.onemliYapilacaklarList.observe(viewLifecycleOwner) {

            if (it != null) {
                binding.onemliYapilacaklarRecycler.apply {
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    adapter = OnemliYapilacaklarAdapter(it, viewModel)
                }
            }

        }

    }
}