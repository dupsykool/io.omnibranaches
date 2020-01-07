package mtn.insurance.simulations

import io.gatling.core.Predef._

import scala.concurrent.duration._
import mtn.insurance.config.Config
import mtn.insurance.config.Config.users
import mtn.insurance.scenarios
import mtn.insurance.scenarios.AgentScenarios

class AgentTransactionSimulation extends Simulation {


  setUp(
      AgentScenarios.AgentTrxn.inject(rampUsers(10) during (10 seconds))
  )
}
