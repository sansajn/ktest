// working with date and time in kotlin sample
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun main(args: Array<String>) {
	// now
	val now = LocalDateTime.now()
	println(now)
	
	// 2023:04:09
	val dateFmt = DateTimeFormatter.ofPattern("yyyy:MM:dd")
	val date1 = LocalDate.parse("2023:04:09", dateFmt)
	println(date1)

	// 2023:04:09 12:40:26
	val dateTimeFmt = DateTimeFormatter.ofPattern("yyyy:MM:dd HH:mm:ss")
	val dateTime = LocalDateTime.parse("2023:04:09 12:40:26", dateTimeFmt)
	println(dateTime)

	println("done!")
}
