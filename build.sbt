import org.scalajs.linker.interface.{ESVersion, ModuleSplitStyle}

val scala3Version = "3.3.1"

lazy val heremaps = project
  .in(file("modules/heremaps"))
  .enablePlugins(ScalaJSPlugin)
  .settings(
    name := "scalajs-heresdk",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    libraryDependencies ++=
      Seq.concat(
        Dependencies.laminar.value
      ),
    Compile / fastLinkJS / scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.ESModule) },
    Compile / fullLinkJS / scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) },
    scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.CommonJSModule)
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
    mdocIn := file("website/docs"),
    mdocJS := Some(heremaps)
      )
  .enablePlugins(MdocPlugin)

lazy val root = project
  .in(file("."))
  .settings(
    name := "scalajs-heresdk"
  )
  .aggregate(
    heremaps
  )
