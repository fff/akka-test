package test.akka.service
import akka.actor.Actor
import akka.actor.HotSwap
import akka.actor._
class MyActor extends Actor {
  def receive = {
    case "test" => println("received test")
    case "1" =>println("hello world")
    case s:String => println(s)
    case _=>println("unkown _")
  }
}

class MyActor1 extends Actor() {
  def receive ={
    case  "hello" => self.reply("world")
  }
}


object mytest{
    def main(args:Array[String]){
//        val myActor = Actor.actorOf[MyActor]
//         myActor.start  
//         myActor! "test"
//         myActor! "1"
//         
//         case class Register(user: String)
//         val message = Register("1")
//         println(message.toString)
//         myActor! "2222"
//         val resultOption = myActor !! ("Hello1", 10000)
//         if (resultOption.isDefined)
//             println("$$$"+resultOption.toString)
//         else
//             println("555"+resultOption.toString)
//         val result = (myActor !! "Hello-").getOrElse(println("TIMEOUT"))
//         println(result.toString)
//         
//         myActor ! HotSwap( self => {
//             case message => self.reply("hotswapped body")
//         })
         val remote = Actor.remote.actorOf[MyActor1]("127.0.0.1", 6666)
         System.exit(0)
    }
  
}
