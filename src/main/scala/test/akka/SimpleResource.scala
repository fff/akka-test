package test.akka.service

import javax.ws.rs.GET
import javax.ws.rs.Path
// The Java class will be hosted at the URI path "/greeting"

@Path("greeting")
class SimpleResource {

  // and implement the following GET method 

  @GET
  def getGreeting(): String = {
    "Hi there"
  }

}