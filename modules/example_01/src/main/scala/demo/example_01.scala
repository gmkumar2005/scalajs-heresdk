package demo

import com.raquo.laminar.api.L.{*, given}
import here.maps.{MapOptions, MapPoint, MapTypes, PlatformOptions, MapsJs as H}
import org.scalajs.dom.document

@main
def example_01(): Unit =
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

  // Step 4. Add a resize listener to make sure that the map occupies the whole container onLoad
  windowEvents(_.onLoad).foreach { _ =>
    berlinMap.getViewPort().resize()
  }(unsafeWindowOwner)

  // Step 5. Add a resize listener to make sure that the map occupies the whole container onResize
  windowEvents(_.onResize).foreach { _ =>
    berlinMap.getViewPort().resize()
  }(unsafeWindowOwner)

end example_01

object Main:
  private lazy val _secretKey: String = website.Secrets.hereApiKey
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
      MapOptions(center = MapPoint(13.3777, 52.5159), zoom = 10)
    )

    berlinMap
  end renderHereMap

end Main
