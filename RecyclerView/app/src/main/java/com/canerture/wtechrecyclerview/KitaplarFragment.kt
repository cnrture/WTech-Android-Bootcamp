package com.canerture.wtechrecyclerview

import android.media.Image
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import com.canerture.wtechrecyclerview.databinding.FragmentKitaplarBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.squareup.picasso.Picasso

class KitaplarFragment : Fragment(), KitaplarAdapter.ClickedKitapListener {

    private lateinit var binding: FragmentKitaplarBinding

    private lateinit var kitaplarDB: KitaplarDatabase

    private lateinit var kitaplarList: ArrayList<Kitap>

    private lateinit var adapter: KitaplarAdapter

    private lateinit var materialAlertDialogBuilder: MaterialAlertDialogBuilder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        kitaplarDB = KitaplarDatabase.getirKitaplarDatabase(requireContext())!!

        kitaplarList = kitaplarDB.kitaplarDAO().tumKitaplar() as ArrayList<Kitap>

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_kitaplar, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.kitaplarFragmentObject = this

        setHasOptionsMenu(true)
        binding.toolbarKitaplar.title = ""
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarKitaplar)

        binding.kitaplarRecyclerView.setHasFixedSize(true)
        adapter = KitaplarAdapter(kitaplarList, this)
        binding.kitaplarAdapter = adapter

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu, menu)

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.kitap_ekle -> kitapEkle()
        }

        return super.onOptionsItemSelected(item)
    }

    fun kitapEkle() {

        val kitapEkleTasarim = LayoutInflater.from(context).inflate(R.layout.kitap_ekle_tasarim, null, false)
        val alertDialogBuilder = AlertDialog.Builder(requireContext())
        alertDialogBuilder.setView(kitapEkleTasarim)

        val dialog = alertDialogBuilder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        val kitapAdiInput: EditText = kitapEkleTasarim.findViewById(R.id.kitapAdiInput)
        val kitapYazariInput: EditText = kitapEkleTasarim.findViewById(R.id.kitapYazariInput)
        val kitapYayimciInput: EditText = kitapEkleTasarim.findViewById(R.id.kitapYayimciInput)
        val kitapFiyatInput: EditText = kitapEkleTasarim.findViewById(R.id.kitapFiyatInput)
        val kitapGorselInput: EditText = kitapEkleTasarim.findViewById(R.id.kitapGorselInput)

        val kitapEkleButton: Button = kitapEkleTasarim.findViewById(R.id.kitapEkleButton)

        kitapEkleButton.setOnClickListener {

            kitaplarDB.kitaplarDAO().kitapEkle(
                Kitap(
                    kitapIsim = kitapAdiInput.text.toString(),
                    kitapYazari = kitapYazariInput.text.toString(),
                    kitapYayimci = kitapYayimciInput.text.toString(),
                    kitapFiyat = kitapFiyatInput.text.toString(),
                    kitapGorselUrl = kitapGorselInput.text.toString(),
                ))

            Toast.makeText(context, "Kitap başarıyla eklendi!", Toast.LENGTH_SHORT).show()

            kitaplarList = kitaplarDB.kitaplarDAO().tumKitaplar() as ArrayList<Kitap>
            adapter.updateList(kitaplarList)

            dialog.dismiss()

        }

        val geriButton: Button = kitapEkleTasarim.findViewById(R.id.geriButton)

        geriButton.setOnClickListener {

            dialog.dismiss()

        }

    }

    override fun onClickedKitapListener(kitap: Kitap, pos: Int) {

        val kitapDetayTasarim = LayoutInflater.from(context).inflate(R.layout.kitap_detay_tasarim, null, false)
        val alertDialogBuilder = AlertDialog.Builder(requireContext())
        alertDialogBuilder.setView(kitapDetayTasarim)

        val dialog = alertDialogBuilder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        val kitapIsimDetay: TextView = kitapDetayTasarim.findViewById(R.id.kitapIsimDetay)
        val kitapYazariDetay: TextView = kitapDetayTasarim.findViewById(R.id.kitapYazariDetay)
        val kitapYayimciDetay: TextView = kitapDetayTasarim.findViewById(R.id.kitapYayimciDetay)
        val kitapGorselDetay: ImageView = kitapDetayTasarim.findViewById(R.id.kitapGorselDetay)

        kitapIsimDetay.text = kitap.kitapIsim
        kitapYazariDetay.text = kitap.kitapYazari
        kitapYayimciDetay.text = kitap.kitapYayimci
        Picasso.get().load(kitap.kitapGorselUrl).into(kitapGorselDetay)

        val sepeteEkleButton: Button = kitapDetayTasarim.findViewById(R.id.sepeteEkleButton)

        sepeteEkleButton.setOnClickListener {

            kitaplarDB.kitaplarDAO().sepetDurumGuncelle(kitap.kitapId, 1)

            Toast.makeText(context, "Kitap sepete eklendi!", Toast.LENGTH_SHORT).show()

            dialog.dismiss()

        }

        val geriButton: Button = kitapDetayTasarim.findViewById(R.id.geriButton)

        geriButton.setOnClickListener {

            dialog.dismiss()

        }

    }
}