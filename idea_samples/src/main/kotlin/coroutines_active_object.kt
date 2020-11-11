// active object design pattern sample (allows a method to be executed in a safe way on another thread)
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

fun activeActor(out: SendChannel<String>) = GlobalScope.actor<Int> {
	for (i in this) {
		out.send(i.toString().reversed())
	}
	out.close()
}

fun main() {
	val channel = Channel<String>()
	val actor = activeActor(channel)

	val j1 = GlobalScope.launch {
		for (i in 42 .. 53) {
			actor.send(i)
		}
		actor.close()
	}

	val j2 = GlobalScope.launch {
		for (i in channel) {
			println(i)
		}
	}

	runBlocking {
		j1.join()
		j2.join()
	}

	println("done!")
}
