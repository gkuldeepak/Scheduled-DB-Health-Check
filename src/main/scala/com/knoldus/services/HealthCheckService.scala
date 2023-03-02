package com.knoldus.services

import akka.actor.{Actor, ActorLogging}
import com.knoldus.dao.HealthCheckRepository
import com.knoldus.models.Models.{BaseResponse, ErrorResponse, Start}
import scala.concurrent.ExecutionContext.Implicits.global

class HealthCheckService extends Actor with ActorLogging {

  override def receive: Receive = {
    case Start(healthCheckRepository : HealthCheckRepository) =>
      log.info(Console.YELLOW +"[Info] Performing Health Check of DataBase" + Console.RESET)
      healthCheckRepository.update().map {
        case true =>
          log.info(Console.GREEN + "Health Check Successful" + Console.RESET)
        case false =>
          log.error(Console.RED + "Health Check Failed" + Console.RESET)
      }

    case _ =>
      log.error(Console.RED + "Invalid Request" + Console.RESET)
  }
}

