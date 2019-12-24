package mtn.insurance.simulations


//import io.gatling.core.scenario.Simulation
//import io.gatling.core.Predef._
import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._
import mtn.insurance.config.Config.users
import mtn.insurance.scenarios.{CreateCustomerScenario, GetTokenScenario}
import mtn.insurance.config.Config
/**
  * Created by modup on 8/20/2019.
  */
class CreateCustomerSimulation extends Simulation{

  private val createCustomer = CreateCustomerScenario
    .processRequest
//    .inject(atOnceUsers(users))
    .inject(rampUsers(users) during(Config.duration seconds))

  private val getToken = GetTokenScenario.getTokenScenario
      .inject(atOnceUsers(users))

  val scn = List(createCustomer,getToken)

  setUp(createCustomer)

}
