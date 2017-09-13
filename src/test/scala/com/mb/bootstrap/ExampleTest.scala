package com.mb.bootstrap

import com.mb.bootstrap.utils.GlobalMessages._
import com.mb.bootstrap.actors.Supervisor

import akka.actor._
import akka.testkit._
import org.scalatest._

class ExampleTest extends TestKit(ActorSystem("system")) with ImplicitSender with WordSpecLike with Matchers with BaseTest {

  val supervisor: ActorRef = system.actorOf( Props(new Supervisor()), "supervisor" )

  "an supervisor actor" must {

    "reply with modified message" in {
      supervisor ! SimpleStringMessage("Hello World")
      expectMsg(SimpleStringMessage("Hello World - Pong"))
    }

  }

}