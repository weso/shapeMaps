lazy val scala212 = "2.12.12"
lazy val scala213 = "2.13.4"
lazy val supportedScalaVersions = List(scala213, scala212)

// Local dependencies
lazy val srdfVersion           = "0.1.90"
lazy val utilsVersion          = "0.1.73"
lazy val documentVersion       = "0.0.8"

// Dependency versions
lazy val antlrVersion          = "4.7.1"
lazy val catsVersion           = "2.3.0"
lazy val commonsTextVersion    = "1.8"
lazy val circeVersion          = "0.14.0-M1"
lazy val diffsonVersion        = "4.0.0"
lazy val declineVersion        = "1.3.0"
lazy val fs2Version            = "2.5.0"
// lazy val effVersion            = "4.6.1"
lazy val jenaVersion           = "3.16.0"
lazy val jgraphtVersion        = "1.3.1"
lazy val munitVersion          = "0.7.21"
lazy val munitEffectVersion    = "0.11.0"
lazy val logbackVersion        = "1.2.3"
lazy val loggingVersion        = "3.9.2"
lazy val rdf4jVersion          = "3.0.0"
lazy val scalacheckVersion     = "1.14.0"
lazy val scalacticVersion      = "3.2.0"
lazy val scalaTestVersion      = "3.2.0"
lazy val scalaGraphVersion     = "1.11.5"
lazy val scalatagsVersion      = "0.6.7"
lazy val scallopVersion        = "3.3.1"
lazy val seleniumVersion       = "2.35.0"
lazy val sextVersion           = "0.2.6"
lazy val typesafeConfigVersion = "1.3.4"
lazy val xercesVersion         = "2.12.0"

// Compiler plugin dependency versions
lazy val simulacrumVersion    = "1.0.0"
// lazy val kindProjectorVersion = "0.9.5"
lazy val scalaMacrosVersion   = "2.1.1"

// Dependency modules
lazy val antlr4            = "org.antlr"                  % "antlr4"               % antlrVersion
lazy val catsCore          = "org.typelevel"              %% "cats-core"           % catsVersion
lazy val catsKernel        = "org.typelevel"              %% "cats-kernel"         % catsVersion
// lazy val catsMacros        = "org.typelevel"              %% "cats-macros"         % catsVersion
lazy val catsEffect        = "org.typelevel"              %% "cats-effect"         % catsVersion
lazy val circeCore         = "io.circe"                   %% "circe-core"          % circeVersion
lazy val circeGeneric      = "io.circe"                   %% "circe-generic"       % circeVersion
lazy val circeParser       = "io.circe"                   %% "circe-parser"        % circeVersion
lazy val commonsText       = "org.apache.commons"         %  "commons-text"        % commonsTextVersion
lazy val decline           = "com.monovore"               %% "decline"             % declineVersion
lazy val declineEffect     = "com.monovore"               %% "decline-effect"      % declineVersion
lazy val diffsonCirce      = "org.gnieh"                  %% "diffson-circe"       % diffsonVersion
// lazy val eff               = "org.atnos"                  %% "eff"                 % effVersion
lazy val fs2               = "co.fs2"                     %% "fs2-core"            % fs2Version 
lazy val fs2io             = "co.fs2"                     %% "fs2-io"            % fs2Version 

lazy val jgraphtCore       = "org.jgrapht"                % "jgrapht-core"         % jgraphtVersion
lazy val logbackClassic    = "ch.qos.logback"             % "logback-classic"      % logbackVersion
lazy val jenaArq           = "org.apache.jena"            % "jena-arq"             % jenaVersion
lazy val jenaFuseki        = "org.apache.jena"            % "jena-fuseki-main"     % jenaVersion
lazy val munit             = "org.scalameta"              %% "munit"               % munitVersion
lazy val munitEffect       = "org.typelevel"              %% "munit-cats-effect-2" % munitEffectVersion


lazy val rdf4j_runtime     = "org.eclipse.rdf4j"          % "rdf4j-runtime"        % rdf4jVersion

// WESO components
lazy val document          = "es.weso"                    %% "document"        % documentVersion
lazy val srdf              = "es.weso"                    %% "srdf"            % srdfVersion
lazy val srdfJena          = "es.weso"                    %% "srdfjena"        % srdfVersion
lazy val srdf4j            = "es.weso"                    %% "srdf4j"          % srdfVersion
lazy val utils             = "es.weso"                    %% "utils"           % utilsVersion
lazy val typing            = "es.weso"                    %% "typing"          % utilsVersion
lazy val validating        = "es.weso"                    %% "validating"      % utilsVersion
lazy val utilsTest         = "es.weso"                    %% "utilstest"       % utilsVersion

