---
title: Calculating a Location from a Mouse Click 
---


<div class = "mdoc-example">
//TODO

```scala mdoc:js
import org.scalajs.dom
import com.raquo.laminar.api.L.{*, given}

val nameVar = Var(initial = "world")

val rootElement = div(
  label("Your name: "),
  input(
    onMountFocus,
    placeholder := "Enter your name here",
    onInput.mapToValue --> nameVar
  ),
  span(
    "Hello, ",
    child.text <-- nameVar.signal.map(_.toUpperCase)
  )
)

// In most other examples, containerNode will be set to this behind the scenes
val containerNode = dom.document.querySelector("#mdoc-html-run0")

render(containerNode, rootElement)
```

</div>
