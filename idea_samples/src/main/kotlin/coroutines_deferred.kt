// deferred value sample (`await()` function can be called to wait for result)
import kotlinx.coroutines.*
import java.lang.RuntimeException
import java.util.*

fun main() {
	val deferred = CompletableDeferred<String>()

	GlobalScope.launch {
		delay(100)
		if (Random().nextBoolean()) {
			deferred.complete("OK")
		}
		else {
			deferred.completeExceptionally(RuntimeException())
		}
	}

	runBlocking {
		try {
			println(deferred.await())
		}
		catch (e: RuntimeException) {
			e.printStackTrace()
		}
	}

	println("done!")
}
