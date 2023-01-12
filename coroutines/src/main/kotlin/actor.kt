// Coroutine actor sample from chapter 8 in *Hands-On Design Patterns with Kotlin* book. In a Kotlin manner actor is a coroutine with input channel.
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

data class Task(val description: String)

fun michael(actor: SendChannel<Task>) {
	runBlocking {
		// he has some range of tasks
		for (i in 'a'..'z') {
			actor.send(Task(i.toString()))
		}

		// and then he's done with the list, he let's me know
		actor.close()

		// but that doesn't mean I'm done working on it, though
	}
}

fun main() {
	val me = GlobalScope.actor<Task> {
		while (!isClosedForReceive) {
			println(receive().description.repeat(10))
		}
	}

	// we can use receiveOrNull() to iterate tasks
	val meAgain = GlobalScope.actor<Task> {
		var next = receiveCatching().getOrNull()
		while (next != null) {
			println(next.description.toUpperCase())
			next = receiveCatching().getOrNull()
		}
	}

	// we can also use ranges to iterate tasks
	val meWithRange = GlobalScope.actor<Task> {
		for (t in channel) {
			println(t.description)
		}
	}

	michael(me)
	michael(meAgain)
	michael(meWithRange)

	println("done!")
}
