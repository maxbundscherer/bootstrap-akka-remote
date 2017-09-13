package com.mb.bootstrap

import com.mb.bootstrap.utils.GlobalMessages._

import akka.actor._
import com.typesafe.config.ConfigFactory
import scala.io.StdIn

object ExampleClient extends App {

  /**
    * Example actor for example client
    */
  private class ExampleActor extends Actor with ActorLogging {

    private val serverSupervisor = context.actorSelection("akka.tcp://system@0.0.0.0:5150/user/supervisor")

    serverSupervisor ! SimpleStringMessage("Hello World")

    override def receive: Receive = {

      case simpleStringMessage: SimpleStringMessage => log.info( "Get \"" + simpleStringMessage.message + "\" from " + sender )
    }

  }

  val config = ConfigFactory.load()
  implicit val actorSystem: ActorSystem = ActorSystem("system", config.getConfig("exampleClientConfig").withFallback(config))

  val supervisor = actorSystem.actorOf( Props(new ExampleActor()), "exampleActor" )

  actorSystem.log.info("Press enter to shutdown actor-system")
  StdIn.readLine()
  actorSystem.terminate()
}