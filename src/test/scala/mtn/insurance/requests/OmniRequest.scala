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

  val trxnrefFeeder = Iterator.continually(Map("trxn_id" -> (Random.nextInt(1000))))

  val userIdFeeder = Iterator.continually(Map("userId" -> "steepe@live.com"))

  val amountFeeder = Iterator.continually(Map("amount" -> 50))

  val refFeeder = Iterator.continually(Map("ref" -> 1234567899))

  val emailFeeder = Array(
    Map("foo" -> "anuonasile@gmail.com"),
    Map("foo" -> "talk2smooth@yahoo.com"),
    Map("foo" -> "onasilejoel@gmail.com")
  )

  val access_token_val = "${foo}_accessToken"

  val wallet_req = feed(userIdFeeder)
        .feed(amountFeeder)
      .feed(refFeeder)
      .exec(http("fund_wallet")
    .post(omni_url + "/v1/wallet/fund")
//          .header(if("${foo}" == "") "" else "")

         .header("Authorization","Bearer ${foo}_accessToken")
    .body(ElFileBody{"data/wallet.json"}).asJson)

  val bankTransfer = feed(amountFeeder)
    .feed(trxnrefFeeder)
      .feed(emailFeeder)
    .exec(http("bank_transfer")
      .post(omni_url + "/billpayment/bank-transfer-pay")
        .check(status.is(200))
      .header("Authorization", "Bearer ${foo}_accessToken")
      .body(ElFileBody{"data/bank_trxn.json"}).asJson)

  val cashOut = feed(amountFeeder)
    .feed(trxnrefFeeder)
    .feed(emailFeeder)
    .exec(http("bank_transfer")
      .post(omni_url + "/services/cashout")
      .check(status.is(200))
      .header("Authorization", "${foo}_accessToken")
      .body(ElFileBody{"data/cashout_req.json"}).asJson)


//  val createCustomer = feed(feeder)
//          .feed(firstNameFeeder)
//      .feed(lastNameFeeder)
//    .exec(http("create-customer")
//    .post(app_url + "/employees")
//      .check(status is 200)
//    .body(ElFileBody("data/onboarding.json")).asJSON)
}

