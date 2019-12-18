package mtn.insurance.requests

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import mtn.insurance.config.Config.omni_url

/**
  * Created by modup on 8/18/2019.
  */
object GetTokenRequest {

//  val session: Session = ???

//    val get_token = http("getToken")
//      .post(omni_url + "/token")
//        .header("Authorization","Basic UUQ1cUtKQllVd2JXZkhCVzNWRWZma3lXS0NBYTp6SlNCNmZ1dVIxRk9nQlBLUndsbDFfSTA2N1Vh")
//        .formParam("grant_type","password")
//        .formParam("username","wayauser")
//        .formParam("password","wayauser@12345")
//      .check(status is 200)
//      .check(jsonPath("$.access_token").saveAs("access_token"))

    val feeder = Array(
        Map("foo" -> "anuonasile@gmail.com",  "bar" -> "pass"),
        Map("foo" -> "talk2smooth@yahoo.com", "bar" -> "pass"),
        Map("foo" -> "onasilejoel@gmail.com", "bar" -> "pass")
    ).random

    val get_token = feed(feeder)
      .exec(
          http("getToken")
//            .post(omni_url + "/login?username=${foo}&password=${bar}")
            .post(omni_url + "/login")
            .queryParam("username","${foo}")
            .queryParam("password","${bar}")
            .check(status is 200)
            .check(
                checkIf("${foo}" == jsonPath("$.user.email")) {
                  jsonPath("$.accessToken").saveAs("${foo}_accessToken")
                }
            )
      )
}
