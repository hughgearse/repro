import io.udash.{ViewFactory, ViewFactoryRegistry}

class StatesToViewFactoryDef extends ViewFactoryRegistry[ReproRoutingState] {
	def matchStateToResolver(state: ReproRoutingState): ViewFactory[_ <: ReproRoutingState] =
		state match {
			case LoginRoutingState => LoginViewFactory
			case ConnectedRoutingState(username) => ConnectedViewFactory(username)
		}
}