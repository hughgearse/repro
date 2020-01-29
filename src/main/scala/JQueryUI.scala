import org.querki.jquery.JQuery

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@js.native
trait JQueryUI extends JQuery {
	def spinner(options: js.Object = js.Dynamic.literal()): JQueryUI = js.native
	def spinner(command: String): JQueryUI = js.native
}

@JSImport("jquery-ui-bundle", JSImport.Namespace)
@js.native
object JQueryUIImport extends JQueryUI

object JQueryUI {

	// Need to explicitly instantiate our JQuery objects to ensure they are imported
	JQueryUIImport

	implicit def jQueryUIExtensions(query: JQuery): JQueryUI = query.asInstanceOf[JQueryUI]
}

