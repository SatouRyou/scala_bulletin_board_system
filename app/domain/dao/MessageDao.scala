package domain.dao

import javax.inject.{Inject, Singleton}

import domain.entity.MessageEntity
import play.api.db.slick.DatabaseConfigProvider
import slick.driver.JdbcProfile

import scala.concurrent.Future

/**
  * Created by teradashoutarou on 2016/10/15.
  */
@Singleton
class MessageDao @Inject()(val dbConfigProvider: DatabaseConfigProvider) {

  val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig.driver.api._

  // テーブル定義
  private class MessageTable(tag: Tag) extends Table[MessageEntity](tag, "messages") {

    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def userid = column[Long]("userid")
    def text= column[String]("name")

    def * = (id.?, userid, text) <> ((MessageEntity.apply _).tupled, MessageEntity.unapply)
  }

  private val messages = TableQuery[MessageTable]

  def all(): Future[List[MessageEntity]] = dbConfig.db.run(messages.result).map(_.toList)
}
