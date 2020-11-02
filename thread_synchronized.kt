// thread synchronization via synchronize() call
import kotlin.concurrent.thread
import java.util.concurrent.CountDownLatch

fun main(args: Array<String>) {

	var counter = 0
	val latch = CountDownLatch(100_000)
	for (i in 1..100_000) {
		thread {
			synchronized(latch) {
				counter++;
				latch.countDown()
			}
		}
	}
	latch.await()

	println("Counter $counter")

	println("done!")
}
