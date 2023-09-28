---
title: Map at a specified location
---
## Introduction
The use case involves developing an application that presents a static, non-interactive map by default.
In this particular scenario, our objective is to showcase a map that remains non-interactive, with a fixed center point at a predefined location and a constant zoom level.

This implementation uses `scalajs` with `Laminar` code to display the map in an HTML page.
To achieve this desired effect, the following steps are involved.

### Viewport meta-tag
To ensure optimum performance on mobile devices, add the following meta-tag to the <head> section of the HTML page:
```html
<meta name="viewport" content="initial-scale=1.0, width=device-width" />
```
### Imports
You need to import the necessary `Scala.js` modules and classes into your project. Here are the typical imports you'll need:
```scala
import com.raquo.laminar.api.L.{*, given}
import here.maps.{MapOptions, MapPoint, MapTypes, PlatformOptions, MapsJs as H}
import org.scalajs.dom.document
```
### Step 1. Obtain the platform apikey you received on registration.
In your own code, replace variable `_secretKey` with your own apikey. Follow the best practices to store your apikey in a secure location.
```scala
val _secretKey = website.Secrets.hereApiKey
```
### Step 2. Create a container which will be used to display the map.
```scala
val demoContainer =
   div(idAttr := "demoContainer", height := "460px", width := "640px")
```

### Step 3. Render the container on the page.
Laminar's `renderOnDomContentLoaded` function is used to render the application in response to the browser firing the DOMContentLoaded event.
```scala
renderOnDomContentLoaded(
   containerNode,
   demoContainer
)
```

A crucial aspect of crafting a functional application involves establishing seamless communication with the backend services offered by HERE REST APIs.
In our particular scenario, these backend services diligently handle requests for map data, ensuring its prompt retrieval and subsequent presentation within the application.

Initiate the process by creating a Platform object, an integral component of your application's architecture.
To set up this Platform object, you will need to provide the `Unique API key` that you received upon registration. This API key serves as your secure access pass to unlock the full capabilities, enabling your application to interact with a wide range of location-based services and functionalities.

### Step 4. Create a PlatformOptions object, specifying the API key.
```scala
val platform = H.service.Platform(
    PlatformOptions(apikey = secretKey)
  )
val mapTypes: MapTypes = platform.createDefaultLayers()
```

This object offers a suite of methods that simplify the creation of comprehensive service stubs.
These stubs are essentially functional placeholders for essential services, including map tile service stubs, routing service stubs, and more.
They serve as the building blocks upon which you can construct and integrate various location-based functionalities into your application effortlessly.

### Step 5. Initialize a map - this map is centered over Berlin.
Instantiate an `H.Map` object, specifying:
- the map container element `demoContainer.ref`. `ref` is a reference to the underlying DOM element.
- the map type to use eg. `maptypes.vector.normal.map`
- the zoom level at which to display the map eg. `zoom = 10`
- the geographic coordinates of the point on which to center the map

```scala
val berlinMap = new H.Map(
   demoContainer.ref,
   mapTypes.vector.normal.map,
   MapOptions(center = MapPoint(13.4, 52.5), zoom = 10)
)
```
### Step 6. Waiting for the page to load
For the map to be rendered properly on the page, it is necessary to wait for the page to load completely.
This can be achieved by using the `windowEvents` function from the `Laminar` library.
The `windowEvents` function returns an `EventStream` that emits an event whenever the specified event occurs on the window object.
In this case, the `onLoad` event is used to wait for the page to load completely.
Add a resize listener to make sure that the map occupies the whole container `onLoad`
```scala 
windowEvents(_.onLoad).foreach { _ =>
   berlinMap.getViewPort().resize()
}(unsafeWindowOwner)
```
### Step 7. Watch for resize events
Add a resize listener to make sure that the map occupies the whole container `onResize`
```scala 
windowEvents(_.onResize).foreach { _ =>
   berlinMap.getViewPort().resize()
}(unsafeWindowOwner)
```

### Step 8. Make the map interactive
MapEvents enables the event system.Behavior implements default interactions for pan/zoom (also on mobile touch environments)
```scala
val behavior = new H.mapevents.Behavior(new H.mapevents.MapEvents(berlinMap))
```

### Step 9. Create the default UI components 
Default UI components  allow the user to interact with them. The interactive components will be visible only with mapjs-ui.css. 
See html changes needed in html tab.

<!--DOCUSAURUS_CODE_TABS-->
<!--ScalaJS-->
```scala 
val ui: Unit = H.ui.UI.createDefault(berlinMap, mapTypes) 
```
<!--HTML-->
**Hint:** Add the following link tag to the <head> section of the HTML page to load the default UI components. Or follow the process used by the respective css framework to load the css file.
```html
<link rel="stylesheet" type="text/css" href="https://js.api.here.com/v3/3.1/mapsjs-ui.css" />
```
<!--END_DOCUSAURUS_CODE_TABS-->

### Step 10. Move the map to display desired location 
Setup the center and appropriate zoom level.

```scala
berlinMap.setCenter(MapPoint(82.194298, 26.795601))
berlinMap.setZoom(14)
```
## Complete code and Live demo
<div class="mdoc-example">

```scala mdoc:js
import com.raquo.laminar.api.L.{*, given}
import here.maps.{MapOptions, MapPoint, MapTypes, PlatformOptions, MapsJs as H}
import org.scalajs.dom.document

// Step 1. Obtain the platform apikey
// In your own code, replace variable window.apikey with your own apikey
val _secretKey = website.Secrets.hereApiKey

// Step 2. Create a container which will be used to display the map.
val demoContainer =
   div(idAttr := "demoContainer", height := "460px", width := "640px")
// Step 3. Render the container on the page
renderOnDomContentLoaded(
   containerNode,
   demoContainer
)

// Step 4. initialize communication with the platform
val platform = H.service.Platform(
   PlatformOptions(
      apikey = _secretKey
   )
)
val mapTypes: MapTypes = platform.createDefaultLayers()
// Step 5. Initialize a map - this map is centered over Berlin
val berlinMap = new H.Map(
   demoContainer.ref,
   mapTypes.vector.normal.map,
   MapOptions(center = MapPoint(13.4, 52.5), zoom = 10)
)

// Step 6. Add a resize listener to make sure 
// that the map occupies the whole container onLoad
windowEvents(_.onLoad).foreach { _ =>
   berlinMap.getViewPort().resize()
}(unsafeWindowOwner)

// Step 7. Add a resize listener to make sure 
// that the map occupies the whole container onResize
windowEvents(_.onResize).foreach { _ =>
   berlinMap.getViewPort().resize()
}(unsafeWindowOwner)
// Step 8. Make the map interactive
// MapEvents enables the event system
// Behavior implements default interactions for pan/zoom (also on mobile touch environments)
val behavior = new H.mapevents.Behavior(new H.mapevents.MapEvents(berlinMap))

// Step 9. Create the default UI components to allow the user to interact with them
val ui: Unit = H.ui.UI.createDefault(berlinMap, mapTypes) 

// Step 10 Moves the map to display over Ram Mandir, Ayodhya
berlinMap.setCenter(MapPoint(82.194298, 26.795601))
berlinMap.setZoom(14)
```

</div>

