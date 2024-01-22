package com.example.algorithm_preparations.sort

fun main() {
    val result = mergeSort(listOf(1, 22, -10, 33, 129, 0, -4, -100, 4, 12, 55, 76, 1))

    println(result)
}

fun mergeSort(array: List<Int>): List<Int> {

    if (array.size == 1) {
        return array
    }

    val center = array.size / 2
    val left = array.slice(0 until center)
    val right = array.slice(center until array.size)

    val leftResult = mergeSort(left)
    val rightResult = mergeSort(right)

    val result = mutableListOf<Int>()

    var leftIterator = 0
    var rightIterator = 0

    while (result.size != leftResult.size + rightResult.size) {
        if (leftIterator == leftResult.size) {
            result.addAll(rightResult.slice(rightIterator until rightResult.size))
            break
        }

        if (rightIterator == rightResult.size) {
            result.addAll(leftResult.slice(leftIterator until leftResult.size))
            break
        }

        val leftValue = leftResult[leftIterator]
        val rightValue = rightResult[rightIterator]

        if (leftValue > rightValue) {
            result.add(rightValue)
            rightIterator++
        } else {
            result.add(leftValue)
            leftIterator++
        }
    }

    return result
}