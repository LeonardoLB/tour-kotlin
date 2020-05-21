package com.leonardobufalo.tour.service.impl

import com.leonardobufalo.tour.TourApplication
import com.leonardobufalo.tour.model.Promocao
import com.leonardobufalo.tour.service.PromocaoService
import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentHashMap


@Service
class PromocaoServiceImpl: PromocaoService {

    companion object {
        val initialPromocoes = arrayOf(
                Promocao(1, "Viajem Paris", "Paris",true, 5, 9000.00),
                Promocao(2, "Viajem Roma", "Roma",false, 2, 6700.00),
                Promocao(3, "Viajem Canada", "Toronto",true, 20, 18000.00),
                Promocao(4, "Viajem Germany", "Munich",true, 7, 10000.00)
        )
    }

    var promocoes = ConcurrentHashMap<Long, Promocao>(initialPromocoes.associateBy(Promocao::id))

    override fun create(promocao: Promocao): Promocao? {
        promocoes[promocao.id] = promocao
        return promocoes[promocao.id]
    }

    override fun getAll(local: String): List<Promocao> {
        return promocoes.values.filter { it.local.contains(local, ignoreCase = true) }
    }

    override fun getById(id: Long): Promocao? {
        return promocoes[id]
    }

    override fun delete(id: Long): Promocao? {
        val promocaoRemoved: Promocao? = promocoes[id]
        promocoes.remove(id)
        return promocaoRemoved
    }

    override fun update(promocao: Promocao): Promocao? {
        delete(promocao.id)
        create(promocao)
        return promocoes[promocao.id]
    }

}