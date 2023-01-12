/* The fan-out design pattern sample from Chapter 9 in *Hands-On Design Patterns with Kotlin* book.
There is one fast producer and many slow consumers. */
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce

fun producePages() = GlobalScope.produce {
	for (i in 1..10_000)
		for (c in 'a'..'z')
			send(i to "page$c")
}

fun consumePages(channel: ReceiveChannel<Pair<Int, String>>) = GlobalScope.async {
	for (p in channel)
		println(p)
}

fun main() {
	val producer = producePages()
	val consumers = List(10) {
		consumePages(producer)
	}

	runBlocking {
		consumers.forEach {
			it.await()
		}
	}
}