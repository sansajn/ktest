# Coroutines
This directory contains following coroutine samples based on `kotlinx.coroutines` library

- `hello.kt`: Coroutine *Hello World* sample.
- `starvation.ks`: Coroutine starvation sample from chapter 8 in *Hands-On Design Patterns with Kotlin* book.
- `fixed_starvation.kt`: Fixed starvation sample (`starvation.kt`) from chapter 8 in *Hands-On Design Patterns with Kotlin* book.
- `cancel.kt`: Canceling a coroutine sample from chapter 8 in *Hands-On Design Patterns with Kotlin* book. First use of `launch()` and `runBlocking()` library functions.
- `async.kt`: Coroutine `async()/await()` function sample from chapter 8 in *Hands-On Design Patterns with Kotlin* book.
- `async_wimeout.kt`: Coroutine `async()` with timeout function sample from chapter 8 in *Hands-On Design Patterns with Kotlin* book.
- `parent.kt`: Coroutine parent job sample (with parent job we can cancel all child jobs at once) from chapter 8 in *Hands-On Design Patterns with Kotlin* book.
- `channel.kt`: Job safe communication between coroutines with `Channel<>` sample where `Channel<>` acts like a blocking queue from chapter 8 in *Hands-On Design Patterns with Kotlin* book.
- `producer.kt`: Coroutine producer sample from chapter 8 in *Hands-On Design Patterns with Kotlin* book. First use of `produce()` function. Producer create coroutine with a build in channel for communication.
- `two_producers.kt`: Coroutine producer sample from chapter 8 in *Hands-On Design Patterns with Kotlin* book. First use of `select()` function.
- `actor.kt`: Coroutine actor sample from chapter 8 in *Hands-On Design Patterns with Kotlin* book. In a *Kotlin* manner actor is a coroutine with input channel.

## Design patterns

Concurrency pattern samples in a directory

- `active_object.kt`: Active Object design pattern sample (allows a method `activeActor()` to be executed in a safe way on another thread) from Chapter 9 in *Hands-On Design Patterns with Kotlin* book.
- `deferred.kt`: Deferred value sample (`await()` function can be called to wait for result) from Chapter 9 in *Hands-On Design Patterns with Kotlin* book.
- `barrier.kt`: Barrier design pattern sample based on async/await and `FavoriteCharacter` data class from Chapter 9 in *Hands-On Design Patterns with Kotlin* book.
> **TODO**: missing scheduler pattern sample
- `pipeline.kt`: not working :(
- `fanout.kt`: The fan-out design pattern sample from Chapter 9 in *Hands-On Design Patterns with Kotlin* book. There is one fast producer and many slow consumers.
- `fanin.kt`: The fan-in design pattern sample from Chapter 9 in *Hands-On Design Patterns with Kotlin* book. There are many fast producers and one consumer (`main`) there.
> **TODO**: missing samples for *Managing workers*, *Buffered channels*, *Unbiased select*, *Mutex*, *Selecting on close* from Chapter 9 in the book ...
