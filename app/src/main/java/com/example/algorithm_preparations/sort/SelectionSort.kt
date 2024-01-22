package com.example.algorithm_preparations.sort

fun main() {
    val result = selectionSort(listOf(1, 22, -10, 33, 129, 0, -4, -100, 4, 12, 55, 76, 1))

    println(result)
}

fun selectionSort(array: List<Int>): List<Int> {
    val resultArray = array.toMutableList()
    for (position in array.indices) {
        var min = resultArray[position]
        var minIndex = position
        for (index in position until array.size) {
            val nextNum = resultArray[index]

            if (nextNum < min) {
                min = nextNum
                minIndex = index
            }
        }

        val buffer = resultArray[position]
        resultArray[position] = min
        resultArray[minIndex] = buffer
    }

    return resultArray
}