import io.udash._

class RoutingRegistryDef extends RoutingRegistry[ContainerRoutingState] {

	def matchUrl(url: Url) = url.value.stripSuffix("/") match {
		case "lookup" / id => LookupState(id, Option(AppContext.applicationInstance.currentState))
	}

	def matchState(state: ContainerRoutingState): Url = Url(state match {
		case LookupState(id, _) => "lookup" / id
		case _ => ""
	})

//	private val (url2State, state2Url) = bidirectional {
//		case "lookup" / id  => LookupState(id, None)
//		case "" => RootState
//	}
}