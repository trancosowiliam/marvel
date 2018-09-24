package br.com.dalcim.marvel

import android.app.Application
import br.com.dalcim.marvel.module.applicationModule
import br.com.dalcim.marvel.module.retrofitClientModule
import org.koin.android.ext.android.startKoin

class App : Application() {

    private val modules = listOf (
            applicationModule,
            retrofitClientModule
    )

    override fun onCreate() {
        super.onCreate()
        startKoin(this, modules)
    }
}