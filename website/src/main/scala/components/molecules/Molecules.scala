package components.molecules
import com.raquo.laminar.api.L._
object Molecules {
  def NavigationLinks: HtmlElement=  {
    div(cls := "hidden lg:flex lg:gap-x-12", idAttr := "Menu",
      a(href := "#", cls := "text-sm font-semibold leading-6 text-gray-900", "Product"),
      a(href := "#", cls := "text-sm font-semibold leading-6 text-gray-900", "Features"),
      a(href := "#", cls := "text-sm font-semibold leading-6 text-gray-900", "Marketplace"),
      a(href := "#", cls := "text-sm font-semibold leading-6 text-gray-900", "Company")
    )
    }

}
