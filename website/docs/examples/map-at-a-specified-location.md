---
title: Map at a specified location
---
## //TODO
The use case involves developing an application that presents a static, non-interactive map by default.

This implementation uses `scalajs` with `Laminar` code to display the map in an HTML page and consists of the following steps:

## Viewport meta-tag
To ensure optimum performance on mobile devices, add the following meta-tag to the <head> section of the HTML page:
```html
<meta name="viewport" content="initial-scale=1.0, width=device-width" />
```

## Imports
You need to import the necessary `Scala.js` modules and classes into your project. Here are the typical imports you'll need:
```scala
import com.raquo.laminar.api.L.{*, given}
import here.maps.{MapOptions, MapPoint, PlatformOptions, MapsJs as H}
import org.scalajs.dom
import org.scalajs.dom.document
```

A crucial aspect of crafting a functional application involves establishing seamless communication with the backend services offered by HERE REST APIs. In our particular scenario, these backend services diligently handle requests for map data, ensuring its prompt retrieval and subsequent presentation within the application.

Initiate the process by creating a Platform object, an integral component of your application's architecture. To set up this Platform object, you will need to provide the unique API key that you received upon registration. This API key serves as your secure access pass to unlock the full capabilities, enabling your application to interact with a wide range of location-based services and functionalities.

```scala
val platform = H.service.Platform(
    PlatformOptions(apikey = secretKey)
  )
```

This object offers a suite of methods that simplify the creation of comprehensive service stubs. These stubs are essentially functional placeholders for essential services, including map tile service stubs, routing service stubs, and more. They serve as the building blocks upon which you can construct and integrate various location-based functionalities into your application effortlessly.

In this particular scenario, our objective is to showcase a map that remains non-interactive, with a fixed center point at a predefined location and a constant zoom level. To achieve this desired effect, the following steps are involved:

1. Create an HTML container element in which the map can be rendered (for example, a `div`).
```scala
val mapContainer = dom.document.createElement("div").asInstanceOf[dom.HTMLElement]
```
2. Set the height and width of the container element.
```scala
mapContainer.style.height = "640px"
mapContainer.style.width = "500px"
```
3. Append the container element to the DOM.
```scala
containerNode.appendChild(mapContainer)
```
4. Instantiate an `H.Map` object, specifying:
   - the map container element
   - the map type to use eg. `maptypes.vector.normal.map`
   - the zoom level at which to display the map
   - the geographic coordinates of the point on which to center the map

```scala
val berlinMap = new H.Map(
    document.getElementById("mapContainer"),
    maptypes.vector.normal.map,
    MapOptions(zoom = 12, center = MapPoint(13.4, 52.51))
  )
```
## Waiting for the page to load
For the map to be rendered properly on the page, it is necessary to wait for the page to load completely. This can be achieved by using the `windowEvents` function from the `Laminar` library. The `windowEvents` function returns an `EventStream` that emits an event whenever the specified event occurs on the window object. In this case, the `onLoad` event is used to wait for the page to load completely.
```scala 
windowEvents(_.onLoad).foreach { _ =>
  // map initialization code goes here
}(unsafeWindowOwner)
```

## Complete code
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
  
  val platform = H.service.Platform(
    PlatformOptions(apikey = secretKey)
  )
  
  val maptypes = platform.createDefaultLayers()
  containerNode.appendChild(mapContainer)
  val berlinMap = new H.Map(
    document.getElementById("mapContainer"),
    maptypes.vector.normal.map,
    MapOptions(zoom = 12, center = MapPoint(13.4, 52.51))
  )
  
}(unsafeWindowOwner)

```

</div>

