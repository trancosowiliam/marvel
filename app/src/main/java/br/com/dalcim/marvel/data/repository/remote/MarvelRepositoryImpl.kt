package br.com.dalcim.marvel.data.repository.remote

import br.com.dalcim.marvel.data.model.CharacterMarvel
import br.com.dalcim.marvel.data.repository.remote.dto.DataWrapper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MarvelRepositoryImpl(private val retrofit: Retrofit) : MarvelRepository {
    private val api by lazy { retrofit.create(MarvelApi::class.java) }

    override fun getCharacters(limit: Int, offset: Int, query: String?, onSuccess: (List<CharacterMarvel>) -> Unit, onFailure: (String) -> Unit) {
        api.getCharacters(limit, offset, query).exec(onSuccess, onFailure){
            it.orEmpty().map(::CharacterMarvel)
        }
    }
}

fun <T, R> Call<DataWrapper<T>>.exec(onSuccess: (R) -> Unit, onFailure: (String) -> Unit, transform: ((T?) -> R)){
    this.enqueue(object : Callback<DataWrapper<T>> {
        override fun onResponse(call: Call<DataWrapper<T>>?, response: Response<DataWrapper<T>>?) {
            if(response?.isSuccessful == true) {
                onSuccess(transform(response?.body()?.data?.results))
            } else {
                onFailure("Erro inesperado!")
            }
        }

        override fun onFailure(call: Call<DataWrapper<T>>?, t: Throwable?) {
            onFailure("Erro inesperado! Verifique sua conexão")
        }
    })
}