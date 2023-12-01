package `2023`

import getPuzzleInput

class Day0 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val lines = getPuzzleInput(this)

            println("=*=*=*==* Part 1 *=*=*=*=*=")
            println(Day0().partOne(lines))

            println("=*=*=*==* Part 2 *=*=*=*=*=")
            println(Day0().partTwo(lines))

        }
    }

    private fun partOne(lines: List<String>) {
        val result = mutableListOf<Int>()

        val regex = Regex("\\d+")

        for (line in lines) {
            val matches = regex.findAll(line)
            val numbers = matches.map { it.value.toInt() }.toList()

            val sum = when (numbers.size) {
                0 -> 0
                1 -> numbers[0] * 2
                2 -> numbers.sum()
                else -> throw IllegalStateException("Unexpected number of matches: ${numbers.size}")
            }

            result.add(sum)
        }

        println(result)
    }

    private fun partTwo(lines: List<String>) {
        println(lines)
    }
}