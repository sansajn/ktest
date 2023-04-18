// regular expression sample (parsing exif GSP coordinate)

fun main(args: Array<String>) {
	val exifLongitude = "16/1,29/1,3477119/1000000"
	val exifLongitudeRef = "W"
	
	val coordExpr = Regex("""^(?<degNum>\d+)\/(?<degDenom>\d+),(?<minNum>\d+)\/(?<minDenom>\d+),(?<secNum>\d+)\/(?<secDenom>\d+)$""")
	
	val matchResult = coordExpr.matchEntire(exifLongitude)
	
	matchResult?.let {
		val degNum = it.groups["degNum"]!!.value.toInt()
		val degDenom = it.groups["degDenom"]!!.value.toInt()
		val minNum = it.groups["minNum"]!!.value.toInt()
		val minDenom = it.groups["minDenom"]!!.value.toInt()
		val secNum = it.groups["secNum"]!!.value.toInt()
		val secDenom = it.groups["secDenom"]!!.value.toInt()

		var coordDeg: Double = degNum/degDenom + minNum/minDenom/60.0 + secNum/secDenom/3600.0
		if (exifLongitudeRef == "W")  // | "S" in case of latitude
			coordDeg *= -1

		println("$degNum/$degDenom, $minNum/$minDenom, $secNum/$secDenom = $coordDeg")
	}
}
