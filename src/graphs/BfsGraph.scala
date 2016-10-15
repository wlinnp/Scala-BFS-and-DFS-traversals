package graphs

import scala.collection.mutable.ListBuffer

/**
  * @author Wai Phyo
  */
class BfsGraph(override val nodes:Int) extends SimpleGraph (nodes) {
  def bfs(start: Int): String = {
    if (!inRange(start)) {
      throw new IllegalArgumentException("Invalid Start position.")
    }
    val result: StringBuilder = new StringBuilder()
    val visited: Array[Boolean] =  Array.fill[Boolean](_nodes)(false)
    val graphQueue: ListBuffer[Int] = new ListBuffer[Int]()

    result ++= start + TAB_SEPARATOR
    visited(start) = true
    graphQueue += start

    while (!graphQueue.isEmpty) {
      val current: Int = graphQueue(0)
      for (eachDestination <- _edges(current)) {
        if (!visited(eachDestination)) {
          result ++= eachDestination + TAB_SEPARATOR
          visited(eachDestination) = true
          graphQueue += eachDestination
        }
      }
      graphQueue.remove(0)
    }
    result.toString()
  }
}
