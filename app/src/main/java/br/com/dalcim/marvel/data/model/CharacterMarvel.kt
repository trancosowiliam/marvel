package br.com.dalcim.marvel.data.model

import br.com.dalcim.marvel.data.repository.remote.dto.CharacterMarvelDto

data class CharacterMarvel(val name:String) {
    constructor(dto: CharacterMarvelDto) : this(
            name = dto.name
    )
}