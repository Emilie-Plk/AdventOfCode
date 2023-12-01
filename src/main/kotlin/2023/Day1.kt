package `2023`

import getPuzzleInput

class Day1 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val lines = getPuzzleInput(this)

            println("=*=*=*==* Part 1 *=*=*=*=*=")
            println(Day1().partOne(lines))

            println("=*=*=*==* Part 2 *=*=*=*=*=")
            println(Day1().partTwo(lines))

        }
    }

    private fun partOne(lines: List<String>) {
        println(
            lines.sumOf { line ->
                val concatenatedNumbers = Regex("\\d+").findAll(line).flatMap {
                    it.value.map { char -> char.toString().toInt() }
                }.toList()

                when {
                    concatenatedNumbers.size == 1 -> concatenatedNumbers[0] * 11
                    concatenatedNumbers.size >= 2 -> concatenatedNumbers.first() * 10 + concatenatedNumbers.last()
                    else -> 0
                }
            }
        )
    }


    private fun partTwo(lines: List<String>) {
        // println(lines)
    }
}