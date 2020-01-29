import io.udash.{ViewFactory, ViewFactoryRegistry}

class StatesToViewFactoryDef extends ViewFactoryRegistry[RoutingState] {
	def matchStateToResolver(state: RoutingState): ViewFactory[_ <: RoutingState] =
		state match {
			case _: RoutingState => LookupViewFactory
		}
}