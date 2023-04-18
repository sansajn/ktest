// iterating over the directory sample
import java.io.File

fun main(args: Array<String>) {
	File(".").walk().forEach {
		println(it.getAbsolutePath());
	}

	println("done!");
}
