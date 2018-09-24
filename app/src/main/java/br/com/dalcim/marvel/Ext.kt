package br.com.dalcim.marvel

import android.app.Activity
import android.os.Parcelable
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


fun AppCompatActivity.showDialogMessage(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

var View.isVisible: Boolean
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value) View.VISIBLE else View.GONE
    }

fun <T : Parcelable> Activity.extra(key: String, default: T? = null): Lazy<T> = lazy {
    intent?.extras?.getParcelable(key) ?: default ?: throw Error("No value $key in extras")
}

fun ImageView.loadImage(photoUrl: String, circle: Boolean = false) {
    Glide.with(context)
            .load(photoUrl)
            .apply { if (circle) RequestOptions.circleCropTransform() }
            .into(this)
}
