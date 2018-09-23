package br.com.dalcim.marvel.view.character

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.dalcim.marvel.R
import org.koin.android.ext.android.inject

class CharacterActivity : AppCompatActivity(), CharacterContract.View {
    override val presenter by inject<CharacterContract.Presenter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character)
        presenter(this)
    }
}
