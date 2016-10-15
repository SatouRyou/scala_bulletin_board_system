package controllers

import javax.inject.Inject

import domain.dao.{MessageDao, UserDao}
import play.api.mvc._
import play.api.libs.json._

import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by teradashoutarou on 2016/10/15.
  */
class BulletinController @Inject() (userDao: UserDao, messageDao: MessageDao) extends Controller {

  // APIの処理を書き直し
  def user = Action.async {
    userDao.all().map(messages => Ok(Json.toJson(Json.toJson(messages))))
  }

  // APIの処理を書き直し
  def message = Action.async {
    messageDao.all().map(messages => Ok(Json.toJson(Json.toJson(messages))))
  }
}
