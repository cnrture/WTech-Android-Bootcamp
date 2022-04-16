package com.canerture.wtechretrofit.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.canerture.wtechretrofit.R
import com.canerture.wtechretrofit.data.response.CRUDResponse
import com.canerture.wtechretrofit.databinding.FragmentYapilacaklarBottomSheetDialogBinding
import com.canerture.wtechretrofit.utils.ApiUtils
import com.canerture.wtechretrofit.viewmodel.YapilacaklarBottomSheetDialogViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class YapilacaklarBottomSheetDialogFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentYapilacaklarBottomSheetDialogBinding

    private val viewModel: YapilacaklarBottomSheetDialogViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setStyle(STYLE_NORMAL, R.style.AppBottomSheetDialogTheme)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentYapilacaklarBottomSheetDialogBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var onemliDurum = 0

        binding.apply {

            onemliCheckBox.setOnCheckedChangeListener { compoundButton, b ->

                onemliDurum = if (b) {
                    1
                }   else {
                    0
                }
            }

            ekleButton.setOnClickListener {
                val yapilacak = yapilacakEditText.text.toString()

                viewModel.yapilacakEkle(yapilacak, onemliDurum)

                dismiss()

            }

        }

    }
}