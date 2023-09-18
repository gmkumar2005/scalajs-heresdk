import org.scalajs.linker.interface.{ESVersion, ModuleSplitStyle}

val scala3Version = "3.3.1"

lazy val heremaps = project
  .in(file("modules/heremaps"))
  .enablePlugins(ScalaJSPlugin)
  .settings(
    name := "scalajs-heresdk",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    libraryDependencies += "com.raquo" %%% "laminar" % "16.0.0",
    libraryDependencies ++=
      Seq.concat(
        Dependencies.laminar.value,
        Dependencies.`tuplez-apply`.value,
        Dependencies.scalatest.value,
        Dependencies.domtestutils.value,
        Dependencies.`scala-js-macrotask-executor`.value.map(_ % Test)
      ),
    Compile / fastLinkJS / scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.ESModule) },
    Compile / fullLinkJS / scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) },
    scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.ESModule)
        .withModuleSplitStyle(
          ModuleSplitStyle.SmallModulesFor(List("heremaps"))
        )
    },
    Compile / scalaJSLinkerConfig ~= { _.withSourceMap(false) },
    scalaJSUseMainModuleInitializer := true
  )

lazy val website = project
  .in(file("website"))
  .settings(
    name := "scalajs-heresdk-website",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    libraryDependencies ++= Seq.concat(
      Dependencies.laminext.value,
      Dependencies.`embedded-files-macro`.value,
      Dependencies.sourcecode.value,
      Dependencies.laminar.value,
      Dependencies.loggingLibs.value,
      Dependencies.typeLevelLibs.value,
//      Dependencies.circeLibs.value
    ),
    Compile / fastLinkJS / scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.ESModule) },
    Compile / fullLinkJS / scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) },
    scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.ESModule)
        .withModuleSplitStyle(
          ModuleSplitStyle.SmallModulesFor(List("website"))
        )
    },
    Compile / scalaJSLinkerConfig ~= { _.withSourceMap(true) },
    scalaJSUseMainModuleInitializer := true,
  )
  .enablePlugins(ScalaJSPlugin, EmbeddedFilesPlugin, BuildInfoPlugin)
  .dependsOn(
    heremaps
  )

lazy val root = project
  .in(file("."))
  .settings(
    name := "scalajs-heresdk"
  )
  .aggregate(
    heremaps
  )
