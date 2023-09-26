package demo

import com.raquo.laminar.api.L.{*, given}
import here.maps.{MapOptions, MapPoint, PlatformOptions, MapsJs as H}
import org.scalajs.dom
import org.scalajs.dom.document

@main
def example_02(): Unit =
  renderOnDomContentLoaded(
      dom.document.getElementById("app"),
      Main.appElement()
  )
end example_02

val secretKey = website.Secrets.hereApiKey
lazy val pixelRatio: Double = dom.window.devicePixelRatio
object Main:

  def renderSimplePage(): Element = {
    div()
  }
  def appElement(): Element =
    div(
        renderHereMap()
    )
  end appElement

  private def renderHereMap(): Element =
    val platform = H.service.Platform(
        PlatformOptions(
            apikey = secretKey
        )
    )
    val maptypes = platform.createDefaultLayers()

    val berlinMap = new H.Map(
        document.getElementById("mapContainer"),
        maptypes.vector.normal.map,
        MapOptions(center = MapPoint(13.4, 52.5), pixelRatio)
    )
    windowEvents(_.onResize).foreach { _ =>
      berlinMap.getViewPort().resize()
    }(unsafeWindowOwner)

    val behavior =
      new H.mapevents.Behavior(new H.mapevents.MapEvents(berlinMap))
    val ui = H.ui.UI.createDefault(berlinMap, maptypes)
    moveRamMandir(berlinMap)
    div()
  end renderHereMap

  /**
   * @param map
   *   Moves the map to display over Ram Mandir
   */
  def moveRamMandir(map: H.Map): Unit =
    map.setCenter(MapPoint(82.194298, 26.795601))
    map.setZoom(14)
  end moveRamMandir

end Main
