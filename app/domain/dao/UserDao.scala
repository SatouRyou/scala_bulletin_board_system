package domain.dao

import javax.inject.{Inject, Singleton}

import domain.entity.UserEntiry
import play.api.db.slick.DatabaseConfigProvider
import slick.driver.JdbcProfile

import scala.concurrent.Future

/**
  * Created by teradashoutarou on 2016/10/15.
  */
@Singleton
class UserDao @Inject()(val dbConfigProvider: DatabaseConfigProvider) {

  val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig.driver.api._

  // テーブル定義
  private class UserTable(tag: Tag) extends Table[UserEntiry](tag, "users") {

    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def text= column[String]("name")

    def * = (id.?, text) <> ((UserEntiry.apply _).tupled, UserEntiry.unapply)
  }

  private val messages = TableQuery[UserTable]

  def all(): Future[List[UserEntiry]] = dbConfig.db.run(messages.result).map(_.toList)
}
