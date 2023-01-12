//// Pipeline pattern sample (not working).
//import kotlinx.coroutines.*
//import kotlinx.coroutines.channels.ReceiveChannel
//import kotlinx.coroutines.channels.produce
//import java.util.concurrent.TimeUnit
//
//// pages producer
//private fun producePages() = GlobalScope.produce {
//	fun getPages(): List<String> {
//		return listOf(
//			"<html><body><H1>Cool stuff</H1></body></html>",
//			"<html><body><H1>Even more stuff</H1></body></html>").shuffled()
//	}
//
//	while (isActive) {
//		val pages = getPages()
//		for (p in pages)
//			send(p)
//		delay(TimeUnit.SECONDS.toMillis(5))
//	}
//}
//
//fun produceDom(pages: ReceiveChannel<String>) = GlobalScope.produce {
//	fun parseDom(page: String): Document {
//		return kotlinx.dom.parseXml(page.toString())
//	}
//
//	for (p in pages) {
//		send(parseDom(p))
//	}
//}
//
//fun produceTiles(parsedPages: ReceiveChannel<Document>) = produce {
//	fun getTitles(dom: Document): List<String> {
//		val h1 = dom.getElementyByTagName("H1")
//		return h1.asElementList().map {it.testContent}
//		for (page in parsedPages) {
//			for (t in getTitles(page)) {
//				send(t)
//			}
//		}
//	}
//}
//
//fun main() {
//	val pagesProducer = producePages()
//	val domProducer = produceDom(pagesProducer)
//	val titleProducer = produceTitles(domProducer)
//
//	runBlocking {
//		titleProducer.comsumeEach {
//			println(it)
//		}
//	}
//}