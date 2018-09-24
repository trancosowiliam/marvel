package br.com.dalcim.marvel.view.characters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.dalcim.marvel.R
import br.com.dalcim.marvel.data.model.CharacterMarvel
import br.com.dalcim.marvel.getStringQty
import br.com.dalcim.marvel.isVisible
import br.com.dalcim.marvel.loadImage
import kotlinx.android.synthetic.main.item_character.view.ichaImgImage as imgImage
import kotlinx.android.synthetic.main.item_character.view.ichaTxtName as txtName
import kotlinx.android.synthetic.main.item_character.view.ichaTxtCountComics as txtCountComics
import kotlinx.android.synthetic.main.item_character.view.ichaTxtDescription as txtDescription

class CharactersAdapter(private val characters: MutableList<CharacterMarvel>) : RecyclerView.Adapter<CharactersAdapter.Holder>() {

    var onItemClick: ((CharacterMarvel) -> Unit)? = null

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

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(characters[adapterPosition])
            }
        }

        fun render(item: CharacterMarvel) {
            itemView.txtName.text = item.name
            itemView.imgImage.loadImage(item.image, true)
            itemView.txtCountComics.text = itemView.resources.getStringQty(R.plurals.comics_available, item.comicsAvailable, R.string.comics_available_zero)
            itemView.txtDescription.text = item.description
            itemView.txtDescription.isVisible = item.description.isNotBlank()
        }
    }
}