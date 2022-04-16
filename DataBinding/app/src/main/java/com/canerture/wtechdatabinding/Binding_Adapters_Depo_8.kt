package com.canerture.wtechdatabinding.adapters

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("isimGetir")
fun setText(textView: TextView, isim: String) {
    textView.text = "Hoşgeldin $isim"
}

@BindingAdapter("setPaddingLeft", "setPaddingTop")
fun setPadding(view: View, paddingLeft: Int, paddingTop: Int) {
    view.setPadding(paddingLeft, paddingTop, view.paddingBottom, view.paddingRight)
}