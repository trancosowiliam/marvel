package br.com.dalcim.marvel

import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast

fun AppCompatActivity.showDialogMessage(message:String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

var View.isVisible: Boolean
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if(value) View.VISIBLE else View.GONE
    }
