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
        println(
            lines.sumOf { line ->
                val regexRule = Regex(
                    "\\d+|(oneight|twone|eightwo|eighthree|fiveight|nineight|threeight|tenine|sevenine|one|two|three|four|five|six|seven|eight|nine)",
                    RegexOption.MULTILINE
                )
                val isolatedStringDigits: List<String> = regexRule.findAll(line).map { it.value }.toList()
                println(
                    "isolatedStringDigits.firstOrNull( ${isolatedStringDigits.firstOrNull()}" +
                            " and isolatedStringDigits.lastOrNull(): ${isolatedStringDigits.lastOrNull()}"
                )

                val firstUntangledIsolatedStringDigits = isolatedStringDigits.map {
                    when (it) {
                        "oneight" -> "one"
                        "twone" -> "two"
                        "eightwo" -> "eight"
                        "eighthree" -> "eight"
                        "fiveight" -> "five"
                        "threeight" -> "three"
                        "nineight" -> "nine"
                        "tenine" -> "ten"
                        "sevevine" -> "seven"
                        else -> it
                    }
                }
                val lastUntangledIsolatedStringDigits = isolatedStringDigits.map {
                    when (it) {
                        "oneight" -> "eight"
                        "twone" -> "one"
                        "eightwo" -> "two"
                        "eighthree" -> "three"
                        "fiveight" -> "eight"
                        "threeight" -> "eight"
                        "nineight" -> "eight"
                        "tenine" -> "nine"
                        "sevevine" -> "nine"
                        else -> it
                    }
                }

                val firstNumber = firstUntangledIsolatedStringDigits.firstOrNull()
                    ?.let {
                        if (it.matches(Regex("\\d+"))) it.first()
                        else Digits.valueOf(it.uppercase()).longValue
                    }
                    ?: 0
                val lastNumber = lastUntangledIsolatedStringDigits.lastOrNull()
                    ?.let {
                        if (it.matches(Regex("\\d+"))) it.last()
                        else Digits.valueOf(it.uppercase()).longValue
                    }
                    ?: 0
                println("*~*~*~*~*~*~*~*~*~\nLine input: $line \nIsolated: $isolatedStringDigits with first $firstNumber and last $lastNumber that gives ${"$firstNumber$lastNumber".toLong()}\n*~*~*~*~*~*~*~*~*~\n")
                "$firstNumber$lastNumber".toLong()
            })
    }

    private enum class Digits(val longValue: Long) {
        ONE(1L),
        TWO(2L),
        THREE(3L),
        FOUR(4L),
        FIVE(5L),
        SIX(6L),
        SEVEN(7L),
        EIGHT(8L),
        NINE(9L)
    }
}