// coroutine `join()` sample
import kotlinx.coroutines.*

fun main() {
	val j = GlobalScope.launch {
		for (i in 1..100_000) {
			if (i % 1000 == 0) {
				println(i)
				yield()
			}
		}
	}

	runBlocking {
		j.join()
	}

	println("done!")
}
