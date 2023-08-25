package com.f8fit.hiltbasics.manual

import com.f8fit.hiltbasics.Computer

open class Database {
    private  val computer = Computer(cpu = .15f, ram = .1f) //consumo minimo

    fun getComputer(): Computer {
        return computer// simular la respuesta del servidor
    }
}