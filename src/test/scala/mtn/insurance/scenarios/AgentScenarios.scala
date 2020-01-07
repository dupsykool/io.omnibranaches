package mtn.insurance.scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import mtn.insurance.requests.{AgentServices, BillPaymentRequest, GetTokenRequest}

import scala.concurrent.duration.Duration

object AgentScenarios {

  val duration = Duration(100,"millis")
  val p_duration = Duration(500,"millis")
  val pause_sec = Duration(1,"seconds")

  val SuperAgentTrxn: ScenarioBuilder = scenario("SuperAgentTrxn Transaction Simulation")

    .exec(GetTokenRequest.super_agent_get_token).pause(pause_sec)
  .exec(AgentServices.performWalletTransfer)
    .exec(BillPaymentRequest.superAgentBankTransfer)


  val AgentTrxn: ScenarioBuilder = scenario("AgentTrxn Transaction Simulation")
    .exec(GetTokenRequest.get_token).pause(pause_sec)
    .exec(BillPaymentRequest.agentBankTransfer)
    .exec(AgentServices.performCashOut)

  val AgentTrxn_1: ScenarioBuilder = scenario("AgentTrxn_1 Transaction Simulation")
    .exec(GetTokenRequest.get_token_1).pause(pause_sec)
    .exec(BillPaymentRequest.agentBankTransfer_1)
    .exec(AgentServices.performCashOut_1)

  val Agent_login: ScenarioBuilder = scenario("login")
  .exec(GetTokenRequest.super_agent_get_token)
    .exec(GetTokenRequest.get_token)
    .exec(GetTokenRequest.get_token_1)
}
