/* The sample produce following output
coroutineScope: done!
Kotlin Coroutines World!
main: done! */
import kotlinx.coroutines.*

suspend fun main() {
	coroutineScope {
		launch {
			delay(1000)
			println("Kotlin Coroutines World!")
		}
		println("coroutineScope: done!")
	}  // this is blocking

	println("main: done!")
}
