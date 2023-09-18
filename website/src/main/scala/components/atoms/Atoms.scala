package components.atoms

object Atoms {
  import com.raquo.laminar.api.L._
  def Avatar(imageUrl: String, username: String): HtmlElement = {
    div(cls := "hidden lg:flex lg:flex-1 lg:justify-end", idAttr := "Avatar",
      a(href := "#", cls := "text-sm font-semibold leading-6 text-gray-900", "Log in",
        span(dataAttr("aria-hidden") := "true", "→")
      )
    )
  }

  import com.raquo.laminar.api.L._

  def Logo(logoImageUrl: String): HtmlElement = {
    div(cls := "flex lg:flex-1", idAttr := "logo",
      a(href := "#", cls := "-m-1.5 p-1.5",
        span(cls := "sr-only", "Your Company"),
        img(cls := "h-8 w-auto", src := logoImageUrl, alt := "Logo of the company")
      )
    )
  }

  def renderAttribution(): Element = {
    footerTag(
      role := "contentinfo",
      className := "absolute inset-x-0 bottom-0 attribution",
      p(cls := "mt-5 text-center text-sm leading-6 text-slate-500",
        "© 2023 gmkumar2005. All rights reserved."),
    )
  }

}
