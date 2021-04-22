package com.trp.coinstats

import com.trp.coinstats.client.CoinStatsClientImpl
import com.trp.coinstats.utils.PPrintUtils

object Tester {
  def main(args: Array[String]): Unit = {
    println("Hello world!")
    val client = new CoinStatsClientImpl(new CoinStatsAPI)
        println(client.getCoinsGlobalAvgPrices)
    //    val coins = client.getCoinsGlobalAvgPrices
    //    coins.get("coins").map(c => (c.foreach(cf => println((cf.name, cf.price)))))
    //    println(client.getCoinGlobalAvgPrices("bitcoin", "USD"))
    //    println(client.getHistoricalGlobalAvgPriceChart("bitcoin", "1m"))
    //    println(client.getExchanges)
    //    println(client.getMarketsByCoinId("bitcoin"))
    //    println(client.getTickersByExchangePair("kraken", "BTC-USD"))
    //    println(client.getFiats)
    val news = client.getNews
    val title, link =  news.values.foreach(x => x.map(n => PPrintUtils.pprint2.pprintln(n)))
//    val news = client.getNews
//news.map(_._2).foreach(x => x.map(n => println(n.title, n.link)))
  }
}
