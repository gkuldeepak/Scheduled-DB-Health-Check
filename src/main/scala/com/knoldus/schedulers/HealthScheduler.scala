package com.knoldus.schedulers

import akka.actor.{ActorSystem, Props}
import com.knoldus.dao.HealthCheckRepository
import com.knoldus.models.Models.Start
import com.knoldus.services.HealthCheckService

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.DurationInt
import scala.language.postfixOps

class HealthScheduler(healthCheckRepository: HealthCheckRepository) {

  val system = ActorSystem("schedulerSystem")
  val actor = system.actorOf(Props[HealthCheckService])

  val scheduler = system.scheduler.scheduleWithFixedDelay(1.second, 10.seconds, actor, Start(healthCheckRepository))

}
