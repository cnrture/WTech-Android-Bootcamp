package com.canerture.wtechretrofit.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.canerture.wtechretrofit.adapters.TamamlananYapilacaklarAdapter
import com.canerture.wtechretrofit.databinding.FragmentTamamlananYapilacaklarBinding
import com.canerture.wtechretrofit.viewmodel.TamamlananYapilacaklarViewModel

class TamamlananYapilacaklarFragment : Fragment() {

    private lateinit var binding: FragmentTamamlananYapilacaklarBinding

    private val viewModel: TamamlananYapilacaklarViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTamamlananYapilacaklarBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.tamamlananYapilacaklarList.observe(viewLifecycleOwner) {

            if (it != null) {

                binding.tamamlananYapilacaklarRecycler.apply {
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    adapter = TamamlananYapilacaklarAdapter(it, viewModel)
                }

            }

        }

    }


}