lazy val scalaLogging      = "com.typesafe.scala-logging" %% "scala-logging"       % loggingVersion
lazy val scallop           = "org.rogach"                 %% "scallop"             % scallopVersion
lazy val scalactic         = "org.scalactic"              %% "scalactic"           % scalacticVersion
lazy val scalacheck        = "org.scalacheck"             %% "scalacheck"          % scalacheckVersion
lazy val scalaTest         = "org.scalatest"              %% "scalatest"           % scalaTestVersion
lazy val scalatags         = "com.lihaoyi"                %% "scalatags"           % scalatagsVersion
lazy val selenium          = "org.seleniumhq.selenium"    % "selenium-java"        % seleniumVersion
// lazy val htmlUnit          = "org.seleniumhq.selenium"    % "htmlunit-driver"      % seleniumVersion
lazy val sext              = "com.github.nikita-volkov"   % "sext"                 % sextVersion
lazy val typesafeConfig    = "com.typesafe"               % "config"               % typesafeConfigVersion
lazy val xercesImpl        = "xerces"                     % "xercesImpl"           % xercesVersion
lazy val simulacrum        = "org.typelevel"              %% "simulacrum"          % simulacrumVersion


lazy val shapeMapsRoot = project
  .in(file("."))
  .enablePlugins(ScalaUnidocPlugin, SbtNativePackager, WindowsPlugin, JavaAppPackaging, LauncherJarPlugin)
//  .disablePlugins(RevolverPlugin)
//  .settings(
//    buildInfoKeys := BuildInfoKey.ofN(name, version, scalaVersion, sbtVersion),
//    buildInfoPackage := "es.weso.shaclex.buildinfo" 
//  )
  .settings(commonSettings, 
    packagingSettings, 
    publishSettings, 
    // ghPagesSettings,
    wixSettings)
  .aggregate(shapeMaps)
  .dependsOn(shapeMaps)
  .settings(
    unidocProjectFilter in (ScalaUnidoc, unidoc) := inAnyProject -- inProjects(noDocProjects: _*),
    libraryDependencies ++= Seq(
      catsCore,
      catsKernel,
      // catsMacros,
      catsEffect,
      decline,
      declineEffect,
      logbackClassic,
      scalaLogging,
      scallop,
      typesafeConfig,
    ),
    cancelable in Global      := true,
    fork                      := true,
//    parallelExecution in Test := false,
    ThisBuild / turbo := true,
    crossScalaVersions := supportedScalaVersions,
//    crossScalaVersions := Nil,
    publish / skip := true,
  )

lazy val CompatTest = config("compat") extend (Test) describedAs("Tests that check compatibility (some may fail)")
def compatFilter(name: String): Boolean = name endsWith "CompatTest"
def testFilter(name: String): Boolean = /*(name endsWith "Test") && */ !compatFilter(name)

lazy val shapeMaps = project
  .in(file("modules/shapeMaps"))
  .enablePlugins(Antlr4Plugin)
//  .disablePlugins(RevolverPlugin)
  .settings(commonSettings, publishSettings, antlrSettings("es.weso.shapemaps.parser"))
  .dependsOn()
  .settings(
    crossScalaVersions := supportedScalaVersions,
    libraryDependencies ++= Seq(
      srdf,
      utils,
      srdfJena % Test,
      sext % Test,
      scalaLogging,
      catsCore,
      catsKernel,
      circeCore,
      circeGeneric,
      circeParser,
      fs2, fs2io,
      munit % Test,
      munitEffect % Test
      ),
    testFrameworks += new TestFramework("munit.Framework")
  )

def macroDependencies(scalaVersion: String) =
  CrossVersion.partialVersion(scalaVersion) match {
    case Some((2, minor)) if minor < 13 =>
      Seq(
        compilerPlugin(("org.scalamacros" %% "paradise" % "2.1.1").cross(CrossVersion.patch))
      )
    case _ => Seq()
  }

lazy val noDocProjects = Seq[ProjectReference](
)

lazy val noPublishSettings = Seq(
//  publish := (),
//  publishLocal := (),
  publishArtifact := false
)

