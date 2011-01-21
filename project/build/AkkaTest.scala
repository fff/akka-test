import sbt._
import de.element34.sbteclipsify._

class AkkaTestProject(info: ProjectInfo) extends DefaultWebProject(info) with Eclipsify with AkkaProject {
  override def compileOptions = super.compileOptions ++ Seq(Unchecked)

  val localRepo = "local nexus" at "http://192.168.7.181:8081/nexus/content/groups/public/"
  val akkaRepo = "Akka Maven2 Repository" at "http://www.scalablesolutions.se/akka/repository/"

  //  //	val jetty_repo = "jetty repository" at "http://oss.sonatype.org/content/groups/jetty"
  //
  //  val jettyModuleConfig = ModuleConfiguration("org.eclipse.jetty", localRepo)
  val jetty7 = "org.eclipse.jetty" % "jetty-webapp" % "7.1.6.v20100715" % "compile,test"
  val jetty7s = "org.eclipse.jetty" % "jetty-server" % "7.1.6.v20100715" % "compile,test"
  val akkaHttp = akkaModule("http")
  val akkaTypedActor = akkaModule("typed-actor")
  val akkaRemote = akkaModule("remote")
  val servlet = "javax.servlet" % "servlet-api" % "2.5" % "provided"
  override def dependencyPath = webappPath / "WEB-INF" / "lib"
  //	override def jettyClasspath = dependencyPath
  override def ivyXML = <dependencies><dependency org="se.scalablesolutions.akka" name="akka-http" rev="1.1-SNAPSHOT"><exclude module="jetty"/></dependency></dependencies>

  //  override def libraryDependencies = Set(
  //    "org.eclipse.jetty" % "jetty-webapp" % "7.1.6" % "test->default") ++ super.libraryDependencies

}