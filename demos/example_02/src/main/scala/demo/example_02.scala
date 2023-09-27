package demo

import com.raquo.laminar.api.L.{*, given}
import here.maps.{MapOptions, MapPoint, MapTypes, PlatformOptions, MapsJs as H}
import org.scalajs.dom.{document, window}

import scala.annotation.unused

@main
def example_02(): Unit =
  // Step 1. Create a container which will be used to display the map.
  val demoContainer =
    div(idAttr := "demoContainer", height := "460px", width := "640px",
        cls := "text-center mx-auto container float-center border-solid border-2 border-zinc-400")

  // Step 2. Render the container on the page
  renderOnDomContentLoaded(
      document.getElementById("app"),
      demoContainer
  )
  // Step 3. Render the map inside the container
  val berlinMap = Main.renderHereMap(demoContainer)

  // Step 4. Make the map interactive
  // MapEvents enables the event system
  // Behavior implements default interactions for pan/zoom (also on mobile touch environments)
  @unused
  val behavior = new H.mapevents.Behavior(new H.mapevents.MapEvents(berlinMap))

  // Step 5. Add a resize listener to make sure that the map occupies the whole container onLoad
  windowEvents(_.onLoad).foreach { _ =>
    berlinMap.getViewPort().resize()
  }(unsafeWindowOwner)

  // Step 6. Add a resize listener to make sure that the map occupies the whole container onResize
  windowEvents(_.onResize).foreach { _ =>
    berlinMap.getViewPort().resize()
  }(unsafeWindowOwner)

  // Step 7. Move the map to display over Ram Mandir
  Main.moveRamMandir(berlinMap)
end example_02

object Main:
  private lazy val _secretKey: String = website.Secrets.hereApiKey
  private lazy val _pixelRatio: Double = window.devicePixelRatio

  // Step 3.1 Boilerplate code for initializing the map
  def renderHereMap(mapContainer: Element): H.Map =
    val platform = H.service.Platform(
        PlatformOptions(
            apikey = _secretKey
        )
    )
    val mapTypes: MapTypes = platform.createDefaultLayers()
  // Step 3.2 Initialize a map - this map is centered over Berlin
    val berlinMap = new H.Map(
        mapContainer.ref,
        mapTypes.vector.normal.map,
        MapOptions(center = MapPoint(13.4, 52.5), zoom = 4,
            pixelRatio = _pixelRatio)
    )
  // Step 3.3 Create the default UI components to allow the user to interact with them
    @unused
    val ui: Unit = H.ui.UI.createDefault(berlinMap, mapTypes)

    berlinMap
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
