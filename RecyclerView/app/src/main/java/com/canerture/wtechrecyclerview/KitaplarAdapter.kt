package com.canerture.wtechrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.canerture.wtechrecyclerview.databinding.KitapCardTasarimBinding
import com.squareup.picasso.Picasso

class KitaplarAdapter(private val kitaplarList: ArrayList<Kitap>, private val clickedKitapListener: ClickedKitapListener): RecyclerView.Adapter<KitaplarAdapter.KitapCardTasarim>() {

    inner class KitapCardTasarim(kitapCardTasarimBinding: KitapCardTasarimBinding): RecyclerView.ViewHolder(kitapCardTasarimBinding.root) {
        var kitapCardTasarimBinding: KitapCardTasarimBinding = kitapCardTasarimBinding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KitapCardTasarim {
        val layoutInflater = LayoutInflater.from(parent.context)
        val kitapCardBinding = KitapCardTasarimBinding.inflate(layoutInflater, parent, false)

        return KitapCardTasarim(kitapCardBinding)
    }

    override fun onBindViewHolder(holder: KitapCardTasarim, position: Int) {
        val kitap = kitaplarList[position]

        holder.kitapCardTasarimBinding.kitapModel = kitap

        Picasso.get().load(kitap.kitapGorselUrl).into(holder.kitapCardTasarimBinding.kitapGorsel)

        holder.kitapCardTasarimBinding.kitapGorsel.setOnClickListener {

            clickedKitapListener.onClickedKitapListener(kitap, position)

        }

    }

    override fun getItemCount(): Int {
        return kitaplarList.size
    }

    fun updateList(kitaplarListGuncel: ArrayList<Kitap>) {
        this.kitaplarList.clear()
        this.kitaplarList.addAll(kitaplarListGuncel)
        notifyDataSetChanged()
    }

    interface ClickedKitapListener {

        fun onClickedKitapListener(kitap: Kitap, pos: Int)

    }

}