package com.mb.bootstrap

import com.mb.bootstrap.actors.Supervisor

import com.typesafe.config.ConfigFactory
import akka.actor._

object MainServer extends App {

  val config = ConfigFactory.load()
  implicit val actorSystem: ActorSystem = ActorSystem("system", config.getConfig("serverConfig").withFallback(config))

  val supervisor = actorSystem.actorOf( Props(new Supervisor()), "supervisor" )

  actorSystem.log.info("System ready")
}
