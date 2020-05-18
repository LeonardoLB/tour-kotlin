package com.leonardobufalo.tour

import com.leonardobufalo.tour.model.Promocao
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.concurrent.ConcurrentHashMap

@SpringBootApplication
class TourApplication {
	companion object {
		val initialPromocoes = arrayOf(
				Promocao(1, "Viajem Paris", "Paris",true, 5, 9000.00),
				Promocao(2, "Viajem Roma", "Roma",false, 2, 6700.00),
				Promocao(3, "Viajem Canada", "Toronto",true, 20, 18000.00),
				Promocao(4, "Viajem Germany", "Munich",true, 7, 10000.00)
		)
	}

	@Bean
	fun promocoes(): ConcurrentHashMap<Long, Promocao> {
		return ConcurrentHashMap<Long, Promocao>(initialPromocoes.associateBy(Promocao::id))
	}
}

fun main(args: Array<String>) {
	runApplication<TourApplication>(*args)
}