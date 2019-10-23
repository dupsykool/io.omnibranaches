package mtn.insurance.simulations

import io.gatling.core.Predef.Simulation
import mtn.insurance.scenarios.GetTokenScenario
import io.gatling.core.Predef._
import mtn.insurance.config.Config._
/**
  * Created by modup on 8/18/2019.
  */
class GetTokenSimulation extends Simulation{

  private val getTokenExec = GetTokenScenario.getTokenScenario.inject(atOnceUsers(users))

  setUp(getTokenExec)

}
