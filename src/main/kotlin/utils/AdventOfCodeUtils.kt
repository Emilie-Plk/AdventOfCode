import java.io.File
import java.util.*

fun getPuzzleInput(companion: Any): List<String> {
    val day = companion::class.java.enclosingClass.simpleName.lowercase(Locale.getDefault())
    val year = companion::class.java.enclosingClass.packageName.takeLast(4)
println("day $day and year $year")
    return File("data/$year/$day.txt").readLines()
}