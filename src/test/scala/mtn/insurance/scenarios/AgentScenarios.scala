package mtn.insurance.scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import mtn.insurance.requests.{AgentServices, BillPaymentRequest, GetTokenRequest}

import scala.concurrent.duration.Duration

object AgentScenarios {

  val duration = Duration(100,"millis")

  val SuperAgentTrxn: ScenarioBuilder = scenario("SuperAgentTrxn Transaction Simulation")
    .doIf(session => !session.contains("super_agent_get_token")){
      exec(GetTokenRequest.super_agent_get_token)
        .exec(GetTokenRequest.get_token)
        .exec(GetTokenRequest.get_token_1)
    }
  .exec(AgentServices.performWalletTransfer)
            .exec(AgentServices.performCashOut_1)
    .exec(BillPaymentRequest.agentBankTransfer)
            .exec(BillPaymentRequest.superAgentBankTransfer)
    .exec(BillPaymentRequest.agentBankTransfer_1)
            .exec(AgentServices.performCashOut)
            .exec(AgentServices.performWalletTransfer)
//    .exec(GetTokenRequest.get_token)
//    .exec(GetTokenRequest.get_token_1)
//    .repeat(20) {
//      during(duration) {
//        randomSwitch(
//                20.0 -> exec(AgentServices.performWalletTransfer),
//          10.0 -> exec(AgentServices.performCashOut_1),
//          10.0 -> exec(BillPaymentRequest.agentBankTransfer),
//          10.0 -> exec(BillPaymentRequest.superAgentBankTransfer),
//          20.0 -> exec(BillPaymentRequest.agentBankTransfer_1),
//          10.0 -> exec(AgentServices.performWalletTransfer),
//          20.0 -> exec(AgentServices.performCashOut)
//              )
//      }
//    }

  val AgentTrxn: ScenarioBuilder = scenario("AgentTrxn Transaction Simulation")
    .exec(GetTokenRequest.get_token)
    .exec(BillPaymentRequest.agentBankTransfer)
    .exec(AgentServices.performCashOut)
//    .exec(GetTokenRequest.super_agent_get_token)
//    .exec(GetTokenRequest.get_token)
//    .exec(GetTokenRequest.get_token_1)
//    .repeat(20) {
//      during(duration) {
//        randomSwitch(
//          20.0 -> exec(AgentServices.performWalletTransfer),
//          10.0 -> exec(AgentServices.performCashOut_1),
//          10.0 -> exec(BillPaymentRequest.agentBankTransfer),
//          10.0 -> exec(BillPaymentRequest.superAgentBankTransfer),
//          20.0 -> exec(BillPaymentRequest.agentBankTransfer_1),
//          10.0 -> exec(AgentServices.performWalletTransfer),
//          20.0 -> exec(AgentServices.performCashOut)
//        )
//      }
//    }

  val AgentTrxn_1: ScenarioBuilder = scenario("AgentTrxn_2 Transaction Simulation")
    .exec(GetTokenRequest.get_token_1)
    .exec(BillPaymentRequest.agentBankTransfer_1)
    .exec(AgentServices.performCashOut_1)

//  val SuperAgentTrxn: ScenarioBuilder = scenario("Agent Transaction Simulation")
//    .exec(GetTokenRequest.super_agent_get_token)
//    .exec(GetTokenRequest.get_token)
//    .repeat(5) {
//      during(duration) {
//        exec(AgentServices.performWalletTransfer)
//          .exec(BillPaymentRequest.agentBankTransfer)
//          .exec(BillPaymentRequest.superAgentBankTransfer)
//          .exec(AgentServices.performCashOut)
//          .exec(AgentServices.performWalletTransfer)
//      }
//    }
//    .during(duration) {
//      exec(AgentServices.performWalletTransfer)
//      .exec(BillPaymentRequest.agentBankTransfer)
//      .exec(BillPaymentRequest.superAgentBankTransfer)
//      .exec(AgentServices.performCashOut)
//      .exec(AgentServices.performWalletTransfer)
//    }
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
