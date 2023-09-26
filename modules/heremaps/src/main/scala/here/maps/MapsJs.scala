package here.maps

import org.scalajs.dom.Element

import scala.scalajs.js
import scala.scalajs.js.UndefOr
import scala.scalajs.js.annotation.*

/** The Here Maps API for Scala.js
  *
  * <p> This is a Un-Official Scala.js facade for the HERE Maps API. It allows you to use the HERE
  * Maps API from Scala.js code. </p>
  *
  * <p> The facade tries to be as close as possible to the original JavaScript API
  * (https://developer.here.com/documentation/maps/
  */
@js.native
/* JavaScript equivalent
import H from '@here/maps-api-for-javascript'
**/
@JSImport("@here/maps-api-for-javascript", JSImport.Default)
object MapsJs extends js.Object {

  /** @param element
    *   {!HTMLElement} element HTML element into which the map will be rendered.
    * @param baseLayer
    *   {!mapsjs.map.layer.Layer} baseLayer The layer to be used as the base layer.
    * @param opt_options
    *   {!mapsjs.Map.Options=} opt_options Additional map options (for example a map view)
    */
  @js.native
  class Map(element: Element, baseLayer: js.Object, opt_options: js.Object) extends js.Object {
    def setCenter(center: MapPoint, opt_animate: Boolean=false): Unit = js.native
    def setZoom(zoom: Int, opt_animate: Boolean=false): Unit = js.native
    def getViewPort(): ViewPort = js.native
  }
  @js.native
  object service extends js.Object {
    @js.native
    class Platform(platformOptions: PlatformOptions) extends js.Object {
      def createDefaultLayers(): MapTypes = js.native
    }
  }
  @js.native
  object mapevents extends js.Object{
    @js.native
    class MapEvents(map: Map) extends js.Object {}
    @js.native
    class Behavior(mapEvents: MapEvents) extends js.Object {}
  }
  @js.native
  object ui extends js.Object{
    @js.native
    object UI extends js.Object {
      def createDefault(map: Map, mapTypes: MapTypes): Unit = js.native
    }
  }
}

@js.native
trait ViewPort extends js.Object {
  def resize(): Unit = js.native
}

@js.native
trait Layer extends js.Object {}

@js.native
trait VectorLayer extends Layer {
  var normal: NormalLayer = js.native
}

@js.native
trait NormalLayer extends js.Object {
  var map: js.Object = js.native
}

@js.native
trait MapTypes extends js.Object {
  def vector: VectorLayer = js.native
}

class MapOptions(val zoom: UndefOr[Int]=10, val center: UndefOr[MapPoint],val pixelRation:UndefOr[Double]=1.0) extends js.Object {
  @JSName("apply")
  def apply(zoom: UndefOr[Int], center: UndefOr[MapPoint]): MapOptions =
    new MapOptions(zoom, center)
}

class MapPoint(val lng: UndefOr[Double], val lat: UndefOr[Double]) extends js.Object {
  @JSName("apply")
  def apply(lng: Double, lat: Double): MapPoint = new MapPoint(lng, lat)
}

class PlatformOptions(
    val apikey: js.UndefOr[String],
    val headers: js.UndefOr[js.Object] = js.undefined
) extends js.Object {
  @JSName("apply")
  def apply(apikey: js.UndefOr[String], headers: js.UndefOr[js.Object]): PlatformOptions =
    new PlatformOptions(apikey, headers)
}
