package br.com.dalcim.marvel.data.repository.remote

import br.com.dalcim.marvel.data.repository.remote.dto.CharacterMarvelDto
import br.com.dalcim.marvel.data.repository.remote.dto.ComicDto
import br.com.dalcim.marvel.data.repository.remote.dto.DataWrapper
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelApi {

    @GET("characters")
    fun getCharacters(
            @Query("limit") limit: Int?,
            @Query("offset") offset: Int?,
            @Query("nameStartsWith") nameStartsWith: String?
    ): Call<DataWrapper<List<CharacterMarvelDto>>>

    @GET("characters/{characterId}/comics")
    fun getCharacterComics(
            @Path("characterId") characterId: Long?
    ):Call<DataWrapper<List<ComicDto>>>
}