import io.udash._
import io.udash.properties.model.ModelProperty
import org.scalajs.dom.Event
import org.scalajs.dom.raw.HTMLInputElement
import scalatags.JsDom.all._

case class LookupModel(id: Option[String] = None, count: Int = 0) {
	println("LookupModel created")
}

object LookupModel extends HasModelPropertyCreator[LookupModel]

class LookupPresenter(val model: ModelProperty[LookupModel])
	extends Presenter[ContainerRoutingState] {

	def handleState(state: ContainerRoutingState) = state match {
		case LookupState(id, _) =>
			println("Setting the id: " + id)
			model.subProp(_.id).set(Some(id))
		case _ =>
			println("Clearing the id")
			model.subProp(_.id).set(None)
	}
}

class LookupView(model: ModelProperty[LookupModel], presenter: LookupPresenter) extends ContainerView {

	val idProp = model.subProp(_.id).transform(_.getOrElse("No current id"))

	def getTemplate: Modifier = div(
		span("Current: ", bind(idProp)), br,
		span("Count: ", bind(model.subProp(_.count))), br,
		input(oninput := {(event: Event) =>
			val value = event.target.asInstanceOf[HTMLInputElement].value
			println("Changed: " + value)
			AppContext.applicationInstance.goTo(LookupState(value,
				Option(AppContext.applicationInstance.currentState)))
		})
	)
}

case object LookupViewFactory extends ViewFactory[LookupState] {

	def create(): (View, Presenter[LookupState]) = {
		println("ViewFactory create")
		val model = ModelProperty(new LookupModel())
		val presenter = new LookupPresenter(model)
		val view = new LookupView(model, presenter)
		(view, presenter)
	}
}