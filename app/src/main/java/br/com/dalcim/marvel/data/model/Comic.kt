package br.com.dalcim.marvel.data.model

import android.os.Parcelable
import br.com.dalcim.marvel.data.repository.remote.dto.ComicDto
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Comic(
        val title: String,
        val image: String) : Parcelable {

    constructor(dto: ComicDto) : this(
            title = dto.title,
            image = dto.image
    )
}