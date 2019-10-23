package mtn.insurance.scenarios

import mtn.insurance.requests.GetTokenRequest
import io.gatling.core.Predef.scenario

/**
  * Created by modup on 8/18/2019.
  */
object GetTokenScenario {

  val getTokenScenario = scenario("Get Token Scenario")
    .exec(GetTokenRequest.get_token)
}
