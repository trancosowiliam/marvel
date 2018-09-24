package br.com.dalcim.marvel.data.model

import android.os.Parcelable
import br.com.dalcim.marvel.data.repository.remote.dto.ComicDto
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Comic(
        val title: String,
        val description: String,
        val pageCount: Int,
        val image: String) : Parcelable {

    constructor(dto: ComicDto) : this(
            title = dto.title,
            description = dto.description ?: "",
            pageCount = dto.pageCount,
            image = dto.image
    )
}