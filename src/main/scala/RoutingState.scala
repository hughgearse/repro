import io.udash._

sealed abstract class RoutingState(
																		val parentState: Option[ContainerRoutingState]
																	) extends State {
	override type HierarchyRoot = ContainerRoutingState
}
sealed abstract class ContainerRoutingState(
																						 parentState: Option[ContainerRoutingState]
																					 ) extends RoutingState(parentState) with ContainerState
sealed abstract class FinalRoutingState(
																				 parentState: Option[ContainerRoutingState]
																			 ) extends ContainerRoutingState(parentState) with FinalState
case object RootState extends ContainerRoutingState(None)
case class LookupState(id: String, prevState: Option[ContainerRoutingState]) extends FinalRoutingState(prevState)
case object ErrorState extends ContainerRoutingState(None)
