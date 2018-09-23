package br.com.dalcim.marvel

import android.support.v7.app.AppCompatActivity
import android.widget.Toast

fun AppCompatActivity.showDialogMessage(message:String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
