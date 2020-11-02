// using threads sample
import kotlin.concurrent.thread

fun main(args: Array<String>) {
	val t1 = thread {
		for (i in 1..100) {
			println("T1: $i")
		}
	}

	val t2 = thread {
		for (i in 1..100) {
			println("T2: $i")
		}
	}

	println("done!")
}
