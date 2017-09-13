package com.mb.bootstrap.actors

import com.mb.bootstrap.utils.GlobalMessages._
import com.mb.bootstrap.utils.GlobalMessages.SimpleStringMessage

import akka.actor._

class Supervisor extends Actor {

  /**
    * default state
    * @return Receive
    */
  override def receive: Receive = {

    case simpleStringMessage: SimpleStringMessage =>

      sender ! SimpleStringMessage(simpleStringMessage.message + " - Pong")

  }

}
