package br.com.dalcim.marvel.view.character

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.dalcim.marvel.R
import br.com.dalcim.marvel.data.model.CharacterMarvel
import org.koin.android.ext.android.inject

private const val EXTRA_CHARACTER = "character"

class CharacterActivity : AppCompatActivity(), CharacterContract.View {
    override val presenter by inject<CharacterContract.Presenter>()

    private val characterMarvel by lazy { intent.getParcelableExtra<CharacterMarvel>(EXTRA_CHARACTER) }

    companion object {
        fun newIntent(context: Context, character: CharacterMarvel) = Intent(context, CharacterActivity::class.java).apply {
            this.putExtra(EXTRA_CHARACTER, character)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character)
        presenter(this)
    }
}
