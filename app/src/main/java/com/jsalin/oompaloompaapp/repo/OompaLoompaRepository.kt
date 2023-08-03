package com.jsalin.oompaloompaapp.repo

import com.jsalin.oompaloompaapp.data.remote.OompaLoompaService
import com.jsalin.oompaloompaapp.domain.item.OompaLoompaItem
import com.jsalin.oompaloompaapp.domain.item.toOompaLoompaItem
import javax.inject.Inject


class OompaLoompaRepository @Inject constructor(
    private val oompaLoompaService: OompaLoompaService
){
    suspend fun getOompaLoompas(): List<OompaLoompaItem> {
        return oompaLoompaService.getOompaLoompas().map {
            it.toOompaLoompaItem()
        }
    }
}