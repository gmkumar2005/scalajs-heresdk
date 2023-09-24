---
title: Time
---
<h2> Simple Map of Berlin Version 4 </h2>
<h2>Basic Interval Stream</h2>
<div class="mdoc-example">

```scala mdoc:js:invisible:shared
val secretKey = website.Secrets.hereApiKey
```

```scala mdoc:js
import com.raquo.laminar.api.L.{*, given}
import here.maps.{MapOptions, MapPoint, PlatformOptions, MapsJs as H}
import org.scalajs.dom
import org.scalajs.dom.document


windowEvents(_.onLoad).foreach { _ =>
  val mapContainer = dom.document.createElement("div").asInstanceOf[dom.HTMLElement]
  mapContainer.setAttribute("id", "mapContainer")
  mapContainer.style.height = "640px"
  mapContainer.style.width = "500px"
  containerNode.appendChild(mapContainer)
  val platform = H.service.Platform(
    PlatformOptions(apikey = secretKey)
  )
  
  val maptypes = platform.createDefaultLayers()
  val berlinMap = new H.Map(
    document.getElementById("mapContainer"),
    maptypes.vector.normal.map,
    MapOptions(zoom = 12, center = MapPoint(13.4, 52.51))
  )
}(unsafeWindowOwner)

```

</div>

Scala version @SCALA_VERSION@
