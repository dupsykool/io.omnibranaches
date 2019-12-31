package mtn.insurance.simulations

import io.gatling.core.Predef._
import scala.concurrent.duration._
import mtn.insurance.config.Config
import mtn.insurance.config.Config.users
import mtn.insurance.scenarios.AgentScenarios

class AgentTransactionSimulation extends Simulation {

  setUp(
//    AgentScenarios.Agent_login.inject(atOnceUsers(1)),
//    AgentScenarios.SuperAgentTrxn.inject(atOnceUsers(users))
    AgentScenarios.SuperAgentTrxn.inject(constantUsersPerSec(100).during(60 seconds))
  )


}
