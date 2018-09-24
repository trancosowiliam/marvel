package br.com.dalcim.marvel.view.character

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.dalcim.marvel.R
import br.com.dalcim.marvel.data.model.Comic
import kotlinx.android.synthetic.main.item_comic.view.icomTxtTitle as txtTitle

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
        }
    }
}