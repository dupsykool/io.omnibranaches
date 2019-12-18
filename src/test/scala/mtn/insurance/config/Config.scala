package mtn.insurance.config

/**
  * Created by modup on 8/18/2019.
  */

object Config {

    val app_url = "http://lab.omnibranches.com:8080/api/v1/"

    val omni_url = "https://demo.omnibranches.com/omnib/api"

    val omni_url_trxn = ""

    val users = Integer.getInteger("users",3).toInt
//    val ramp = Integer.getInteger("rampup", 1).toInt
    val duration = Integer.getInteger("duration", 10).toInt
//    val t_throughput = Integer.getInteger("throughput", 100).toInt
}
