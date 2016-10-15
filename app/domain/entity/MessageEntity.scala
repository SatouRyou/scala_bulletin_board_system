package domain.entity

import play.api.libs.json.Json

/**
  * Created by teradashoutarou on 2016/10/15.
  */
case class MessageEntity (id: Option[Long], userId: Option[Long], text: String)

object MessageEntity {
  implicit val messageWrites = Json.writes[MessageEntity]
  implicit val messageReads = Json.reads[MessageEntity]
}