package mtn.insurance.simulations

import io.gatling.core.Predef._

import scala.concurrent.duration._
import mtn.insurance.config.Config
import mtn.insurance.config.Config.users
import mtn.insurance.scenarios
import mtn.insurance.scenarios.AgentScenarios

class AgentTransactionSimulation extends Simulation {

  setUp(
//    AgentScenarios.Agent_login.inject(atOnceUsers(1)),
    AgentScenarios.SuperAgentTrxn.inject(constantUsersPerSec(5).during(2 seconds))
//    AgentScenarios.AgentTrxn.inject(constantUsersPerSec(10).during(2 seconds)),
//    AgentScenarios.AgentTrxn_1.inject(constantUsersPerSec(10).during(2 seconds))

//    AgentScenarios.SuperAgentTrxn.inject(constantUsersPerSec(100).during(60 seconds))
  )


}
