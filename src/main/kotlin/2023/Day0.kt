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
        println("Hello ")
    }

    private fun partTwo(lines: List<String>) {
        println("there!")
    }
}