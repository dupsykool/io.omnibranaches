package mtn.insurance.scenarios

import io.gatling.core.Predef._
//import mtn.insurance.requests.GetTokenRequest.email_token
import mtn.insurance.requests.{CreateCustomerReques, GetTokenRequest}

import scala.mtn.insurance.requests.OmniRequest
//import scala.mtn.insurance.requests.OmniRequest.email_conc

/**
  * Created by modup on 8/20/2019.
  */
object CreateCustomerScenario {

      val processRequest = scenario("createCustScenario")
        .exec(GetTokenRequest.get_token)
        .exec { session =>
          val email_token = session("foo").as[String] + "_access_token"
          println("Session Value for "+ email_token+" is:" + session(email_token).as[String])
          session
        }
//        .exec(OmniRequest.bankTransfer)
        .randomSwitch(
        60.0 -> exec(OmniRequest.wallet_req),
          40.0 -> exec(OmniRequest.bankTransfer)
//          30.0 -> exec(OmniRequest.cashOut)
        )
        //.pause("5")
}
