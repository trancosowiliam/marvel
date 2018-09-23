package br.com.dalcim.marvel.data.model

import android.os.Parcelable
import br.com.dalcim.marvel.data.repository.remote.dto.CharacterMarvelDto
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharacterMarvel(val name:String) : Parcelable {
    constructor(dto: CharacterMarvelDto) : this(
            name = dto.name
    )
}