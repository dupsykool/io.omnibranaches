package scala.mtn.insurance.requests

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import mtn.insurance.config.Config.omni_url

import scala.util.Random

/**
  * Created by modup on 8/20/2019.
  */
object OmniRequest {

  object randomStringGenerator {

    def randomString(length: Int) = scala.util.Random.alphanumeric.filter(_.isLetter).take(length).mkString
  }

  val feeder = Iterator.continually(Map("emailId" -> (Random.alphanumeric.take(20).mkString + "@foo.com")))

  val userIdFeeder = Iterator.continually(Map("userId" -> "steepe@live.com"))

  val amountFeeder = Iterator.continually(Map("amount" -> 150))



  val wallet_req = feed(userIdFeeder)
        .feed(amountFeeder)
      .exec(http("fund_wallet")
    .post(omni_url + "/v1/wallet/fund")
        .header("Authorization","Bearer "+"${access_token}")
    .body(ElFileBody{"data/wallet.json"}).asJSON)

//  val createCustomer = feed(feeder)
//          .feed(firstNameFeeder)
//      .feed(lastNameFeeder)
//    .exec(http("create-customer")
//    .post(app_url + "/employees")
//      .check(status is 200)
//    .body(ElFileBody("data/onboarding.json")).asJSON)
}

