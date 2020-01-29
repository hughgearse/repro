import io.udash._
import io.udash.properties.model.ModelProperty
import scalatags.JsDom.all._

case class LookupModel(id: Option[String] = None) {
	println("LookupModel created")
}

object LookupModel extends HasModelPropertyCreator[LookupModel]

class LookupPresenter(val model: ModelProperty[LookupModel])
	extends Presenter[RoutingState] {

	def handleState(state: RoutingState) = state match {
		case LookupState(id) =>
			println("Setting the id: " + id)
			model.subProp(_.id).set(Some(id))
		case _ =>
			println("Clearing the id")
			model.subProp(_.id).set(None)
	}
}

class LookupView(model: ModelProperty[LookupModel], presenter: LookupPresenter) extends ContainerView {

	val idProp = model.subProp(_.id).transform(_.getOrElse("No current id"))

	def getTemplate: Modifier = div("Id: ", bind(idProp))
}

case object LookupViewFactory extends ViewFactory[LookupState] {

	def create(): (View, Presenter[LookupState]) = {
		val model = ModelProperty(new LookupModel())
		val presenter = new LookupPresenter(model)
		val view = new LookupView(model, presenter)
		(view, presenter)
	}
}