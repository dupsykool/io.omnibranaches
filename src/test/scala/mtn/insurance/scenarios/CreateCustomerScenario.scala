package mtn.insurance.scenarios

import io.gatling.core.Predef.scenario
import mtn.insurance.requests.CreateCustomerReques

/**
  * Created by modup on 8/20/2019.
  */
object CreateCustomerScenario {

      val createCustomer = scenario("createCustScenario")
        .exec(CreateCustomerReques.createCustomer)

}
