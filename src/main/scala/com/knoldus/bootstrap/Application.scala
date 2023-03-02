package com.knoldus.bootstrap

import com.knoldus.schedulers.HealthScheduler
import com.typesafe.config.ConfigFactory

import scala.concurrent.ExecutionContext.Implicits.global
object Application extends App {

  val conf = ConfigFactory.load()

  val repositoryInstantiator: DataBaseInstantiator = new DataBaseInstantiator(conf.getConfig("db"))
  val healthScheduler = new HealthScheduler(repositoryInstantiator.healthCheckRepository)

}
