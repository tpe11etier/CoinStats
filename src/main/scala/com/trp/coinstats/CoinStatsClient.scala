package com.trp.coinstats

import com.trp.coinstats.models.{Coin, Coins, Exchanges, Market}

trait CoinStatsClient {
  def getCoinsGlobalAvgPrices: Coins

  def getCoinsGlobalAvgPrices(skip: Option[Int], limit: Option[Int], currency: Option[String]): Coins

  def getCoinGlobalAvgPrices(coinId: String, currency: String): Map[String, Coin]

  def getHistoricalGlobalAvgPriceChart(coinId: String, period: String): Map[String,List[(Long,Double,Double,Int)]]

  def getExchanges: Exchanges

  def getMarketsByCoinId(coinId: String): List[Market]

  def getTickersByExchangePair(exchange: String, pair: String):
}
