package mtn.insurance.simulations

import io.gatling.core.Predef._

import scala.concurrent.duration._
import mtn.insurance.config.Config
import mtn.insurance.config.Config.users
import mtn.insurance.scenarios
import mtn.insurance.scenarios.AgentScenarios

class AgentTransactionSimulation extends Simulation {

//  val scn = List(AgentScenarios.Agent_login.inject(atOnceUsers(1)),
//    AgentScenarios.SuperAgentTrxn.inject(nothingFor(20 seconds),atOnceUsers(1)))
//
//  setUp(scn)

  setUp(
//    AgentScenarios.Agent_login.inject(atOnceUsers(1)),
//    AgentScenarios.SuperAgentTrxn.inject(atOnceUsers(1))
    AgentScenarios.SuperAgentTrxn.inject(constantUsersPerSec(2).during(2 seconds)),
      AgentScenarios.AgentTrxn.inject(constantUsersPerSec(3).during(2 seconds)),
  AgentScenarios.AgentTrxn_1.inject(constantUsersPerSec(4).during(2 seconds))
//    AgentScenarios.AgentTrxn.inject(constantUsersPerSec(10).during(2 seconds)),
//    AgentScenarios.AgentTrxn_1.inject(constantUsersPerSec(10).during(2 seconds))

//    AgentScenarios.SuperAgentTrxn.inject(constantUsersPerSec(100).during(60 seconds))
  )


}
