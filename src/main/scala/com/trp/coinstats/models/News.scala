package com.trp.coinstats.models

import com.trp.coinstats.utils.JSONPickler._

case class News(
                 id: String,
                 feedDate: Int,
                 source: String,
                 title: String,
                 isFeatured: Option[Boolean] = Some(false),
                 description: String,
                 imgURL: String,
                 link: String,
                 sourceLink: String,
                 reactionsCount: Option[Map[String, Int]] = None,
                 shareURL: String,
                 relatedCoins: Option[List[String]] = None
               )

object News {
  implicit val readsNews: ReadWriter[News] = macroRW[News]
}