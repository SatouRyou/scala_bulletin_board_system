package domain.entity

import play.api.libs.json.Json

/**
  * Created by teradashoutarou on 2016/10/15.
  */
case class UserEntiry (id: Option[Long], name: String)

object UserEntiry {
  implicit val messageWrites = Json.writes[UserEntiry]
  implicit val messageReads = Json.reads[UserEntiry]
}

