package com.jsalin.oompaloompaapp.data.remote.model

data class OompaLoompasModel(
    val current: Int,
    val results: List<Result>,
    val total: Int
)