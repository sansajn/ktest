// sample to directly use CoroutineScope
import kotlinx.coroutines.*

fun main() {
	// coroutine scope
	val scope = CoroutineScope(Dispatchers.Default)
	scope.launch {
		delay(1000)
		println("Coroutine executed!")
	}

	// wait for coroutine scope to complete
	runBlocking {
		delay(2000)
		println("Program completed!")
	}

	scope.cancel()  // cancel coroutine scope
}

