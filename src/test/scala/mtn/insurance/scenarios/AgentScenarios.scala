package mtn.insurance.scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import mtn.insurance.requests.{AgentServices, BillPaymentRequest, GetTokenRequest}

import scala.concurrent.duration.Duration

object AgentScenarios {

  val duration = Duration(100,"millis")

  val SuperAgentTrxn: ScenarioBuilder = scenario("Agent Transaction Simulation")
    .exec(GetTokenRequest.super_agent_get_token)
    .exec(GetTokenRequest.get_token)
    .during(duration) {
      exec(AgentServices.performWalletTransfer)
      .exec(BillPaymentRequest.agentBankTransfer)
      .exec(BillPaymentRequest.superAgentBankTransfer)
      .exec(AgentServices.performCashOut)
      .exec(AgentServices.performWalletTransfer)
    }
//      randomSwitch(
//        10.0 -> exec(AgentServices.performWalletTransfer).pause(1),
//        30.0 -> exec(BillPaymentRequest.agentBankTransfer).pause(2),
//        10.0 -> exec(BillPaymentRequest.superAgentBankTransfer).pause(5),
//        10.0 -> exec(AgentServices.performWalletTransfer).pause(2),
//        40.0 -> exec(AgentServices.performCashOut)
//      )
//    }

  val Agent_login: ScenarioBuilder = scenario("performing bank transfer")
    .exec(GetTokenRequest.super_agent_get_token)
    .exec(GetTokenRequest.get_token)
}
