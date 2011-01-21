package test.akka
//import akka.actor.Actor._
import akka.actor._
import akka.config._
import akka.config.Supervision._
import akka.http._
import akka.util._

import akka.actor.Actor

import test.akka.service._

//import akka.util._
//import akka._
//import akka.actor.{ActorRef}
//import akka.dispatch.MessageDispatcher
class Boot extends Logging{
  val factory = SupervisorFactory(
    SupervisorConfig(
      OneForOneStrategy(List(classOf[Exception]), 3, 100),
        //
        // in this particular case, just boot the built-in default root endpoint
        //
      Supervise(Actor.actorOf[RootEndpoint],Permanent) ::
      Supervise(Actor.actorOf[SimpleAkkaAsyncHttpService],Permanent)
      :: Nil))
  factory.newInstance.start
}