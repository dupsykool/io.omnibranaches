package mtn.insurance.requests

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._
import mtn.insurance.config.Config.app_url
import scala.util.Random

/**
  * Created by modup on 8/20/2019.
  */
object CreateCustomerReques {

  object randomStringGenerator {

    def randomString(length: Int) = scala.util.Random.alphanumeric.filter(_.isLetter).take(length).mkString
  }

  val feeder = Iterator.continually(Map("emailId" -> (Random.alphanumeric.take(20).mkString + "@foo.com")))

  val firstNameFeeder = Iterator.continually(Map("firstName" -> (randomStringGenerator.randomString(10))))

  val lastNameFeeder = Iterator.continually(Map("lastName" -> (randomStringGenerator.randomString(10))))


  val createCustomer = feed(feeder)
          .feed(firstNameFeeder)
      .feed(lastNameFeeder)
    .exec(http("create-customer")
    .post(app_url + "/employees")
      .check(status is 200)
    .body(ElFileBody("data/onboarding.json")).asJSON)
}

