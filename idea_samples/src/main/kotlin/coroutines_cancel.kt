// canceling a coroutine sample
import kotlinx.coroutines.*

fun main() {
	val cancellable = GlobalScope.launch {
		try {
			for (i in 1..1000) {
				println("Cancelable: $i")
				yield()  // calling yield() means that job (coroutine) can be cancelled
			}
		}
		catch (e: CancellationException) {
			e.printStackTrace()
		}
	}

	val notCancellable = GlobalScope.launch {
		for (i in 1..1000) {
			println("Not cancellable $i")
		}
	}

	println("Canceling cancellable")
	cancellable.cancel()

	println("Canceling not cancellable")
	notCancellable.cancel()

	runBlocking {
		cancellable.join()
		notCancellable.join()
	}

	println("done!")
}
