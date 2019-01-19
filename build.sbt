name := "tasky"
version := "0.1.0"
scalaVersion := "2.12.8"


//scalacOptions ++= Seq("-feature", "-language:_", "-unchecked", "-deprecation", "-encoding", "utf8")
scalacOptions ++= Seq(
  "-encoding", "utf8"
  ,"-deprecation"
  , "-feature"
  ,"-unchecked"
  , "-language:_"
)


//libraryDependencies += "org.scalatest" % "scalatest_2.12" % "3.0.5" % "test"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"


val gitCommitCountTask = taskKey[String]("Prints commit count of the current branch")
gitCommitCountTask := {
  //val underGit = scala.sys.process.Process("git rev-parse --git-dir 2> /dev/null")
  //if (underGit.lines.isEmpty()) {
  //0
  //}

  val branch = scala.sys.process.Process("git symbolic-ref -q HEAD").lineStream.head.replace("refs/heads/","")
  val commitCount = scala.sys.process.Process(s"git rev-list --count $branch").lineStream.head
  println(s"total number of commits on [$branch]: $commitCount")
  commitCount
}


