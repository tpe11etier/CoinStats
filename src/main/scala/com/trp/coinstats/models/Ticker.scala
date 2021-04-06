package com.trp.coinstats.models

import com.trp.coinstats.utils.JSONPickler._

case class Ticker(
                 from: String,
                 to: String,
                 exchange: String,
                 price: Double
                 )

object Ticker {
  implicit val readsTicker: ReadWriter[Ticker] = macroRW[Ticker]
}