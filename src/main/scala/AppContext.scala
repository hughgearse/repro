import io.udash._

object AppContext {

	private val routingRegistry = new RoutingRegistryDef
	private val viewFactoryRegistry = new StatesToViewFactoryDef

	val applicationInstance = new Application[ReproRoutingState](
		routingRegistry, viewFactoryRegistry
	)
	//	val applicationInstance = new Application[ExchangeRoutingState](
	//		routingRegistry, viewFactoryRegistry
	//	)
}
