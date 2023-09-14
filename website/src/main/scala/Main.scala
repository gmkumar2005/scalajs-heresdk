import io.laminext.highlight.{Highlight, HighlightJavaScript, HighlightJson, HighlightScala, HighlightXml}
import scribe.*

import scala.io.AnsiColor.*

@main def website(): Unit =
  scribe.Logger.root
    .clearHandlers()
    .clearModifiers()
    .withHandler(minimumLevel = Some(Level.Debug))
    .replace()
  Highlight.registerLanguage("scala", HighlightScala)
  Highlight.registerLanguage("javascript", HighlightJavaScript)
  Highlight.registerLanguage("json", HighlightJson)
  Highlight.registerLanguage("html", HighlightXml)


  scribe.info(s"$GREEN $msg$RESET")
  scribe.debug(s"$GREEN$BOLD $msg $RESET")


def msg = "Starting HereSdk.ScalaJs demo :)"


