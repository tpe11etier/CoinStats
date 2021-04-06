package com.trp.coinstats.models

import com.trp.coinstats.utils.JSONPickler._

case class Coins(
                  coins: List[Coin]
                )

case class Coin(
                 id: String,
                 icon: String,
                 name: String,
                 symbol: String,
                 rank: Int,
                 price: Double,
                 priceBtc: Double,
                 volume: Double,
                 marketCap: Int,
                 availableSupply: Int,
                 totalSupply: Int,
                 priceChange1h: Double,
                 priceChange1d: Double,
                 priceChange1w: Double,
                 websiteUrl: Option[String] = None,
                 redditUrl: Option[String] = None,
                 twitterUrl: Option[String] = None,
                 exp: List[String]
               )

object Coins {
  implicit val readsCoins: ReadWriter[Coins] = macroRW[Coins]
}

object Coin {
  implicit val readsCoin: ReadWriter[Coin] = macroRW[Coin]

}