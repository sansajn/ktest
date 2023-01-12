// Job safe communication between coroutines with `Channel<>` sample where `Channel<>` acts like a blocking queue from chapter 8 in *Hands-On Design Patterns with Kotlin* book.
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import java.util.*

fun player(name: String,
	input: Channel<Int>,
	output: Channel<Int>) = GlobalScope.launch {

	for (m in input) {
		val d = Random().nextInt(100)
		println("$name got $m, ${if (d > m) "won" else "lost"}")
		delay(d.toLong())
		output.send(d)
	}
}

fun main() {
	val p1p2 = Channel<Int>()
	val p2p1 = Channel<Int>()

	val player1 = player("Player 1", p2p1, p1p2)
	val player2 = player("Player 2", p1p2, p2p1)

	runBlocking {
		p2p1.send(0)
		delay(1000)  // after ~1s delay program ends
	}

	println("done!")
}
