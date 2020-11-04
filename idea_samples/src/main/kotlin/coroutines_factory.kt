import kotlinx.coroutines.*
import java.util.*
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

val latch = CountDownLatch(10*2)

fun main(args: Array<String>) {
	for (i in 1..10) {
		CoroutineFactory.greedyLongCoroutine(i)
	}

	for (i in 1..10) {
		CoroutineFactory.shortCoroutine(i)
	}

	latch.await(10, TimeUnit.SECONDS)

	println("done!")
}

object CoroutineFactory {
	fun greedyLongCoroutine(index: Int) = GlobalScope.async {
		var uuid = UUID.randomUUID()
		for (i in 1..100_000) {
			val newUuid = UUID.randomUUID()

			if (newUuid < uuid) {
				uuid = newUuid
			}
		}

		println("Done greedyLongCoroutine $index")
		latch.countDown()
	}

	fun shortCoroutine(index: Int) = GlobalScope.async {
		println("Done shortCoroutine $index!")
		latch.countDown()
	}
}
