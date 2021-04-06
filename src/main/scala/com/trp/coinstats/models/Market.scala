package com.trp.coinstats.models

import com.trp.coinstats.utils.JSONPickler._

case class Market(
                   price: Double,
                   exchange: String,
                   pair: String,
                   volume: Double
                 )

object Market {
  implicit val readsMarket: ReadWriter[Market] = macroRW[Market]
}