package mtn.insurance.scenarios

import io.gatling.core.Predef.scenario
import mtn.insurance.requests.{CreateCustomerReques, GetTokenRequest}

import scala.mtn.insurance.requests.OmniRequest

/**
  * Created by modup on 8/20/2019.
  */
object CreateCustomerScenario {

      val createCustomer = scenario("createCustScenario")
          .exec(GetTokenRequest.get_token)
        .exec(OmniRequest.wallet_req)
        //.pause("5")

}
