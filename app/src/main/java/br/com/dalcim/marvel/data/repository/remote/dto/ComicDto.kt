package br.com.dalcim.marvel.data.repository.remote.dto

data class ComicDto(
        val title: String,
        val description: String,
        val pageCount: Int,
        val thumbnail: ThumbnailDto
) {
    val image: String
        get() = "${thumbnail.path}.${thumbnail.extension}"
}