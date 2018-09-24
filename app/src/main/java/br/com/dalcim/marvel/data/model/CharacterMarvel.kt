package br.com.dalcim.marvel.data.model

import android.os.Parcelable
import br.com.dalcim.marvel.data.repository.remote.dto.CharacterMarvelDto
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharacterMarvel(val id: Long, val name: String, val image:String) : Parcelable {
    constructor(dto: CharacterMarvelDto) : this(
            id = dto.id,
            name = dto.name,
            image = dto.image
    )
}