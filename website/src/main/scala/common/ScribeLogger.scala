package common

import scribe.*
import scribe.cats.effect
import scribe.format.*

trait ScribeLogger {

  private def getLogLevel(quiet: Boolean, trace: Boolean): scribe.Level = {
    if (trace) {
      scribe.Level.Trace
    } else if (quiet) {
      scribe.Level.Error
    } else scribe.Level.Debug
  }

  def setupLogger(quiet: Boolean, trace: Boolean): Logger = {
    scribe.Logger.root
      .clearHandlers()
      .clearModifiers()
      .withHandler(
        minimumLevel = Some(getLogLevel(quiet, trace)),
        formatter =
          formatter"$dateFull [$threadName] [${levelColor(level)}] ($className) $fileName:$line $methodName - $messages"
      )
      .replace()
  }

}
