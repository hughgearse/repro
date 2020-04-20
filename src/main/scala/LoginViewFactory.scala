import io.udash._
import scalatags.JsDom.all._
import org.querki.jquery._

case object LoginViewFactory extends ViewFactory[ReproRoutingState] {

	def create(): (View, Presenter[ReproRoutingState]) = {
		val presenter = new LoginPresenter()
		val view = new LoginView(presenter)
		(view, presenter)
	}
}

class LoginPresenter extends Presenter[ReproRoutingState] {

	def handleState(state: ReproRoutingState): Unit = {}

	def connect(username: String) = AppContext.applicationInstance.goTo(ConnectedRoutingState(username))
}

class LoginView(presenter: LoginPresenter) extends ContainerView {

	def getTemplate: Modifier =
		div(
			div(
				div(label("Username")),
				div(input(id := "user-name")),
				div(button(`type` := "button", cls := "btn btn-primary", "Connect"), onclick := { () =>
					presenter.connect($("#user-name").`val`().toString)
				})
			)
		)
}
