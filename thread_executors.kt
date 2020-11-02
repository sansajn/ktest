// limit number of running threads with executors
import kotlin.concurrent.thread
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

fun main(args: Array<String>) {
	val pool = Executors.newFixedThreadPool(100)
	val counter = AtomicInteger(0)

	val start = System.currentTimeMillis()
	for (i in 1..100_000) {
		pool.submit {
			counter.incrementAndGet()  // do something
			Thread.sleep(100)  // simulate wait on IO
			counter.incrementAndGet()  // do something again
		}
	}

	pool.awaitTermination(20, TimeUnit.SECONDS)
	pool.shutdown()

	println("Took me ${System.currentTimeMillis() - start} millis to complete ${counter.get() / 2} tasks")

	println("done!")
}
