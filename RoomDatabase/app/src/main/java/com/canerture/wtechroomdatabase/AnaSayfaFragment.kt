package com.canerture.wtechroomdatabase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.canerture.wtechroomdatabase.databinding.FragmentAnaSayfaBinding
import com.canerture.wtechroomdatabase.databinding.FragmentGelirGiderEkleBinding

class AnaSayfaFragment : Fragment() {

    private lateinit var binding: FragmentAnaSayfaBinding

    private lateinit var gelirGiderDB: GelirGiderDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        gelirGiderDB = GelirGiderDatabase.getirGelirGiderDatabase(requireContext())!!

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAnaSayfaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            tumGelirGiderlerButton.setOnClickListener {
                findNavController().navigate(R.id.action_anaSayfaFragment_to_tumGelirGiderler)
            }

            gelirGiderEkleButton.setOnClickListener {
                findNavController().navigate(R.id.action_anaSayfaFragment_to_gelirGiderEkleFragment)
            }

            gelirGiderAraButton.setOnClickListener {
                findNavController().navigate(R.id.action_anaSayfaFragment_to_gelirGiderAraFragment)
            }

            gelirGiderTemizleButton.setOnClickListener {

                gelirGiderDB.gelirGiderDAO().gelirGiderTemizle()

            }

        }

    }
}