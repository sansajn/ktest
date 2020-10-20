// MutableMap<K, V>.getOrPut() sample

fun main(args: Array<String>) {
	var m = mutableMapOf<String, Int>()
	
	val v1 = m.getOrPut("one") {
		println("one=1 added")
		1
	}

	val v2 = m.getOrPut("one") {
		println("one=1 added second time")  // should newer be executed
		2
	}

	println("$m")

	println("done!")
}