import DependencyVersions.{catsVersion, circeVersion, mtlVersion, scribeVersion}
import org.portablescala.sbtplatformdeps.PlatformDepsPlugin.autoImport.*
import sbt.*
import sbt.Keys.libraryDependencies

object Dependencies {

  val loggingLibs: Def.Initialize[Seq[ModuleID]] = Def.setting {
    Seq(
      "com.outr" %%% "scribe-cats" % scribeVersion,
      "com.outr" %%% "scribe" % scribeVersion
    )
  }
  val typeLevelLibs: Def.Initialize[Seq[ModuleID]] = Def.setting {
    Seq(
      "org.typelevel" %%% "cats-effect" % catsVersion,
      "org.typelevel" %%% "cats-mtl" % mtlVersion,
    )
  }

  val circeLibs: Def.Initialize[Seq[ModuleID]] = Def.setting {
    Seq(
      "io.circe" %%% "circe-core" % circeVersion,
      "io.circe" %%% "circe-generic" % circeVersion,
      "io.circe" %%% "circe-parser" % circeVersion,
      "io.circe" %%% "circe-literal" % circeVersion
    )
  }
  val laminar: Def.Initialize[Seq[ModuleID]] = Def.setting {
    Seq(
      "com.raquo" %%% "laminar" % DependencyVersions.laminar
    )
  }

  val `tuplez-apply`: Def.Initialize[Seq[ModuleID]] = Def.setting {
    Seq(
      "app.tulz" %%% "tuplez-apply" % DependencyVersions.`tuplez-apply`
    )
  }

  val domtestutils: Def.Initialize[Seq[ModuleID]] = Def.setting {
    Seq(
      "com.raquo" %%% "domtestutils" % DependencyVersions.domtestutils % Test,
        "org.scala-js" %%% "scalajs-dom" % DependencyVersions.ScalaJsDom,
    )
  }

  val scalatest: Def.Initialize[Seq[ModuleID]] = Def.setting {
    Seq(
      "org.scalatest" %%% "scalatest" % DependencyVersions.scalatest % Test,
    )
  }

  // website

  val laminext: Def.Initialize[Seq[ModuleID]] = Def.setting {
    Seq(
      "io.laminext" %%% "core" % DependencyVersions.laminext,
      "io.laminext" %%% "highlight" % DependencyVersions.laminext,
      "io.laminext" %%% "ui" % DependencyVersions.laminext,
      "io.laminext" %%% "util" % DependencyVersions.laminext
    )
  }

  val `embedded-files-macro`: Def.Initialize[Seq[ModuleID]] = Def.setting {
    Seq(
      "com.yurique" %%% "embedded-files-macro" % DependencyVersions.`embedded-files-macro`
    )
  }

  val sourcecode: Def.Initialize[Seq[ModuleID]] = Def.setting {
    Seq(
      "com.lihaoyi" %%% "sourcecode" % DependencyVersions.sourcecode
    )
  }

  val `scala-js-macrotask-executor`: Def.Initialize[Seq[ModuleID]] = Def.setting {
    Seq(
      "org.scala-js" %%% "scala-js-macrotask-executor" % DependencyVersions.`scala-js-macrotask-executor`
    )
  }

}
