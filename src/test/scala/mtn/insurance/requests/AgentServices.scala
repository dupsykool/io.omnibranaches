package mtn.insurance.requests


import io.gatling.core.Predef._
import io.gatling.http.Predef._
import mtn.insurance.config.Config.omni_url

import scala.util.Random

object AgentServices {

  var super_agent_get_token_2 = ""

  val randomGenerator = new Random

  val start = 50

  val end = 100

  val userIdFeeder = Iterator.continually(Map("userId" -> "steepe@live.com"))

//  val amountFeeder: Iterator[Map[String, Int]] = Iterator.continually(Map("amount" -> (start + randomGenerator.nextInt((end - start) + 1 ))))

  val amountFeeder: Iterator[Map[String, Int]] = Iterator.continually(Map("amount" -> 200))

//  val refFeeder = Iterator.continually(Map("ref" -> 1234567899))

  val trxnRefFeeder = Iterator.continually(Map("trxn_id" -> (Random.nextInt(1000))))

  val trxnRefFeeder2 = Iterator.continually(Map("trxn_id2" -> (Random.nextInt(10000))))

  val AnuDownlinesFeeder = Array(
    Map("userId" -> "talk2smooth@yahoo.com"),
    Map("userId" -> "onasilejoel@gmail.com")
  ).random

  val terminalIdFeeder = Array(
    Map("terminalid" -> "2075KA23"),
    Map("terminalid" -> "2076TY10"),
    Map("terminalid" -> "2101AY35"),
    Map("terminalid" -> "2058KA30")
  ).random

  val performWalletTransfer = feed(AnuDownlinesFeeder)
    .feed(amountFeeder)
    .feed(trxnRefFeeder)
    .feed(trxnRefFeeder2)
//    .exec(session => {
//      super_agent_get_token_2 = session("super_agent_get_token_1").as[String]
//      println("Processing wallet transfer by: "+ session("super_agent_get_token_2").as[String])
//      session
//    })
    .exec(http("fund_wallet")
      .post(omni_url + "/wallet/fund")
      .header("Authorization", "${super_agent_get_token}")
      .body(ElFileBody{"data/wallet.json"}).asJson)

  val performCashOut = feed(amountFeeder)
    .feed(trxnRefFeeder)
    .feed(trxnRefFeeder2)
    .feed(terminalIdFeeder)
    .exec(session => {
      println("Processing wallet transfer by: "+ session("access_token").as[String])
      session
    })
//    .exec(session => {
////      var email_token = session("foo").as[String] + "_access_token"
//      println("Processing cashout by: ${foo}")
//      session
//    })
    .exec(http("cash_out")
      .post(omni_url + "/services/cashout")
      .check(status.is(200))
      .header("Authorization", "${access_token}")
        .header("terminalid","${terminalid}")
      .body(ElFileBody{"data/cashout_req.json"}).asJson)

  val performCashOut_1 = feed(amountFeeder)
    .feed(trxnRefFeeder)
    .feed(terminalIdFeeder)
    .feed(trxnRefFeeder2)
//    .exec(session => {
//      //      var email_token = session("foo").as[String] + "_access_token"
//      println("Processing cashout by: ${foo}")
//      session
//    })
    .exec(http("cash_out")
      .post(omni_url + "/services/cashout")
      .check(status.is(200))
      .header("Authorization", "${access_token_1}")
      .header("terminalid","${terminalid}")
      .body(ElFileBody{"data/cashout_req.json"}).asJson)


}
