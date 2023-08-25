package com.f8fit.hiltbasics.bad

import com.f8fit.hiltbasics.Computer

open class DatabaseBad {
    private  val computer = Computer(cpu = .2f, ram = .1f) //consumo minimo

    fun getComputer(): Computer {
        return computer// simular la respuesta del servidor
    }
}