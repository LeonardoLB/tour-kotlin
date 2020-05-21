package com.leonardobufalo.tour.controller

import com.leonardobufalo.tour.model.Promocao
import com.leonardobufalo.tour.service.PromocaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/promocoes"])
class PromocaoController {

    @Autowired
    lateinit var promocaoService: PromocaoService

    @GetMapping(value = ["/{id}"])
    fun getById(@PathVariable id: Long): ResponseEntity<Promocao?> {
        val promocao: Promocao? = promocaoService.getById(id)
        var status = if(promocao == null) HttpStatus.NOT_FOUND else HttpStatus.OK
        return ResponseEntity(promocao, status)
    }

    @GetMapping()
    fun getAll(@RequestParam(required = false, defaultValue = "") localFilter: String): ResponseEntity<List<Promocao>> {
        val promocoes = promocaoService.getAll(localFilter)
        val status = if(promocoes == null) HttpStatus.NOT_FOUND else HttpStatus.OK
        return ResponseEntity(promocoes, status)
    }

    @PostMapping()
    fun create(@RequestBody promocao: Promocao): ResponseEntity<Promocao?> {
        val promocao: Promocao? = promocaoService.create(promocao)
        val status = if(promocao == null) HttpStatus.NOT_FOUND else HttpStatus.CREATED
        return ResponseEntity(promocao, status)
    }

    @DeleteMapping(value = ["/{id}"])
    fun delete(@PathVariable id: Long): ResponseEntity<Promocao?> {
        val promocao: Promocao? = promocaoService.delete(id)
        val status = if(promocao == null) HttpStatus.NOT_FOUND else HttpStatus.OK
        return ResponseEntity(promocao, status)
    }

    @PutMapping()
    fun update(@RequestBody promocao: Promocao): ResponseEntity<Promocao?> {
        val promocaoDeleted: ResponseEntity<Promocao?> = delete(promocao.id)
        val promocaoCreated: ResponseEntity<Promocao?> = create(promocao)
        val status =
                if(promocaoDeleted.statusCode == HttpStatus.OK && promocaoCreated.statusCode == HttpStatus.CREATED) HttpStatus.OK
                    else HttpStatus.NOT_MODIFIED
        return ResponseEntity(promocaoCreated.body, status)
    }

}