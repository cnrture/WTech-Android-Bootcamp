package com.canerture.wtechretrofit.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.canerture.wtechretrofit.databinding.YapilacakCardTasarimBinding
import com.canerture.wtechretrofit.model.YapilacakModel
import com.canerture.wtechretrofit.viewmodel.YapilacaklarViewModel

class YapilacaklarAdapter(
    private val yapilacaklarList: List<YapilacakModel>,
    private val viewModel: YapilacaklarViewModel
) :
    RecyclerView.Adapter<YapilacaklarAdapter.YapilacaklarCardTasarim>() {

    inner class YapilacaklarCardTasarim(yapilacaklarCardTasarimBinding: YapilacakCardTasarimBinding) :
        RecyclerView.ViewHolder(yapilacaklarCardTasarimBinding.root) {
        var yapilacaklarCardTasarimBinding: YapilacakCardTasarimBinding =
            yapilacaklarCardTasarimBinding
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): YapilacaklarCardTasarim {
        val layoutInflater = LayoutInflater.from(parent.context)
        val yapilacaklarCardTasarimBinding =
            YapilacakCardTasarimBinding.inflate(layoutInflater, parent, false)

        return YapilacaklarCardTasarim(yapilacaklarCardTasarimBinding)
    }

    override fun onBindViewHolder(
        holder: YapilacaklarCardTasarim,
        position: Int
    ) {
        val yapilacak = yapilacaklarList[position]

        holder.yapilacaklarCardTasarimBinding.yapilacakText.text = yapilacak.yapilacak

        holder.yapilacaklarCardTasarimBinding.onemliCheckBox.isChecked = yapilacak.onemliDurum != 0

        holder.yapilacaklarCardTasarimBinding.onemliCheckBox.setOnCheckedChangeListener { compoundButton, b ->
            if (b) {
                viewModel.onemliDurumDegistir(yapilacak.id, 1)
            }
        }

        holder.yapilacaklarCardTasarimBinding.tamamlandiCheckBox.setOnCheckedChangeListener { compoundButton, b ->
            if (b) {
                viewModel.tamamlandiDurumDegistir(yapilacak.id, 1)
            }
        }

        holder.yapilacaklarCardTasarimBinding.root.setOnLongClickListener {
            viewModel.yapilacakSil(yapilacak.id)

            return@setOnLongClickListener true
        }

    }

    override fun getItemCount(): Int {
        return yapilacaklarList.size
    }

}