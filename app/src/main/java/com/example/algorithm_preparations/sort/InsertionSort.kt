package com.example.algorithm_preparations.sort

fun main() {
    val result = insertionSort(listOf(1, 22, -10, 33, 129, 0, -4, -100, 4, 12, 55, 76, 1))

    println(result)
}

fun insertionSort(array: List<Int>): List<Int> {
    val resultArray = array.toMutableList()

    for (position in 1 until array.size) {
        val positionNum = resultArray[position]
        var targetIndex = position
        for (index in position downTo 0) {
            val currentNum = resultArray[index]
            if (positionNum <= currentNum) {
                targetIndex = index
            } else {
                break
            }
        }

        if (position != targetIndex) {
            for (index in position downTo targetIndex + 1) {
                resultArray[index] = resultArray[index - 1]
            }
        }

        resultArray[targetIndex] = positionNum
    }

    return resultArray
}