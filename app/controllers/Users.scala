package controllers

import play.api.data._
import play.api.data.Forms._
import play.api.mvc._
import models._

object Users extends Controller {

  val userForm = Form(
    mapping(
      "name" -> nonEmptyText,
      "email" -> email,
      "age" -> number)(User.apply)(User.unapply))

  def entryInit = Action {
    val filledForm = userForm.fill(User("user name", "email address", 21))
    Ok(views.html.users.entry(filledForm))
  }

  def entrySubmit = Action { implicit request =>
    userForm.bindFromRequest.fold(
      errors => {
        println("error!!!!!!!")
        BadRequest(views.html.users.entry(errors))
      },
      success => {
        println("entry success!!!!!!!!!")
        Ok(views.html.users.entrySubmit())
      }
    )
  }

}
