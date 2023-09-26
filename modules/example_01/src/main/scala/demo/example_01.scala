package demo

import com.raquo.laminar.api.L.{*, given}
import here.maps.{MapOptions, MapPoint, PlatformOptions, MapsJs as H}
import org.scalajs.dom
import org.scalajs.dom.document

import scala.scalajs.js.Dynamic.global as g

@main
def example_01(): Unit =
  renderOnDomContentLoaded(
      dom.document.getElementById("app"),
      Main.appElement()
  )
end example_01

object Main:
  def appElement(): Element =
    div(
        renderHereMap()
    )
  end appElement

  private def renderHereMap(): Element =
    val platform = H.service.Platform(
        PlatformOptions(
            apikey = g.hereApiKey.asInstanceOf[String]
        )
    )
    val maptypes = platform.createDefaultLayers()
    val berlinMap = new H.Map(
        document.getElementById("mapContainer"),
        maptypes.vector.normal.map,
        MapOptions(zoom = 10, center = MapPoint(13.4, 52.51))
    )

    div()
  end renderHereMap
end Main
