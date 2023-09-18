import com.raquo.laminar.api.L.*
import io.laminext.highlight.{Highlight, HighlightJavaScript, HighlightJson, HighlightScala, HighlightXml}
import common.ScribeLogger
import components.atoms.Atoms.{Avatar, renderAttribution}
import components.organisms.Organisms.{Header, renderBody}
import org.scalajs.dom
import org.scalajs.dom.{document, html}

import scala.io.AnsiColor.*

object Main extends ScribeLogger:
  def main(args: Array[String]): Unit =
    setupLogger(false, true)
    scribe.info("Hello, Scala.js! with Laminar")
    scribe.info(s"$GREEN $msg2 $RESET")
    scribe.debug(s"$GREEN$BOLD $msg2 $RESET")
    document.getElementById("app-container") match {
      case null => scribe.error("app-container not found")
      case _ => renderOnDomContentLoaded(
        dom.document.getElementById("app-container"),
          Main.appElement)
    }
  def appElement: Element =
    div(cls:="bg-white",idAttr:="body",
      Header(logoImageUrl = "images/fast-delivery.png",
        username= "Vicky M",
        avatarUrl= "images/team-1-800x800.jpg"),
      renderBody(div("Hello Body")),
      renderAttribution(),
      div(cls:="container mx-auto px-4 py-4","Hello, Laminar!"))

def msg2 = "Starting HereSdk.ScalaJs demo :)"
