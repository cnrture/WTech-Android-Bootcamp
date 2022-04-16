package com.canerture.wtechretrofit.viewmodel

import androidx.lifecycle.ViewModel
import com.canerture.wtechretrofit.Repository

class YapilacaklarBottomSheetDialogViewModel: ViewModel() {

    val repo = Repository()

    fun yapilacakEkle(yapilacak: String, onemliDurum: Int) {
        repo.yapilacakEkle(yapilacak, onemliDurum)
    }

}