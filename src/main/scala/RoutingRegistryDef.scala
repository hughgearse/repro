import io.udash._

class RoutingRegistryDef extends RoutingRegistry[ReproRoutingState] {

	private var currentState: ReproRoutingState = LoginRoutingState

	def matchUrl(url: Url): ReproRoutingState = currentState

	def matchState(state: ReproRoutingState): Url = {
		currentState = state
		Url(state match {
			case LoginRoutingState => "login"
			case ConnectedRoutingState(_) => "connected"
		})
	}

}