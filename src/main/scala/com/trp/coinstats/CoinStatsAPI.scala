package com.trp.coinstats


import geny.Readable
import requests.Session


class CoinStatsAPI {
  def get(endpoint: String, params: Map[String,String]): Readable = {
    val apiURL = s"${CoinStatsAPI.baseUrl}/$endpoint"
    val session = Session()
    session.get(apiURL, params = params)
  }
}

object CoinStatsAPI {
  lazy val baseUrl = "https://api.coinstats.app/public/v1"
}