package com.leonardobufalo.tour.constroller

import com.leonardobufalo.tour.model.Promocao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.ConcurrentHashMap

@RestController
class PromocaoController {

    @Autowired
    lateinit var promocoes: ConcurrentHashMap<Long, Promocao>

    @RequestMapping(value = ["/sayhello"], method = [RequestMethod.GET])
    fun SayHello(): String {
        println("Hi Charlie")
        return "Hi Charlie"
    }

    @RequestMapping(value = ["/promocoes"], method = [RequestMethod.GET])
    fun getAllPromocoes(): ConcurrentHashMap<Long, Promocao> {
        return promocoes
    }

    @RequestMapping(value = ["/promocoes/{id}"], method = [RequestMethod.GET])
    fun getPromocao(@PathVariable id: Long): Promocao? {
        return promocoes[id]
    }

}