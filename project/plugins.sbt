addSbtPlugin("org.scala-js" % "sbt-scalajs" % "1.13.2")
addSbtPlugin("org.scalablytyped.converter" % "sbt-converter" % "1.0.0-beta42")
addDependencyTreePlugin
logLevel := Level.Warn

libraryDependencies += "org.commonmark" % "commonmark"               % "0.21.0"
libraryDependencies += "org.scala-js"  %% "scalajs-env-nodejs"       % "1.4.0"
libraryDependencies += "org.scala-js"  %% "scalajs-env-selenium"     % "1.1.1"
libraryDependencies += "org.scala-js"  %% "scalajs-env-jsdom-nodejs" % "1.1.0"



addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.5.0")

addSbtPlugin("com.github.sbt" % "sbt-pgp" % "2.2.1")

addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "3.9.21")

//addSbtPlugin("io.github.davidgregory084" % "sbt-tpolecat" % "0.1.22")

addSbtPlugin("com.github.sbt" % "sbt-github-actions" % "0.15.0")

addSbtPlugin("com.github.sbt" % "sbt-ci-release" % "1.5.12")

addSbtPlugin("ch.epfl.scala" % "sbt-version-policy" % "2.1.3")

addSbtPlugin("com.yurique" % "sbt-embedded-files" % "0.4.0")

addSbtPlugin("com.eed3si9n" % "sbt-buildinfo" % "0.11.0")
