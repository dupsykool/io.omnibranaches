package mtn.insurance.config

/**
  * Created by modup on 8/18/2019.
  */

object Config {

    val app_url = "http://lab.omnibranches.com:8080/api/v1/"



    val users = Integer.getInteger("users", 1).toInt
//    val rampUp = Integer.getInteger("rampup", 1).toInt
//    val throughput = Integer.getInteger("throughput", 100).toInt
}
