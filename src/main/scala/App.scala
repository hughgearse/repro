import org.scalajs.jquery.JQueryStatic

import scala.scalajs.js
import org.scalajs.dom
import scalatags.JsDom.all._

import scala.scalajs.js.annotation.JSImport

@JSImport("jquery", JSImport.Namespace)
@js.native
object JQuery extends JQueryStatic

@js.native
trait JQueryUI extends JQueryStatic {
	def spinner(options: js.Object = js.Dynamic.literal()): JQueryUI = js.native
}

@JSImport("jquery-ui", JSImport.Namespace)
@js.native
object JQueryUI extends JQueryUI

object App {

		def main(args: Array[String]): Unit = {
			dom.document.getElementById("root").appendChild(div(input(id := "input")).render)
			JQuery("#input").asInstanceOf[JQueryUI].spinner()
		}
}
