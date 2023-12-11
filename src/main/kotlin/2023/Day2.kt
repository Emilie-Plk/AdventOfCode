package `2023`

import getPuzzleInput

class Day2 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val lines = getPuzzleInput(this)

            println("=*=*=*==* Part 1 *=*=*=*=*=")
            println(Day2().partOne(lines))

            println("=*=*=*==* Part 2 *=*=*=*=*=")
            println(Day2().partTwo(lines))
        }
    }

    private val setsRegex = Regex("(?:\\d+ (?:red|blue|green)(?:, )?)+(?:(?<!,\\s)\$|;\\s)")

    private fun partOne(lines: List<String>) {
        val games = mutableListOf<Game>()
        lines.forEach { line ->
            val gameId = Regex("\\d+").find(line)?.value?.toInt() ?: 0
            val cubeSetsPerGame = mutableListOf<CubeSet>()
            for (match in setsRegex.findAll(line)) {
                val cubeSet =
                    CubeSet(
                        redCubeValue = Regex("\\d+(?=\\s+red)").findAll(match.value).map { it.value }
                            .sumOf { it.toInt() }.takeIf { it <= 12 } ?: return@forEach,
                        blueCubeValue = Regex("\\d+(?=\\s+blue)").findAll(match.value).map { it.value }
                            .sumOf { it.toInt() }.takeIf { it <= 14 } ?: return@forEach,
                        greenCubeValue = Regex("\\d+(?=\\s+green)").findAll(match.value).map { it.value }
                            .sumOf { it.toInt() }.takeIf { it <= 13 } ?: return@forEach,
                    )
                cubeSetsPerGame.add(cubeSet)
            }
            games.add(Game(gameId = gameId, setsOfCubes = cubeSetsPerGame))
        }
        println(games.sumOf { it.gameId })
    }

    private fun partTwo(lines: List<String>) {
        println(
            lines.sumOf { line ->
                Regex("\\d+(?=\\s+red)").findAll(line).maxOf { it.value.toInt() } *
                        Regex("\\d+(?=\\s+blue)").findAll(line).maxOf { it.value.toInt() } *
                        Regex("\\d+(?=\\s+green)").findAll(line).maxOf { it.value.toInt() }
            }
        )
    }
}


private data class CubeSet(
    val redCubeValue: Int?,
    val blueCubeValue: Int?,
    val greenCubeValue: Int?,
)

private data class Game(
    val gameId: Int,
    val setsOfCubes: List<CubeSet> = listOf()
)