/* The fan-in design pattern sample from Chapter 9 in *Hands-On Design Patterns with Kotlin* book.
There are many fast producers and one consumer (`main`) there. */
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import java.util.*

fun techBunch(collector: Channel<String>) = GlobalScope.launch {
	repeat(10) {
		delay(Random().nextInt(1000).toLong())
		collector.send("Tech Bunch")
	}
}

fun theFerge(collector: Channel<String>) = GlobalScope.launch {
	repeat(10) {
		delay(Random().nextInt(1000).toLong())
		collector.send("The Ferge")
	}
}

fun main() {
	val collector = Channel<String>()
	techBunch(collector)
	theFerge(collector)

	runBlocking {
		collector.consumeEach {
			println("Got news from $it")
		}
	}
}
