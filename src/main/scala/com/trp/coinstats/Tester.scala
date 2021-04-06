package com.trp.coinstats

import com.trp.coinstats.client.CoinStatsClientImpl

object Tester {
  def main(args: Array[String]): Unit = {
    println("Hello world!")
    val client = new CoinStatsClientImpl(new CoinStatsAPI)
    //    println(client.getCoinsGlobalAvgPrices)
    //    val coins = client.getCoinsGlobalAvgPrices
    //    coins.get("coins").map(c => (c.foreach(cf => println((cf.name, cf.price)))))
    //    println(client.getCoinGlobalAvgPrices("bitcoin", "USD"))
//    println(client.getHistoricalGlobalAvgPriceChart("bitcoin", "1m"))
//    println(client.getExchanges)
    println(client.getMarketsByCoinId("bitcoin"))
  }
}
