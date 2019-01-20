package com.example

import akka.actor.Actor
import akka.event.Logging
import com.example.messages.SetRequest

import scala.collection.mutable

class AkkademyDb extends Actor {
  val log = Logging(context.system, this)
  val map = new mutable.HashMap[String, Object]

  override def receive: Receive = {
    case SetRequest(key, value) => {
      log.info("key {} and value {}", key, value)
      map.put(key, value)
    }
    case _ => {
      log.warning("received unknown message")
    }
  }
}
