package com.canerture.wtechmvvmornek2.fragments.ana

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.canerture.wtechmvvmornek2.R
import com.canerture.wtechmvvmornek2.databinding.FragmentFilmlerBinding
import com.canerture.wtechmvvmornek2.models.ana.Film
import com.canerture.wtechmvvmornek2.viewmodels.ana.FilmlerViewModel
import com.squareup.picasso.Picasso

class FilmlerFragment : Fragment() {

    private lateinit var binding: FragmentFilmlerBinding
    private val viewModel: FilmlerViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_filmler, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        filmleriYukle()

        viewModel.filmlerData.observe(viewLifecycleOwner, {

            if (it != null) {

                Picasso.get().load(it[0]?.filmGorsel).into(binding.film1Image)
                Picasso.get().load(it[1]?.filmGorsel).into(binding.film2Image)
                Picasso.get().load(it[2]?.filmGorsel).into(binding.film3Image)
                Picasso.get().load(it[3]?.filmGorsel).into(binding.film4Image)

                binding.film1 = it[0]
                binding.film2 = it[1]
                binding.film3 = it[2]
                binding.film4 = it[3]

            }

        })

    }

    private fun filmleriYukle() {

        val filmGorsel = arrayListOf("https://static.boxofficeturkiye.com/movie/poster/235/11/1999811-46934134.jpg", "https://tr.web.img4.acsta.net/c_310_420/medias/nmedia/18/91/63/78/20155809.jpg", "https://static.boxofficeturkiye.com/movie/poster/235/69/2008169-88561463.jpg", "https://static.boxofficeturkiye.com/movie/poster/235/89/1999989-47193729.jpg")
        val filmAd = arrayListOf("Esaretin Bedeli", "Baba", "Kara Şövalye", "Schindler'in Listesi")
        val filmTur = arrayListOf("Drama", "Crime, Drama", "Action, Crime", "Biography, Drama")
        val filmImdb = arrayListOf("9.3/10", "9.2/10", "9.0/10", "8.9/10")

        val filmlerListe = arrayListOf<Film?>()

        for (i in 0 until 4) {
            filmlerListe.add(Film(filmGorsel[i], filmAd[i], filmTur[i], filmImdb[i]))
        }

        viewModel.filmYukleVM(filmlerListe)

    }
}