package com.leonardobufalo.tour.service

import com.leonardobufalo.tour.model.Promocao


interface PromocaoService {

    fun create(promocao: Promocao): Promocao?

    fun getAll(local: String): List<Promocao>

    fun getById(id: Long): Promocao?

    fun delete(id: Long): Promocao?

    fun update(promocao: Promocao): Promocao?

}