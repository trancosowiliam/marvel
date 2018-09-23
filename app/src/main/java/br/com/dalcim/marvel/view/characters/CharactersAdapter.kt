package br.com.dalcim.marvel.view.characters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.dalcim.marvel.R
import br.com.dalcim.marvel.data.model.CharacterMarvel
import kotlinx.android.synthetic.main.item_character.view.*

class CharactersAdapter(private val characters: MutableList<CharacterMarvel>) : RecyclerView.Adapter<CharactersAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val holder = Holder(LayoutInflater.from(parent?.context).inflate(R.layout.item_character, parent, false))

        return holder
    }

    override fun getItemCount() = characters.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.render(characters[position])
    }

    fun addItem(character: CharacterMarvel) {
        this.characters.add(character)
        this.notifyItemChanged(characters.size - 1)
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun render(item: CharacterMarvel) {
            itemView.ichaTxtName.text = item.name
        }
    }
}