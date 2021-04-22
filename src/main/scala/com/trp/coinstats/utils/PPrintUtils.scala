package com.trp.coinstats.utils

import pprint.{PPrinter, Tree, Util}


object PPrintUtils {
  // in scala 2.13 this would be even simpler/cleaner due to added product.productElementNames
  protected def caseClassToMap(cc: Product): Map[String, Any] = {
    val fieldValues = cc.productIterator.toSet
    val fields = cc.getClass.getDeclaredFields.toSeq
      .filterNot(f => f.isSynthetic || java.lang.reflect.Modifier.isStatic(f.getModifiers))
    fields.map { f =>
      f.setAccessible(true)
      f.getName -> f.get(cc)
    }.filter { case (k, v) => fieldValues.contains(v) }
      .toMap
  }

  var pprint2: PPrinter = _

  protected def pprintAdditionalHandlers: PartialFunction[Any, Tree] = {
    case x: Product =>
      val className = x.getClass.getName
      // see source code for pprint.treeify()
      val shouldNotPrettifyCaseClass = x.productArity == 0 || (x.productArity == 2 && Util.isOperator(x.productPrefix)) || className.startsWith(pprint.tuplePrefix) || className == "scala.Some"

      if (shouldNotPrettifyCaseClass)
        pprint.treeify(x)
      else {
        val fieldMap = caseClassToMap(x)
        pprint.Tree.Apply(
          x.productPrefix,
          fieldMap.iterator.flatMap { case (k, v) =>
            val prettyValue: Tree = pprintAdditionalHandlers.lift(v).getOrElse(pprint2.treeify(v))
            Seq(pprint.Tree.Infix(Tree.Literal(k), "=", prettyValue))
          }
        )
      }
  }

  pprint2 = pprint.copy(additionalHandlers = pprintAdditionalHandlers)
}

