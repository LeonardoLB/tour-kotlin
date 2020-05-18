package com.leonardobufalo.tour.constroller

import com.leonardobufalo.tour.model.Promocao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.concurrent.ConcurrentHashMap

@RestController
class PromocaoController {

    @Autowired
    lateinit var promocoes: ConcurrentHashMap<Long, Promocao>


    @RequestMapping(value = ["/promocoes"], method = [RequestMethod.GET])
    fun getAll(): ConcurrentHashMap<Long, Promocao> {
        return promocoes
    }

    @RequestMapping(value = ["/promocoes/{id}"], method = [RequestMethod.GET])
    fun getById(@PathVariable id: Long): Promocao? {
        return promocoes[id]
    }

    @RequestMapping(value = ["/promocoes"], method = [RequestMethod.POST])
    fun createPromocao(@RequestBody promocao: Promocao): Promocao {
        promocoes[promocao.id] = promocao
        return promocao
    }

    @RequestMapping(value = ["/promocoes/{id}"], method = [RequestMethod.DELETE])
    fun delete(@PathVariable id: Long): Promocao? {
        val PromocaoRemoved: Promocao? = promocoes[id]
        promocoes.remove(id)
        return PromocaoRemoved
    }

    @RequestMapping(value = ["/promocoes"], method = [RequestMethod.PUT])
    fun update(@RequestBody promocao: Promocao): Promocao? {
        promocoes.remove(promocao.id)
        promocoes[promocao.id] = promocao
        return promocoes[promocao.id]
    }

}