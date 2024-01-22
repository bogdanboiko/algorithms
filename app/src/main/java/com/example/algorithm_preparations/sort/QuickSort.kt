package com.example.algorithm_preparations.sort

fun main() {
    val result = quickSortAlgorithm(listOf(1, 22, -10, 33, 129, 0, -4, -100, 4, 12, 55, 76, 1))

    println(result)
}

fun quickSortAlgorithm(array: List<Int>): List<Int> {
    if (array.size <= 1) {
        return array
    }

    println(array)
    val pivotPoint = array.last()
    val left = mutableListOf<Int>()
    val right = mutableListOf<Int>()
    val result = mutableListOf<Int>()

    for (i in 0 until array.size - 1) {
        if (array[i] < pivotPoint) {
            left.add(array[i])
        } else {
            right.add(array[i])
        }
    }
    println("left: $left")
    println("right: $right")

    val leftSorted = quickSortAlgorithm(left)
    for (i in leftSorted) {
        result.add(i)
    }

    result.add(pivotPoint)

    val rightSorted = quickSortAlgorithm(right)
    for (i in rightSorted) {
        result.add(i)
    }

    return result
}