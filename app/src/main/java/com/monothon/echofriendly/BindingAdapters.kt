package com.monothon.echofriendly

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * Created by Yeji on 2022/01/09.
 */
@BindingAdapter("set_image")
fun ImageView.setImage(url: String?) {
    url?.let {
        Glide.with(this)
            .load(url)
            .into(this)
    }
}

@BindingAdapter("set_text")
fun TextView.setText(text: Int?) {
    this.text = text.toString()
}

@BindingAdapter("date_text")
fun TextView.setDateText(text: String) {
    this.text = text.split("T")[0].replace("-", ".")
}

@BindingAdapter("user_text")
fun TextView.setUserText(text: String) {
    this.text = "$text 님"
}