lazy val sharedDependencies = Seq(
  libraryDependencies ++= Seq(
    scalactic,
    scalaTest % Test
  )
)

lazy val packagingSettings = Seq(
  mainClass in Compile        := Some("es.weso.shapemaps.Main"),
  mainClass in assembly       := Some("es.weso.shapemaps.Main"),
  test in assembly            := {},
  assemblyJarName in assembly := "shapeMaps.jar",
  packageSummary in Linux     := name.value,
  packageSummary in Windows   := name.value,
  packageDescription          := name.value
)

lazy val compilationSettings = Seq(
  // scalaVersion := "2.13.1",
  // format: off
  javacOptions ++= Seq("-source", "1.8", "-target", "1.8"),
  scalacOptions ++= Seq(
    "-deprecation",                      // Emit warning and location for usages of deprecated APIs.
    "-encoding", "utf-8",                // Specify character encoding used by source files.
    "-explaintypes",                     // Explain type errors in more detail.
    "-feature",                          // Emit warning and location for usages of features that should be imported explicitly.  "-encoding", "UTF-8",
    "-language:_",
    "-target:jvm-1.8",
    "-unchecked",                        // Enable additional warnings where generated code depends on assumptions.
    "-Xlint",
    "-Yrangepos",
    "-Ywarn-dead-code",                  // Warn when dead code is identified.
    // "-Xfatal-warnings",
    "-Ywarn-extra-implicit",             // Warn when more than one implicit parameter section is defined.
  ) ++ (if (priorTo2_13(scalaVersion.value))
  Seq(
    "-Yno-adapted-args",
    "-Xfuture"
  )
else
  Seq(
    "-Ymacro-annotations"
  ))

  // format: on
)

def priorTo2_13(scalaVersion: String): Boolean =
  CrossVersion.partialVersion(scalaVersion) match {
    case Some((2, minor)) if minor < 13 => true
    case _                              => false
  }

lazy val wixSettings = Seq(
  wixProductId        := "39b564d5-d381-4282-ada9-87244c76e14b",
  wixProductUpgradeId := "6a710435-9af4-4adb-a597-98d3dd0bade1"
// The same numbers as in the docs?
// wixProductId := "ce07be71-510d-414a-92d4-dff47631848a",
// wixProductUpgradeId := "4552fb0e-e257-4dbd-9ecb-dba9dbacf424"
)

/*lazy val ghPagesSettings = Seq(
  git.remoteRepo := "git@github.com:weso/shapeMaps.git"
)*/

lazy val commonSettings = compilationSettings ++ sharedDependencies ++ Seq(
  organization := "es.weso",
  resolvers ++= Seq(
    Resolver.bintrayRepo("labra", "maven"),
    Resolver.bintrayRepo("weso", "weso-releases"),
    Resolver.sonatypeRepo("snapshots")
  )
)

def antlrSettings(packageName: String) = Seq(
  antlr4GenListener in Antlr4 := true,
  antlr4GenVisitor in Antlr4  := true,
  antlr4Dependency in Antlr4  := antlr4,
  antlr4PackageName in Antlr4 := Some(packageName),
)

lazy val publishSettings = Seq(
  maintainer      := "Jose Emilio Labra Gayo <labra@uniovi.es>",
  homepage        := Some(url("https://github.com/weso/shapeMaps")),
  licenses        := Seq("MIT" -> url("http://opensource.org/licenses/MIT")),
  scmInfo         := Some(ScmInfo(url("https://github.com/weso/shapeMaps"), "scm:git:git@github.com:weso/shapeMaps.git")),
  autoAPIMappings := true,
  apiURL          := Some(url("http://weso.github.io/shapeMaps/latest/api/")),
  pomExtra        := <developers>
                       <developer>
                         <id>labra</id>
                         <name>Jose Emilio Labra Gayo</name>
                         <url>https://github.com/labra/</url>
                       </developer>
                     </developers>,
  scalacOptions in doc ++= Seq(
    "-diagrams-debug",
    "-doc-source-url",
    scmInfo.value.get.browseUrl + "/tree/master€{FILE_PATH}.scala",
    "-sourcepath",
    baseDirectory.in(LocalRootProject).value.getAbsolutePath,
    "-diagrams",
  ),
  publishMavenStyle              := true,
  bintrayRepository in bintray   := "weso-releases",
  bintrayOrganization in bintray := Some("weso")
)
