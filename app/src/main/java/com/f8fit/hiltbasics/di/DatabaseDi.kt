package com.f8fit.hiltbasics.di

import com.f8fit.hiltbasics.Computer
import javax.inject.Inject

open class DatabaseDi @Inject constructor(){
    private  val computer = Computer(cpu = .15f, ram = .1f) //consumo minimo

    fun getComputer(): Computer {
        return computer// simular la respuesta del servidor
    }
}