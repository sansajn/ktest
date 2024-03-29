// Receiving from two coroutine producers with `select()` sample from chapter 8 in *Hands-On Design Patterns with Kotlin* book.
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import kotlinx.coroutines.selects.select
import java.util.*

fun main() {
	val firstProducer = GlobalScope.produce<String> {
		delay(Random().nextInt(100).toLong())
		send("first")
	}

	val secondProducer = GlobalScope.produce<String> {
		delay(Random().nextInt(100).toLong())
		send("second")
	}

	runBlocking {
		val winner = select<String> {
			firstProducer.onReceive { it.toLowerCase() }
			secondProducer.onReceive { it.toUpperCase() }
		}

		println("$winner")
	}

	println("done!")
}
