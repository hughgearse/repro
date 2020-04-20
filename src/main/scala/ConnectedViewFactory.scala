import io.udash._
import scalatags.JsDom.all._

case class ConnectedViewFactory(username: String) extends ViewFactory[ConnectedRoutingState] {

	def create(): (View, Presenter[ConnectedRoutingState]) = {
		val presenter = new ConnectedPresenter()
		val view = new ConnectedView(Property(username), presenter)
		(view, presenter)
	}
}

class ConnectedPresenter extends Presenter[ConnectedRoutingState] {

	def handleState(state: ConnectedRoutingState): Unit = {}
}

class ConnectedView(username: Property[String], presenter: ConnectedPresenter) extends ContainerView {

	def getTemplate: Modifier = div("Connected as: " + bind(username))
}
