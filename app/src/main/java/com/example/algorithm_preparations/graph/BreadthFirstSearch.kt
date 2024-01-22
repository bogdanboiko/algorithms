package com.example.algorithm_preparations.graph

import java.util.LinkedList

fun main() {
    val graph = listOf(Pair("a", "b"), Pair("a", "h"), Pair("b", "c"), Pair("h", "i"), Pair("i", "ch"), Pair("h", "g"), Pair("i", "g"), Pair("g", "f"), Pair("c", "f"), Pair("c", "d"), Pair("d", "e"), Pair("f", "e"))
    println(breadthFirstSearch(graph, "a", "d"))
}

fun breadthFirstSearch(graph: List<Pair<String, String>>, start: String, end: String): List<String> {
    val visited = mutableListOf<Pair<String, String>>()
    val queue = LinkedList<String>()
    queue.add(start)
    visited.add(Pair(start, ""))
    while (queue.isNotEmpty()) {
        val current = queue.poll()

        if (current == end) {
            break
        }

        for (edge in graph) {
            if (edge.first == current) {
                if (visited.find { it.first == edge.second } == null) {
                    visited.add(Pair(edge.second, current))
                    queue.add(edge.second)
                }
            }
        }
    }

    val resultPath = mutableListOf<String>()

    var point = visited.find { it.first == end }

    return if (point != null) {
        while (point?.first != start) {
            point?.first?.let { resultPath.add(it) }

            point = visited.find { it.first == point?.second }
        }

        resultPath.add(start)
        resultPath
    } else {
        emptyList()
    }
}