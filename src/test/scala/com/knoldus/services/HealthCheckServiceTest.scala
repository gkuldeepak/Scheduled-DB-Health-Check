package com.knoldus.services

import akka.actor.{ActorSystem, Props}
import akka.testkit.{ImplicitSender, TestKit}
import com.knoldus.dao.HealthCheckRepository
import com.knoldus.models.Models.Start
import org.mockito.Mockito.when
import org.scalatest.BeforeAndAfterAll
import org.scalatest.wordspec.AnyWordSpecLike
import org.scalatestplus.mockito.MockitoSugar.mock

import scala.concurrent.Future

class HealthCheckServiceTest extends TestKit(ActorSystem("testSystem")) with ImplicitSender with AnyWordSpecLike with BeforeAndAfterAll {

  val healthCheckRepository: HealthCheckRepository = mock[HealthCheckRepository]

  "actor system" should {
    "update the db entries" in {
      when(healthCheckRepository.update()) thenReturn (Future.successful(true))
      system.actorOf(Props[HealthCheckService]) ! Start(healthCheckRepository)
      expectNoMsg()
    }

    "not update the db entries" in {
      when(healthCheckRepository.update()) thenReturn (Future.successful(false))
      system.actorOf(Props[HealthCheckService]) ! Start(healthCheckRepository)
      expectNoMsg()
    }
  }
}

