package br.com.dalcim.marvel.view.character

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.dalcim.marvel.R
import br.com.dalcim.marvel.data.model.Comic
import br.com.dalcim.marvel.getStringQty
import br.com.dalcim.marvel.isVisible
import br.com.dalcim.marvel.loadImage
import kotlinx.android.synthetic.main.item_comic.view.icoTxtTitle as txtTitle
import kotlinx.android.synthetic.main.item_comic.view.icoImgImage as imgImage
import kotlinx.android.synthetic.main.item_comic.view.icoTxtPagesCount as txtPagesCount
import kotlinx.android.synthetic.main.item_comic.view.icoTxtDescription as txtDescription

class ComicsAdapter(private var comics: List<Comic>) : RecyclerView.Adapter<ComicsAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            Holder(LayoutInflater.from(parent?.context).inflate(R.layout.item_comic, parent, false))

    override fun getItemCount() = comics.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.render(comics[position])
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun render(item: Comic) {
            itemView.txtTitle.text = item.title
            itemView.imgImage.loadImage(item.image, true)
            itemView.txtPagesCount.text = itemView.resources.getStringQty(R.plurals.comic_page_count, item.pageCount, R.string.comic_page_count_zero)
            itemView.txtDescription.text = item.description
            itemView.txtDescription.isVisible = item.description.isNotBlank()
        }
    }
}