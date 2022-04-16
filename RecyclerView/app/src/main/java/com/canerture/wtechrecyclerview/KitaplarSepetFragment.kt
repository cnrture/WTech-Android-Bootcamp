package com.canerture.wtechrecyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.canerture.wtechrecyclerview.databinding.FragmentKitaplarSepetBinding

class KitaplarSepetFragment : Fragment() {

    private lateinit var binding: FragmentKitaplarSepetBinding

    private lateinit var kitaplarDB: KitaplarDatabase

    private lateinit var sepetKitaplarList: ArrayList<Kitap>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        kitaplarDB = KitaplarDatabase.getirKitaplarDatabase(requireContext())!!

        sepetKitaplarList = kitaplarDB.kitaplarDAO().sepetKitaplar() as ArrayList<Kitap>

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_kitaplar_sepet, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.kitaplarSepetRecyclerView.setHasFixedSize(true)

        val adapter = KitaplarSepetAdapter(sepetKitaplarList, kitaplarDB)
        binding.sepetKitapAdapter = adapter

    }
}