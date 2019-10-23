package mtn.insurance.requests

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import mtn.insurance.config.Config.app_url

/**
  * Created by modup on 8/18/2019.
  */
object GetTokenRequest {

    val get_token = http("getToken").post(app_url + "/login?username=demoadmin%40omnibranches.com&password=swifta%40developers")
      .check(status is 200)
      .check(jsonPath("$.accessToken").saveAs("accessToken"))
}
