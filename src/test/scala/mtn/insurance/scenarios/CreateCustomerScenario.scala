package mtn.insurance.scenarios

import io.gatling.core.Predef.scenario
import mtn.insurance.requests.{CreateCustomerReques, GetTokenRequest}

import scala.mtn.insurance.requests.OmniRequest

/**
  * Created by modup on 8/20/2019.
  */
object CreateCustomerScenario {

      val processRequest = scenario("createCustScenario")
        .exec(GetTokenRequest.get_token)
        .randomSwitch(
        30d -> exec(OmniRequest.wallet_req),

        )
        //.pause("5")
}
