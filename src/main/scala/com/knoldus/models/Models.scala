package com.knoldus.models

import com.knoldus.dao.HealthCheckRepository

import java.sql.Timestamp
import java.util.Date

object Models {

  case class HealthCheckRequest (updated: Timestamp = new Timestamp(new Date(System.currentTimeMillis()).getTime))

  case class Start(healthCheckRepository : HealthCheckRepository)

  case class ErrorResponse(message: String)

  case class BaseResponse(isDone: Boolean)

}
