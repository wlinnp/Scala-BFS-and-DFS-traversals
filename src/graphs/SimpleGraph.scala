package graphs
import scala.collection.mutable.ListBuffer

/**
  * @author Wai Phyo
  */
class SimpleGraph(val nodes:Int) {
  if (nodes < 1) {
    throw new IllegalArgumentException("number of nodes mut be at least 1")
  }
  val TAB_SEPARATOR: String = "\t==>\t"
  val LINE_SEPARATOR: String = "\n"
  val COMMA_SEPARATOR: String = ", "

  protected val _nodes: Int = nodes
  protected var _edges: Array[ListBuffer[Int]] = new Array[ListBuffer[Int]](_nodes)
  for (i <- 0 to (_edges.length - 1)) {
    _edges(i) = new ListBuffer()
  }
  def getNodes: Int = {
    _nodes
  }
  def getEdges: Array[ListBuffer[Int]] = {
    _edges
  }
  protected def inRange(nodes: Int): Boolean = {
    nodes > -1 && nodes < _nodes
  }
  def addEdge(from: Int, to: Int): Unit = {
    if (!inRange(from) || !inRange(to)) {
      throw new IllegalArgumentException("Invalid nodes")
    }
    _edges(from) += to
    _edges(to) += from
  }
  def getGraph: String = {
    val result: StringBuilder = new StringBuilder()
    for (a <- 0 to (_edges.length - 1)) {
      result ++= a + TAB_SEPARATOR
      for (eachDestination <- _edges(a)) {
        result ++= eachDestination + COMMA_SEPARATOR
      }
      result ++= LINE_SEPARATOR
    }
    result.toString()
  }
}
