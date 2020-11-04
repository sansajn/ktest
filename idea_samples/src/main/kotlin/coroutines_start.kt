// starting coroutines sample (compare with `thread_executors.kt` sample)
import kotlinx.coroutines.*
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

fun main() {
	val latch = CountDownLatch(10_000)
	val counter = AtomicInteger()

	val start = System.currentTimeMillis()
	for (i in 1..10_000) {
		GlobalScope.launch {
			counter.incrementAndGet()
			delay(100)
			counter.incrementAndGet()
			latch.countDown()
		}
	}

	latch.await(10, TimeUnit.SECONDS)

	println("Executed ${counter.get()/2} coroutines in ${System.currentTimeMillis() - start}ms")
	println("done!")
}
