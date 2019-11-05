package mtn.insurance.requests

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import mtn.insurance.config.Config.omni_url

/**
  * Created by modup on 8/18/2019.
  */
object GetTokenRequest {

//    val get_token = http("getToken").post(app_url + "/login?username=demoadmin%40omnibranches.com&password=swifta%40developers")
//      .check(status is 200)
//      .check(jsonPath("$.accessToken").saveAs("accessToken"))

    val get_token = http("getToken")
      .post(omni_url + "/token")
        .header("Authorization","Basic UUQ1cUtKQllVd2JXZkhCVzNWRWZma3lXS0NBYTp6SlNCNmZ1dVIxRk9nQlBLUndsbDFfSTA2N1Vh")
        .formParam("grant_type","password")
        .formParam("username","wayauser")
        .formParam("password","wayauser@12345")
      .check(status is 200)
      .check(jsonPath("$.access_token").saveAs("access_token"))
}
