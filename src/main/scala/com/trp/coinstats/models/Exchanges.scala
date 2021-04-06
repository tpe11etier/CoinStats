package com.trp.coinstats.models

import com.trp.coinstats.utils.JSONPickler._

case class Exchanges(
                      supportedExchanges: List[String]
                    )

object Exchanges {
  implicit val readsExchanges: ReadWriter[Exchanges] = macroRW[Exchanges]
}