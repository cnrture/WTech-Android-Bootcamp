package com.canerture.wtechmvvmornek2.fragments.ana

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.canerture.wtechmvvmornek2.R
import com.canerture.wtechmvvmornek2.databinding.FragmentDizilerBinding
import com.canerture.wtechmvvmornek2.models.ana.Dizi
import com.canerture.wtechmvvmornek2.viewmodels.ana.DizilerViewModel
import com.squareup.picasso.Picasso

class DizilerFragment : Fragment() {

    private lateinit var binding: FragmentDizilerBinding
    private val viewModel: DizilerViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_diziler, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dizileriYukle()

        viewModel.dizilerData.observe(viewLifecycleOwner, {

            if (it != null) {
                Picasso.get().load(it[0]?.diziGorsel).into(binding.dizi1Image)
                Picasso.get().load(it[1]?.diziGorsel).into(binding.dizi2Image)
                Picasso.get().load(it[2]?.diziGorsel).into(binding.dizi3Image)
                Picasso.get().load(it[3]?.diziGorsel).into(binding.dizi4Image)

                binding.dizi1 = it[0]
                binding.dizi2 = it[1]
                binding.dizi3 = it[2]
                binding.dizi4 = it[3]
            }

        })

    }

    fun dizileriYukle() {

        val diziGorsel = arrayListOf("https://api.diziroll.com/uploads/series/poster/662/size_258x372_ggFHVNu6YYI5L9pCfOacjizRGt.jpg", "https://m.media-amazon.com/images/M/MV5BZjRjOTFkOTktZWUzMi00YzMyLThkMmYtMjEwNmQyNzliYTNmXkEyXkFqcGdeQXVyNzQ1ODk3MTQ@._V1_SX400.jpg", "https://m.media-amazon.com/images/I/91p-iKZXKDL._AC_SY550_.jpg", "https://tr.web.img2.acsta.net/pictures/20/08/16/19/46/2263125.jpg")
        val diziAd = arrayListOf("Breaking Bad", "Rick and Morty", "Taht Oyunları", "The Office")
        val diziTur = arrayListOf("Crime, Drama", "Animation, Comedy", "Action, Adventure", "Comedy")
        val diziImdb = arrayListOf("9.4/10", "9.2/10", "9.2/10", "8.9/10")

        val dizilerListe = arrayListOf<Dizi?>()

        for(i in 0 until 4) {
            dizilerListe.add(Dizi(diziGorsel[i], diziAd[i], diziTur[i], diziImdb[i]))
        }

        viewModel.filmYukleVM(dizilerListe)

    }
}