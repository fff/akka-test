import sbt._

class Plugins(info:ProjectInfo) extends PluginDefinition(info){
    val localRepo="local " at "http://192.168.7.181:8081/nexus/content/groups/public/"
    val akkaRepo = "Akka Maven2 Repository" at "http://www.scalablesolutions.se/akka/repository/"

	lazy val akkaPlugin="se.scalablesolutions.akka" %"akka-sbt-plugin"%"1.0-RC3"
	//lazy val akkaPlugin="akka" %"akka-sbt-plugin"%"1.0-RC3"
	lazy val eclipse = "de.element34" % "sbt-eclipsify" % "0.7.0"
 }