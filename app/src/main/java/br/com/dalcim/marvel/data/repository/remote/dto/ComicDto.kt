package br.com.dalcim.marvel.data.repository.remote.dto

data class ComicDto(
        var title: String,
        val thumbnail: ThumbnailDto
) {
    val image:String
        get() = "${thumbnail.path}.${thumbnail.extension}"
}