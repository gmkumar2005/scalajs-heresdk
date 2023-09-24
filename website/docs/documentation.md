---
title: Documentation
---

* [Introduction](#introduction)
* [Dependencies](#dependencies)
* [Imports](#imports)





## Introduction

This documentation300 is for Laminar version **v16.0.0**. For other versions, see below. 


For documentation of older versions, see git tags.

 

Laminar is very simple under the hood. Don't be afraid to use "Go to definition" functionality of your IDE to see how a certain method works. That said, the documentation provided here explains the mechanics of Laminar in great detail. Documentation sections progress from basic to advanced, so each next section usually assumes that you've read all previous sections.

If you're new here, watching  will be time well spent – it's a good introduction to Laminar, covering both the big ideas and some inner workings.

See also:  
If you want to follow along with an IDE, download one of the starter kit projects from the  page, or learn how to render your app in the  section below.



## Dependencies

Add Laminar to `libraryDependencies` of your Scala.js project in `build.sbt`:

    "com.raquo" %%% "laminar" % "16.0.0"  // Requires Scala.js 1.13.2+

Laminar depends on Airstream. Every Laminar version includes the latest version of Airstream that was available at the time it was published. If you ever have a reason to use a slightly newer version of Airstream without upgrading Laminar, add this to your `build.sbt` as well:

    "com.raquo" %%% "airstream" % "<version>"

As you can see, Laminar and Airstream versions can diverge slightly, so don't use a single `LaminarVersion` variable for both.

The html/svg tags, attributes, props, styles, and event names in Laminar come from   If there's a missing prop, consider contributing it there.

Laminar also uses  As it is a very thin interface to native JS types, you can generally use a higher version of scala-js-dom than what Laminar uses without any issue.



## Imports

You have two import choices: `import com.raquo.laminar.api.L.{*, given}` (or `L._` in Scala 2) is the easiest, it brings everything you need from Laminar in scope. Unless indicated otherwise, this import is assumed for all code snippets in this documentation.

Usually you will not need any other Laminar imports. In this documentation you will occasionally see references to some Laminar types and values that are not available with just this one import because we spell out the types for the sake of explanation. Most of those are available as aliases in the `L` object. For example, `ReactiveHtmlElement[dom.html.Element]` is aliased as simply `HtmlElement`, and `Modifier[El]` as `Mod[El]`.

Alternatively, you might want to avoid bringing so many values into scope, so instead you can `import com.raquo.laminar.api.{*, given}` (or `api._` in Scala 2), and access Laminar and Airstream values and types with `L` and `A` prefixes respectively, e.g. `A.EventStream`, `L.div`, etc.`

There are special import considerations for working with  

Do check out the available aliases in the `L` object. It's much more pleasant to write and read `Mod[Input]` than `Modifier[ReactiveHtmlElement[dom.html.Input]]`.

Another import you will want in some cases is `import org.scalajs.dom` – whenever you see `dom.X` in documentation, this import is assumed. This object contains [scala-js-dom](https://github.com/scala-js/scala-js-dom) native JS DOM types. I highly recommend that you import this `dom` object and not `dom.*` or `dom._` because the `dom.` prefix will help you distinguish native JS platform types from Laminar types.
