// fixing starvation sample (see `coroutines_starvation.kt`) (see chapter 8 from Hands-On Design Patterns with Kotlin)
import kotlinx.coroutines.*
import java.util.*
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

private val latch = CountDownLatch(20*2)

fun main(args: Array<String>) {
	for (i in 1..20) {
		CoroutineFactoryFixed.longCoroutine(i)
	}

	for (i in 1..20) {
		CoroutineFactoryFixed.shortCoroutine(i)
	}

	latch.await(10, TimeUnit.SECONDS)

	println("done!")
}

object CoroutineFactoryFixed {
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

	fun longCoroutine(index: Int) = GlobalScope.async {
		var uuid = UUID.randomUUID()
		for (i in 1..100_000) {
			val newUuid = UUID.randomUUID()

			if (newUuid < uuid) {
				uuid = newUuid
			}

			if (i % 100 == 0) {
				yield()
			}
		}
		println("Done longCoroutine $index")
		latch.countDown()
	}
}

