package scala.mtn.insurance.requests

import io.gatling.core.Predef._
import io.gatling.core.session.SessionAttribute
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

  var email_token: String = ""

  val feeder = Iterator.continually(Map("emailId" -> (Random.alphanumeric.take(20).mkString + "@foo.com")))

  val trxnrefFeeder = Iterator.continually(Map("trxn_id" -> (Random.nextInt(1000))))

  val userIdFeeder = Iterator.continually(Map("userId" -> "steepe@live.com"))

  val amountFeeder = Iterator.continually(Map("amount" -> 50))

  val refFeeder = Iterator.continually(Map("ref" -> 1234567899))


  val wallet_req = feed(userIdFeeder)
    .feed(amountFeeder)
    .feed(refFeeder)
    .exec(http("fund_wallet")
        .post(omni_url + "/v1/wallet/fund")
        .header("Authorization",session => session("anuonasile@gmail.com_access_token").as[String])
    .body(ElFileBody{"data/wallet.json"}).asJson)

  val bankTransfer = feed(amountFeeder)
    .feed(trxnrefFeeder)
    .exec(http("bank_transfer")
      .post(omni_url + "/billpayment/bank-transfer-pay")
        .check(status.is(200))
      .check(bodyBytes.exists)
    .header("Authorization",  session => session(email_token).as[String])
      .body(ElFileBody{"data/bank_trxn.json"}).asJson)


  val cashOut = feed(amountFeeder)
    .feed(trxnrefFeeder)
    .exec(http("bank_transfer")
      .post(omni_url + "/services/cashout")
      .check(status.is(200))
      .header("Authorization", session => session(email_token).as[String])
      .body(ElFileBody{"data/cashout_req.json"}).asJson)

}

