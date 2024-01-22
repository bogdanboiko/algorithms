package com.example.algorithm_preparations.graph

fun main() {
    val graph = hashMapOf(Pair("a", "b") to 12, Pair("a", "c") to 3, Pair("a", "e") to 17,
        Pair("b", "d") to 6, Pair("b", "c") to 2, Pair("b", "f") to 4, Pair("c", "d") to 19,
        Pair("c", "f") to 5, Pair("c", "g") to 4, Pair("d", "e") to 2, Pair("e", "f") to 7,
        Pair("f", "g") to 6)
    dijkstraAlgorithm(graph, "d", "g")
}

fun dijkstraAlgorithm(graph: HashMap<Pair<String, String>, Int>, start: String, end: String) {
    val parents = mutableMapOf<String, String>()
    val costs = mutableMapOf<String, Int>()

    val set = mutableSetOf<String>()

    graph.keys.forEach {
        set.add(it.first)
        set.add(it.second)
    }

    set.forEach {
        parents[it] = ""
        costs[it] = Int.MAX_VALUE
    }

    costs[start] = 0

    while (set.isNotEmpty()) {
        val current = set.minByOrNull { costs[it] ?: 0 }

        set.remove(current)

        if (current == end) {
            break
        }

        graph.filter {
            it.key.first == current
        }.forEach { edge ->
            val alt = (costs[current] ?: 0) + (graph[edge.key] ?: 0)

            if (alt < (costs[edge.key.second] ?: 0)) {
                parents[edge.key.second] = edge.key.first
                costs[edge.key.second] = alt
            }
        }
    }

    val path = mutableListOf<String>()

    path.add(0, end)

    var value = parents[end]

    while (value != start) {
        if (value != null) {
            path.add(0, value)
            value = parents[value]
        }
    }

    path.add(0, start)

    println(path)
    println(costs[end])
}