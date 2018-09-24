package br.com.dalcim.marvel

import android.app.Activity
import android.content.res.Resources
import android.os.Parcelable
import android.support.annotation.PluralsRes
import android.support.annotation.StringRes
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

fun AppCompatActivity.showDialogMessage(message: String) {
    AlertDialog.Builder(this)
            .setMessage(message)
            .setPositiveButton("Ok") { _, _ -> }
            .setCancelable(false)
            .show()
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
            .applyDefaultRequestOptions(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.DATA))
            .load(photoUrl)
            .apply { if (circle) this.apply(RequestOptions.circleCropTransform()) }
            .into(this)
}

fun Resources.getStringQty(@PluralsRes id: Int, quantity: Int, @StringRes zeroValue: Int): String {
    return if (quantity == 0) {
        this.getString(zeroValue)
    } else {
        this.getQuantityString(id, quantity, quantity)
    }
}
