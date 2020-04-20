import io.udash._

sealed abstract class RoutingState(val parentState: Option[ReproRoutingState]) extends State {
	override type HierarchyRoot = ReproRoutingState
}

sealed abstract class ReproRoutingState extends RoutingState(None) with ContainerState

sealed abstract class FinalRoutingState extends ReproRoutingState with FinalState

object LoginRoutingState extends ReproRoutingState
case class ConnectedRoutingState(username: String) extends ReproRoutingState
