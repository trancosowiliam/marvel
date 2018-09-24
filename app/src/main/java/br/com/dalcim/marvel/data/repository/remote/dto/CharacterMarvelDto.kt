package br.com.dalcim.marvel.data.repository.remote.dto

data class CharacterMarvelDto(
        val id: Long,
        val name: String,
        val description: String,
        val thumbnail: ThumbnailDto
) {
    val image:String
        get() = "${thumbnail.path}.${thumbnail.extension}"
}