package com.canerture.wtechretrofit.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.canerture.wtechretrofit.R
import com.canerture.wtechretrofit.adapters.YapilacaklarAdapter
import com.canerture.wtechretrofit.data.response.YapilacaklarResponse
import com.canerture.wtechretrofit.databinding.FragmentYapilacaklarBinding
import com.canerture.wtechretrofit.utils.ApiUtils
import com.canerture.wtechretrofit.viewmodel.YapilacaklarViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class YapilacaklarFragment : Fragment() {

    private lateinit var binding: FragmentYapilacaklarBinding

    private val viewModel : YapilacaklarViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentYapilacaklarBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.yapilacaklarList.observe(viewLifecycleOwner) {

            if (it != null) {
                binding.yapilacaklarRecycler.apply {
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    adapter = YapilacaklarAdapter(it, viewModel)
                }
            }

        }

        binding.yapilacakEkleFAB.setOnClickListener {
            findNavController().navigate(R.id.action_yapilacaklarFragment_to_yapilacaklarBottomSheetDialogFragment)
        }

    }
}