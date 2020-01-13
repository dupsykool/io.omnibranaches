package mtn.insurance.simulations

import io.gatling.core.Predef._
import mtn.insurance.scenarios.AgentScenarios

import scala.concurrent.duration._

class AgentHierarchyTransactionSimulation extends Simulation {


  setUp(
    AgentScenarios.SuperAgentTrxn.inject(rampUsers(2).during(2 seconds)),
      AgentScenarios.AgentTrxn.inject(rampUsers(3).during(2 seconds)),
  AgentScenarios.AgentTrxn_1.inject(rampUsers(4).during(2 seconds))
  )


}
