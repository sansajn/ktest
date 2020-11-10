// coroutine parent job sample (with parent job we can cancel all child jobs at once)
import kotlinx.coroutines.*
import java.util.*

fun main() {
	val parentJob = Job()

	List(10) {
		GlobalScope.async(Dispatchers.Default + parentJob) {
			produceBeautifulUuid()
		}
	}

	runBlocking {
		delay(100)
		parentJob.cancel()
		delay(1000)
	}

	println("done!")
}

suspend fun produceBeautifulUuid(): String {
	try {
		val uuids = List(1000) {
			yield()
			UUID.randomUUID()
		}

		println("coroutine done")
		return uuids.sorted().first().toString()
	} catch (t: CancellationException) {
		println("got cancelled")
	}

	return ""
}
