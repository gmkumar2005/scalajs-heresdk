import org.scalajs.linker.interface.ModuleSplitStyle

// Lets me depend on Maven Central artifacts immediately without waiting
resolvers ++= Resolver.sonatypeOssRepos("public")



ThisBuild / scalaVersion := DependencyVersions.scala3Version

ThisBuild / crossScalaVersions := Seq(DependencyVersions.scala3Version)

val copyFileTask = taskKey[Unit]("Copy the artifact file to another folder")

// Define the task implementation
copyFileTask := {
  val mdocDir = baseDirectory.value / "website/target/mdoc"
  IO.createDirectory(mdocDir)
}


lazy val heremaps = project
  .in(file("modules/heremaps"))
  .enablePlugins(ScalaJSPlugin,ScalaJSBundlerPlugin)
  .settings(
    name := "scalajs-heresdk",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := DependencyVersions.scala3Version,
    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % DependencyVersions.ScalaJsDom,
    (publish / skip) := true,
    webpackBundlingMode := BundlingMode.LibraryOnly(),
    (installJsdom / version) := DependencyVersions.ScalaJsDom,
    (webpack / version) := DependencyVersions.Webpack,
    (startWebpackDevServer / version) := DependencyVersions.WebpackDevServer,
    libraryDependencies ++=
      Seq.concat(
        Dependencies.laminar.value
      ),
    Compile / fastLinkJS / scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) },
    Compile / fullLinkJS / scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) },
    scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.CommonJSModule)
        .withModuleSplitStyle(
          ModuleSplitStyle.SmallModulesFor(List("heremaps"))
        )
    },
    Compile / scalaJSLinkerConfig ~= { _.withSourceMap(false) },
    scalaJSUseMainModuleInitializer := true,
    (Compile / npmDependencies) ++= Seq(
      "@here/maps-api-for-javascript" -> "1.46.0",
    ),
    scalacOptions ~= { options: Seq[String] =>
      options.filterNot { o =>
        o.startsWith("-Wvalue-discard") || o.startsWith("-Ywarn-value-discard") || o.startsWith("-Ywarn-unused") || o.startsWith("-Wunused")
      }
    },
    webpackConfigFile := Some(baseDirectory.value / "custom.webpack.config.js")
  )

lazy val website = project
  .enablePlugins(MdocPlugin, DocusaurusPlugin)
  .settings(
    moduleName := "Scalajs-HereSdk-docs",
    mdocIn := file("website/docs"),
    mdocJS := Some(heremaps),
    mdocJSLibraries := (heremaps / Compile / fullOptJS / webpack).value,
    (publish / skip) := true,
    mdocVariables := Map(
      "js-mount-node" -> "containerNode",
      "js-batch-mode" -> "true",
      "js-opt"->"fast",
      // Use full to obfuscate the secrets
      //  // Use these as @VERSION@ in mdoc-processed .md files
      //  "LAMINAR_VERSION" -> version.value.replace("-SNAPSHOT", ""), // This can return incorrect version too easily
      "SCALA_VERSION" -> scalaVersion.value
    ),

  )


lazy val root = project
  .in(file("."))
  .settings(
    name := "scalajs-heresdk"
  )
  .aggregate(
    heremaps
  )
