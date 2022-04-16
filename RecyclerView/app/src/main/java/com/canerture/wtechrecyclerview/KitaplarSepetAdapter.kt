package com.canerture.wtechrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.canerture.wtechrecyclerview.databinding.KitapSepetCardTasarimBinding
import com.squareup.picasso.Picasso

class KitaplarSepetAdapter(private val sepetKitaplarList: ArrayList<Kitap>, private val kitaplarDB: KitaplarDatabase):
    RecyclerView.Adapter<KitaplarSepetAdapter.KitapSepetCardTasarim>() {

    inner class KitapSepetCardTasarim(kitapSepetCardTasarimBinding: KitapSepetCardTasarimBinding): RecyclerView.ViewHolder(kitapSepetCardTasarimBinding.root) {
        var kitapSepetCardTasarimBinding: KitapSepetCardTasarimBinding = kitapSepetCardTasarimBinding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KitapSepetCardTasarim {
        val layoutInflater = LayoutInflater.from(parent.context)
        val kitapSepetCardBinding =  KitapSepetCardTasarimBinding.inflate(layoutInflater, parent, false)

        return KitapSepetCardTasarim(kitapSepetCardBinding)
    }

    override fun onBindViewHolder(holder: KitapSepetCardTasarim, position: Int) {
        val kitap = sepetKitaplarList[position]

        holder.kitapSepetCardTasarimBinding.kitapModel = kitap

        Picasso.get().load(kitap.kitapGorselUrl).into(holder.kitapSepetCardTasarimBinding.imageView)

        holder.kitapSepetCardTasarimBinding.kitapSilButton.setOnClickListener {
            kitaplarDB.kitaplarDAO().sepetDurumGuncelle(kitap.kitapId, 0)
            val sepetKitaplarListGuncel = kitaplarDB.kitaplarDAO().sepetKitaplar() as ArrayList<Kitap>
            updateList(sepetKitaplarListGuncel)
        }

    }

    override fun getItemCount(): Int {
        return sepetKitaplarList.size
    }

    fun updateList(sepetKitaplarListGuncel: ArrayList<Kitap>) {
        this.sepetKitaplarList.clear()
        this.sepetKitaplarList.addAll(sepetKitaplarListGuncel)
        notifyDataSetChanged()
    }
}