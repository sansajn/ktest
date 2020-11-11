// produce function sample
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

fun main() {
	val publisher: ReceiveChannel<Int> = GlobalScope.produce {
		for (i in 2018 downTo 1970) {
			send(i)
			delay(20)
		}
	}

	runBlocking {
		publisher.consumeEach {
			println("Got $it")
		}
	}

	println("done!")
}
