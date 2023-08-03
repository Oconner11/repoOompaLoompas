package com.jsalin.oompaloompaapp.domain.usecase

import com.jsalin.oompaloompaapp.domain.item.OompaLoompaItem
import com.jsalin.oompaloompaapp.repo.OompaLoompaRepository
import javax.inject.Inject

class GetOompaLoompasUseCase @Inject constructor(
    private val oompaLoompaRepository: OompaLoompaRepository
){
    suspend operator fun invoke(): List<OompaLoompaItem> {
        return oompaLoompaRepository.getOompaLoompas()
    }
}