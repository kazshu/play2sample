package controllers

import play.api.mvc._


object Books extends Controller {
  def index = Action {
    val list = List("lemon", "orange", "apple")
    Ok(views.html.books.index("hogeeeeeeee!!!", list))
  }
}
