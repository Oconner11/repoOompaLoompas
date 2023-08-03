package com.jsalin.oompaloompaapp.data.remote

import com.jsalin.oompaloompaapp.data.remote.model.OompaLoompaModel
import com.jsalin.oompaloompaapp.data.remote.model.OompaLoompasModel
import retrofit2.http.GET
import retrofit2.http.Query

interface OompaLoompaApi {

    @GET("oompa-loompas/")
    suspend fun getOompaLoompas(
    ): OompaLoompasModel

    @GET("oompa-loompas/{id}")
    suspend fun getOompaLoompa(
        @Query("id") id: Int
    ): OompaLoompaModel
}