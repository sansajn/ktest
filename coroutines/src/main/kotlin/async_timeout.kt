// Coroutine `async()` with timeout function sample from chapter 8 in *Hands-On Design Patterns with Kotlin* book.
import kotlinx.coroutines.*
import java.util.*

fun main() {
	val coroutine = GlobalScope.async {
		withTimeout(500L) {
			try {
				val time = Random().nextInt(1000).toLong()
				println("It will take me $time to do")
				delay(time)
				println("Returning profile")
				"Profile"
			}
			catch (e: TimeoutCancellationException) {
				e.printStackTrace()
			}
		}
	}

	runBlocking {
		val result = try {
			coroutine.await()
		} catch (e: TimeoutCancellationException) {
			"No Profile"
		}

		println(result)
	}

	println("done!")
}
