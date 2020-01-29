import io.udash._
import org.scalajs.dom
import scalatags.JsDom.all._
import org.querki.jquery._
import JQueryUI._

import scala.util.Random

object Main {

	def main(args: Array[String]): Unit = {
		val root = dom.document.getElementById("root")
		AppContext.applicationInstance.run(root)
	}
}
