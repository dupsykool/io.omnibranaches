package mtn.insurance.requests

import java.util.concurrent.ThreadLocalRandom

import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._
import mtn.insurance.config.Config.omni_url

import scala.util.Random

//import scala.util.Random



object BillPaymentRequest {

//  val random: ThreadLocalRandom = ThreadLocalRandom.current()
  val r = Random.nextInt(100) // returns value between 20 and 30 inclusively


  val trxnRefFeeder: Iterator[Map[String, Int]] = Iterator.continually(Map("trxn_id" -> (Random.nextInt(1000))))

  val amountFeeder: Iterator[Map[String, Int]] = Iterator.continually(Map("amount" -> Random.nextInt(100)))

//  val amountFeeder_superAgent: Iterator[Map[String, Long]] = Iterator.continually(Map("amount_s" -> r))

  val agentBankTransfer: ChainBuilder = feed(amountFeeder)
    .feed(trxnRefFeeder)
    .exec(session => {
      val foo = session("foo").as[String]
      println("Processing bank transfer by: "+foo)
      session
    })
    .exec(http("agent_bank_transfer")
      .post(omni_url + "/billpayment/bank-transfer-pay")
      .check(status.is(200))
      .header("Authorization",  "${access_token}")
      .body(ElFileBody{"data/bank_trxn.json"}).asJson)

  val agentBankTransfer_1: ChainBuilder = feed(amountFeeder)
    .feed(trxnRefFeeder)
    .exec(session => {
      val foo = session("foo").as[String]
      println("Processing bank transfer by: "+foo)
      session
    })
    .exec(http("agent_bank_transfer")
      .post(omni_url + "/billpayment/bank-transfer-pay")
      .check(status.is(200))
      .header("Authorization",  "${access_token_1}")
      .body(ElFileBody{"data/bank_trxn.json"}).asJson)

  val superAgentBankTransfer: ChainBuilder = feed(amountFeeder)
    .feed(trxnRefFeeder)
    .exec(session => {
      val foo = session("foo").as[String]
      println("Processing bank transfer by: "+foo)
      session
    })
    .exec(http("super_bank_transfer")
      .post(omni_url + "/billpayment/bank-transfer-pay")
      .check(status.is(200))
      .header("Authorization",  "${super_agent_get_token}")
      .body(ElFileBody{"data/bank_trxn.json"}).asJson)
}


