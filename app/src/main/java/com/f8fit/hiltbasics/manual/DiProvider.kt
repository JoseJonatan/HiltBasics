package com.f8fit.hiltbasics.manual

object DiProvider {

    private val database = Database()

    fun tasks() = Tasks(database)
}