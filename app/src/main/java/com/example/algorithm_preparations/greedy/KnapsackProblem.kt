package com.example.algorithm_preparations.greedy

fun main() {
    val maxWeight = 20
    val valuables = mapOf("Apple" to Pair(300, 10), "Pear" to Pair(400, 4), "Snack" to Pair(600, 7), "Banana" to Pair(500, 5))
    val result = greedyKnapsackSalvation(maxWeight, valuables)
    println("total cost: ${result.map { valuables[it]?.second ?: 0 }.reduce { first, second -> first + second }}")
    println("total weight: ${result.map { valuables[it]?.first ?: 0 }.reduce { first, second -> first + second }}")
    println(greedyKnapsackSalvation(maxWeight, valuables))
}

fun greedyKnapsackSalvation(knapsackMaxWeight: Int, valuables: Map<String, Pair<Int, Int>>): List<String> {
    val mutableValuables = valuables.toMutableMap()

    var freeSpace = knapsackMaxWeight
    val result = mutableListOf<String>()

    while (freeSpace != 0) {
        var maxCoefficient = 0
        var mostValuableItemPerIteration: String? = null
        mutableValuables.forEach { valuable ->
            val coefficient = valuable.value.first / valuable.value.second

            if (coefficient > maxCoefficient) {
                if (freeSpace >= valuable.value.second) {
                    maxCoefficient = coefficient
                    mostValuableItemPerIteration = valuable.key
                }
            }
        }

        if (mostValuableItemPerIteration != null) {
            result.add(mostValuableItemPerIteration!!)
            freeSpace -= mutableValuables[mostValuableItemPerIteration]?.second ?: 0
//            mutableValuables.remove(mostValuableItemPerIteration)
        } else {
            break
        }
    }

    return result
}