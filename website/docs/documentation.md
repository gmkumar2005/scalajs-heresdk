---
title: Documentation
---

HereSdk.Scala.js is an unofficial Scala.js binding for the HERE Maps API for JavaScript. It provides Scala developers with a seamless integration to leverage the powerful HERE Maps services within their Scala.js applications. This documentation aims to guide you through the usage of.

* [Introduction](#introduction)
* [Imports](#imports)
* [Dependencies](#dependencies)


 
## Introduction

HERE Technologies is renowned for its mapping and location-based services, and the HERE Maps API for JavaScript offers a wide range of features for mapping, geolocation, routing, and more. HereSdk.Scala.js bridges the gap between Scala.js and the HERE Maps API, allowing Scala developers to harness the full potential of HERE Maps in their web applications.

Key highlights of HereSdk.Scala.js:

- Provides type-safe Scala bindings for the HERE Maps API.
- Seamlessly integrates with Scala.js 1.x and Scala 3.
- Compatible with the latest version of the HERE Maps API for JavaScript.
- Simplifies the development of location-aware web applications.

## Imports
you need to import the necessary Scala.js modules and classes into your project. Here are the typical imports you'll need:
```scala
import here.maps.{MapOptions, MapPoint, PlatformOptions, MapsJs as H}
import org.scalajs.dom
import org.scalajs.dom.document
import scala.scalajs.js.Dynamic.global as g

```
## Dependencies

Add Laminar to `libraryDependencies` of your Scala.js project in `build.sbt`:
```scala
"com.raquo" %%% "laminar" % "16.0.0"  // Requires Scala.js 1.13.2+
"org.scala-js" %%% "scalajs-dom" % "1.2.0"
```
Before you begin, ensure you have the following prerequisites in place
    
1. Scala.js 1.x: HereSdk.Scala.js depends on Scala.js version 1.x, so make sure you have Scala.js set up in your project. 
    
2. Scala 3: Ensure you have Scala 3 installed on your system. 
    
3. HERE Developer Account: You'll need a HERE Developer account to obtain API credentials. Sign up for one at  [HERE Developer Portal.](https://platform.here.com/sign-up) Here offers a **`Generous free tier`**
