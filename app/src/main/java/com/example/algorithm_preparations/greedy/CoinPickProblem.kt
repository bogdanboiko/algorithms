package com.example.algorithm_preparations.greedy

fun main() {
    println(coinPickProblem(116, listOf(33, 22, 11, 5, 3, 1)))
}

fun coinPickProblem(amount: Int, nominals: List<Int>): List<Int> {
    var remainingAmount = amount
    val resultNominals = mutableListOf<Int>()

    while (remainingAmount != 0) {
        var pickedNominal = 0

        nominals.forEach {nominal ->
            if (nominal in (pickedNominal + 1)..remainingAmount) {
                    pickedNominal = nominal
            }
        }

        if (pickedNominal != 0) {
            remainingAmount -= pickedNominal
            resultNominals.add(pickedNominal)
        } else {
            break
        }
    }
    return resultNominals
}