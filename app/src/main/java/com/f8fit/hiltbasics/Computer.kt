package com.f8fit.hiltbasics

data class Computer(
    var isActive: Boolean = false,
    var cpu: Float = 0f,
    var ram : Float = 0f,
    private val battery: Int = 10
) {
    fun batteryLife(): Int {
        val performance = cpu * ram + if (isActive) 1f else .1f
        return (battery / performance).toInt()
    }
}
