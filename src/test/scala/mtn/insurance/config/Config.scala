package mtn.insurance.config

/**
  * Created by modup on 8/18/2019.
  */

object Config {

    val app_url = "http://lab.omnibranches.com:8080/api/v1/"

    val omni_url = "https://demo.omnibranches.com/api"

    val omni_url_trxn = ""

    val t_concurrency = Integer.getInteger("users", 5).toInt
    val t_rampUp = Integer.getInteger("rampup", 1).toInt
//    val t_holdFor = Integer.getInteger("duration", 60).toInt
//    val t_throughput = Integer.getInteger("throughput", 100).toInt
}
