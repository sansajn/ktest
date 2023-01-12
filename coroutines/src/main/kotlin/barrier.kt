// Barrier design pattern sample based on async/await and `FavoriteCharacter` data class from Chapter 9 in *Hands-On Design Patterns with Kotlin* book.
import kotlinx.coroutines.*
import java.util.*

// `FavoriteCharacter` represent barrier in our case
data class FavoriteCharacter(val name: String, val catchphrase: String, val repeats: Int)


fun main() {
	runBlocking {
		val character = FavoriteCharacter(
			getName().await(), getCatchphrase().await(), getRepeats().await())

		with(character) {
			println("$name says: ${catchphrase.repeat(repeats)}")
		}
	}

	println("done!")
}

fun getName() = GlobalScope.async {
	delay(Random().nextInt(100).toLong())
	println("Got name")
	"Inigo Montoya"
}

fun getCatchphrase() = GlobalScope.async {
	delay(Random().nextInt(100).toLong())
	println("Got catchphrase")
	"Hello. My name is Inigo Montoya. You killed my father. Prepare to die."
}

fun getRepeats() = GlobalScope.async {
	delay(Random().nextInt(100).toLong())
	println("Got repeats")
	6
}
