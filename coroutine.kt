@file:JvmName("coroutineKt")

/* compile with 
kotlinc coroutine.kt -cp kotlinx-coroutines-core.jar -include-runtime -d coroutine.jar

and run with

java -cp kotlinx-coroutines-core.jar:coroutine.jar coroutineKt

kotlinx-coroutines-core.jar needs to be copied to `coroutine.kt` directory

*/

import kotlinx.coroutines.*

fun main() {
	GlobalScope.launch { // launch a new coroutine in background and continue
		delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
		println("World!") // print after delay
	}
	println("Hello,") // main thread continues while coroutine is delayed
	Thread.sleep(2000L) // block main thread for 2 seconds to keep JVM alive
	println("done!")
}
