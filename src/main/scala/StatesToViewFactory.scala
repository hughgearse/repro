import io.udash.{ViewFactory, ViewFactoryRegistry}

class StatesToViewFactoryDef extends ViewFactoryRegistry[ContainerRoutingState] {
	def matchStateToResolver(state: ContainerRoutingState): ViewFactory[_ <: ContainerRoutingState] =
		state match {
			case _: RoutingState => LookupViewFactory
		}
}