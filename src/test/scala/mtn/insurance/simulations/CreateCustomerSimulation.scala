package mtn.insurance.simulations


import io.gatling.core.scenario.Simulation
import mtn.insurance.config.Config.users
import mtn.insurance.scenarios.CreateCustomerScenario
import io.gatling.core.Predef._
import mtn.insurance.config.Config
/**
  * Created by modup on 8/20/2019.
  */
class CreateCustomerSimulation extends Simulation{

  private val createCustomer = CreateCustomerScenario
    .createCustomer
    .inject(atOnceUsers(users))
//    .inject(rampUsers(users) over(Config.duration))

  setUp(createCustomer)

}
