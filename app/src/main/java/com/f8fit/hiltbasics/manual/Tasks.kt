package com.f8fit.hiltbasics.manual

import com.f8fit.hiltbasics.Computer
import com.f8fit.hiltbasics.bad.DatabaseBad

class Tasks(private val database: Database) {
    //lateinit var database: Database

    private val computer: Computer by lazy { database.getComputer() }

    fun getBattery() = computer.batteryLife()

    fun turnOnOff(status :  Boolean): Int {
        computer.isActive = status
        return getBattery()
    }

    fun playVideo(): Int{
        computer.cpu = 1.5f
        computer.ram = 2f
        return getBattery()
    }

    fun playMusic(): Int{
        computer.cpu = 1.1f
        computer.ram = 1.1f
        return getBattery()
    }

    fun dev(): Int{
        computer.cpu = 1.2f
        computer.ram = 1.6f
        return getBattery()
    }
}