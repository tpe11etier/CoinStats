package com.trp.coinstats.utils

object JSONPickler extends upickle.AttributeTagged {
  override implicit def OptionWriter[T: Writer]: Writer[Option[T]] =
    implicitly[Writer[Option[T]]].comap[Option[T]] {
      case None => null.asInstanceOf[Option[T]]
      case Some(x) => Some(x)
    }

  override implicit def OptionReader[T: Reader]: Reader[Option[T]] = {
    new Reader.Delegate[Any, Option[T]](implicitly[Reader[T]].map(Some(_))) {
      override def visitNull(index: Int) = None
    }
  }
}

