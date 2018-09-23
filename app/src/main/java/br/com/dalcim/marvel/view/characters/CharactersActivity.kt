package br.com.dalcim.marvel.view.characters

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.dalcim.marvel.R
import br.com.dalcim.marvel.data.model.CharacterMarvel
import br.com.dalcim.marvel.showDialogMessage
import org.koin.android.ext.android.inject

class CharactersActivity : AppCompatActivity(), CharactersContract.View {
    override val presenter by inject<CharactersContract.Presenter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters)
        presenter.view = this

        setupList()
    }

    override fun loadingList(isLoading: Boolean) {

    }

    override fun addItens(characters: List<CharacterMarvel>) {

    }

    override fun showMessage(message: String) {
        showDialogMessage(message)
    }

    private fun setupList() {

    }
}
