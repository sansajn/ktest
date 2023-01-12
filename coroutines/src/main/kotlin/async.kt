// Coroutine `async()/await()` function sample from chapter 8 in *Hands-On Design Patterns with Kotlin* book.
import kotlinx.coroutines.*
import java.util.*

fun main() {
	val userProfile = GlobalScope.async {
		delay(Random().nextInt(100).toLong())
		"Profile"
	}

	val userHistory = GlobalScope.async {
		delay(Random().nextInt(200).toLong())
		listOf(1, 2, 3)
	}

	runBlocking {
		println("User profile is ${userProfile.await()} and his history is ${userHistory.await()}.")
	}

	println("done!")
}