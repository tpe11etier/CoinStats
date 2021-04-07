package com.trp.coinstats.client

import com.trp.coinstats.models.{Coin, Coins, Exchanges, Fiat, Market, Ticker}
import com.trp.coinstats.{CoinStatsAPI, CoinStatsClient}
import com.trp.coinstats.utils.JSONPickler._

class CoinStatsClientImpl(api: CoinStatsAPI) extends CoinStatsClient {
  def get[T: Reader](endpoint: String, params: Map[String, String]): T =
    api.get(endpoint, params) match {
      case json => read[T](json)
    }

  override def getCoinsGlobalAvgPrices: Coins = {
    getCoinsGlobalAvgPrices(None, None, None)
  }

  override def getCoinsGlobalAvgPrices(skip: Option[Int],
                                       limit: Option[Int],
                                       currency: Option[String]): Coins = {
    def buildQuery: Map[String, String] =
      Map(
        "skip" -> skip.map(_.toString),
        "limit" -> limit.map(_.toString),
        "currency" -> currency
      ).filter(kv => kv._2.nonEmpty)
        .map(kv => kv._1 -> kv._2.getOrElse(""))

    get[Coins](endpoint = "coins", buildQuery)
  }

  override def getCoinGlobalAvgPrices(coinId: String, currency: String): Map[String, Coin] = {
    def buildQuery =
      Map(
        "currency" -> currency
      )

    get[Map[String, Coin]](endpoint = s"coins/${coinId}", buildQuery)
  }

  override def getHistoricalGlobalAvgPriceChart(coinId: String, period: String): Map[String, List[(Long, Double, Double, Int)]] = {
    def buildQuery =
      Map(
        "coinId" -> coinId,
        "period" -> period
      )

    get[Map[String, List[(Long, Double, Double, Int)]]](endpoint = "charts", buildQuery)
  }

  override def getExchanges: Exchanges = {
    get[Exchanges](endpoint = "exchanges", Map())
  }

  override def getMarketsByCoinId(coinId: String): List[Market] = {
    def buildQuery =
      Map(
        "coinId" -> coinId
      )

    get[List[Market]](endpoint = "markets", buildQuery)
  }

  override def getTickersByExchangePair(exchange: String, pair: String): Map[String,List[Ticker]] = {
    def buildQuery = {
      Map(
        "exchange" -> exchange,
        "pair" -> pair
      )
    }
      get[Map[String, List[Ticker]]](endpoint = "tickers", buildQuery)

  }

  override def getFiats: List[Fiat] = ???
}
