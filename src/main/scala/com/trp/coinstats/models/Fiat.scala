package com.trp.coinstats.models

import com.trp.coinstats.utils.JSONPickler._

case class Fiat(
                 name: String,
                 rate: Double,
                 symbol: String,
                 imageUrl: String
               )

object Fiat {
  implicit val readsFiat: ReadWriter[Fiat] = macroRW[Fiat]
}