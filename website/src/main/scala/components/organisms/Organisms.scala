package components.organisms

import components.atoms.Atoms.{Avatar, Logo}
import components.molecules.Molecules.NavigationLinks

object Organisms {
  import com.raquo.laminar.api.L.*

  def Header(logoImageUrl: String, username: String,avatarUrl:String): HtmlElement = {
    headerTag(
      cls := "flex items-center justify-between p-6 lg:px-8",
      navTag(
        cls := "container mx-auto flex items-center justify-between",
        aria.label := "Main navigation",
        Logo(logoImageUrl),
        NavigationLinks,
        Avatar(avatarUrl,username)
      )
    )
  }

  def renderBody(content: HtmlElement): HtmlElement = {
    mainTag(
      cls := "container mx-auto px-4 lg:px-8",
      content
    )
  }
  
  def renderLeftSideBar(content: HtmlElement): HtmlElement = {
    div(
      cls := "flex flex-col w-64 h-screen bg-gray-100 border-r",
      content
    )
  }
  
  def renderCenter(content: HtmlElement): HtmlElement = {
    div(
      cls := "flex flex-col flex-grow bg-gray-200",
      content
    )
  }
  
  def renderRightSideBar(content: HtmlElement): HtmlElement = {
    div(
      cls := "flex flex-col w-64 h-screen bg-gray-100 border-l",
      content
    )
  }
  



}
