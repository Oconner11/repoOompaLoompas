package com.jsalin.oompaloompaapp.data.remote

import com.jsalin.oompaloompaapp.data.remote.model.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class OompaLoompaService @Inject constructor(
    private val oompaLoompaApi: OompaLoompaApi
){

    suspend fun getOompaLoompas(): List<Result> {
        return withContext(Dispatchers.IO) {
            val oompaLoompas = oompaLoompaApi.getOompaLoompas()
            oompaLoompas.results
        }
    }
}