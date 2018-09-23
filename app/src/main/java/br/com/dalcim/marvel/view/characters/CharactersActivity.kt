package br.com.dalcim.marvel.view.characters

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import br.com.dalcim.marvel.R
import br.com.dalcim.marvel.data.model.CharacterMarvel
import br.com.dalcim.marvel.showDialogMessage
import br.com.dalcim.marvel.view.character.CharacterActivity
import org.koin.android.ext.android.inject
import kotlinx.android.synthetic.main.activity_characters.csRecCharacters as recCharacters
import kotlinx.android.synthetic.main.activity_characters.csGroupLoading as groupLoading

class CharactersActivity : AppCompatActivity(), CharactersContract.View {
    override val presenter by inject<CharactersContract.Presenter>()

    private val adapter: CharactersAdapter by lazy { CharactersAdapter(mutableListOf()) }

    private var isLoading = false
    private var offset = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters)
        presenter(this)

        setupList()
        presenter.loadCharacters(offset, null)
    }

    override fun loadingList(isLoading: Boolean) {
        this.isLoading = isLoading

        if (isLoading) {
            groupLoading.visibility = View.VISIBLE
        } else {
            groupLoading.visibility = View.GONE
            recCharacters.visibility = View.VISIBLE
        }
    }

    override fun addItens(characters: List<CharacterMarvel>) {
        offset += characters.size
        characters.forEach { character ->
            adapter.addItem(character)
        }
    }

    override fun showMessage(message: String) {
        showDialogMessage(message)
    }

    private fun setupList() {
        adapter.onItemClick = { character ->
            startActivity(CharacterActivity.newIntent(this, character))
        }

        val llm = LinearLayoutManager(this)
        recCharacters.layoutManager = llm
        recCharacters.adapter = adapter
        recCharacters.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                val lastVisibleItemPosition = llm.findLastVisibleItemPosition()
                if (lastVisibleItemPosition == adapter.itemCount - 1 && !isLoading) {
                    presenter.loadCharacters(offset, null)
                }
            }
        })
    }
}
