package com.leonardobufalo.tour.constroller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthCheck {

    @RequestMapping(value = ["/healthcheck"], method = [RequestMethod.GET])
    fun health(): Boolean {
        return true
    }
}