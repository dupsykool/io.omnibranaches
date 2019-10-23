package mtn.insurance

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._
//import io.gatling.core.scenario.Simulation


/**
  * Created by modup on 8/17/2019.
  */

//class OmnibranchesLoadTest extends Simulation{
//  object Login{
//
//    val login= exec(http(login)
//      .get("/login?username=demoadmin%40omnibranches.com&password=swifta%40developers"))
//      .check(jsonPath("$.accessToken").saveAs("accessToken"))
//
//
//    val httpProtocol = http
//      .baseUrl("http://computer-database.gatling.io")
//      .header(ContentType, ApplicationJson)
//      .header(Accept, ApplicationJson)
//
//    val scn = scenario("Login scenerio").exec(Login.login).exec { session => println(session); session }
//
//    setUp(scn.inject(atOnceUsers(1)).protocols(httpProtocol))
//
//  }
//}

