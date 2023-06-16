// sample to directly use CoroutineScope
import kotlinx.coroutines.*

suspend fun main() = coroutineScope {
	launch {
		delay(1000)
		println("Coroutine executed!")
	}
	println("done!")
}
