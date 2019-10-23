package mtn.insurance.simulations

import io.gatling.core.Predef.atOnceUsers
import io.gatling.core.scenario.Simulation
import mtn.insurance.config.Config.users
import mtn.insurance.scenarios.CreateCustomerScenario

/**
  * Created by modup on 8/20/2019.
  */
class CreateCustomerSimulation extends Simulation{

  private val createCustomer = CreateCustomerScenario.createCustomer.inject(atOnceUsers(users))

  setUp(createCustomer)

}
