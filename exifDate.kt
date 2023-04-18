// Converting EXIF DateTimeOriginal and offset tags to posix timestamp sample.
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

fun main(args: Array<String>) {
	val exifDateTimeOriginal = "2023:04:02 17:38:16"  // local time
	val exifOffsetTimeOriginal = "+02:00"

	// parde date-time
	val exifDateTimeFmt = DateTimeFormatter.ofPattern("yyyy:MM:dd HH:mm:ss")
	val takenAt = LocalDateTime.parse(exifDateTimeOriginal, exifDateTimeFmt)
	println(takenAt)

	// create UTC timestamp
	val utcTimestamp = takenAt.toEpochSecond(ZoneOffset.of(exifOffsetTimeOriginal)) * 1000
	println(utcTimestamp)

	println("done!")
}
