package br.com.dalcim.marvel.view.character

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import br.com.dalcim.marvel.*
import br.com.dalcim.marvel.data.model.CharacterMarvel
import br.com.dalcim.marvel.data.model.Comic
import kotlinx.android.synthetic.main.activity_character.*
import org.koin.android.ext.android.inject
import kotlinx.android.synthetic.main.activity_character.chaProgressBarList as progressBarList
import kotlinx.android.synthetic.main.activity_character.chaRecComics as recComics
import kotlinx.android.synthetic.main.activity_character.chaTxtName as txtName
import kotlinx.android.synthetic.main.activity_character.chaImgCharacter as imgCharacter

private const val EXTRA_CHARACTER = "character"

class CharacterActivity : AppCompatActivity(), CharacterContract.View {
    override val presenter by inject<CharacterContract.Presenter>()

    private val characterMarvel:CharacterMarvel by extra(EXTRA_CHARACTER)

    companion object {
        fun newIntent(context: Context, character: CharacterMarvel) = Intent(context, CharacterActivity::class.java).apply {
            this.putExtra(EXTRA_CHARACTER, character)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character)
        presenter(this)

        setupViews()
        presenter.loadComics(characterMarvel.id)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when(item?.itemId) {
            android.R.id.home -> onBackPressed().let { true }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun loadingList(isLoading: Boolean) {
        progressBarList.isVisible = isLoading
    }

    override fun addItens(comics: List<Comic>) {
        recComics.layoutManager = LinearLayoutManager(this)
        recComics.adapter = ComicsAdapter(comics)
    }

    override fun showMessage(message: String) {
        showDialogMessage(message)
    }

    private fun setupViews() {
        setSupportActionBar(chaTbToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        supportActionBar?.title = characterMarvel.name
        txtName.text = characterMarvel.name
        imgCharacter.loadImage(characterMarvel.image)
    }

}

