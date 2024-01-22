package com.example.algorithm_preparations.sort

fun main() {
    val result = bubbleSort(listOf(1, 22, -10, 33, 129, 0, -4, -100, 4, 12, 55, 76, 1))

    println(result)
}

fun bubbleSort(array: List<Int>): List<Int> {
    var isStillUpdating = true
    val resultArray = array.toMutableList()
    while (isStillUpdating) {
        isStillUpdating = false

        for (index in 0 until array.size - 1) {
            val current = resultArray[index]
            val next = resultArray[index + 1]

            if (current > next) {
                resultArray[index] = next
                resultArray[index + 1] = current
                isStillUpdating = true
            }
        }
    }

    return resultArray
}