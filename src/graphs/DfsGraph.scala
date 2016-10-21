package graphs

/**
  * @author Wai Phyo
  */
class DfsGraph(override val nodes:Int) extends SimpleGraph (nodes) {
  private def dfsUtil(start: Int, visited: Array[Boolean]): StringBuilder = {
    val result: StringBuilder = new StringBuilder()
    if (!visited(start)) {
      visited(start) = true
      result ++= start + TAB_SEPARATOR
      for (eachDestination <- _edges(start)) {
        result ++= dfsUtil(eachDestination, visited)
      }
    }
    result
  }
  private def dfs(start: Int): String = {
    if (!inRange(start)) {
      throw new IllegalArgumentException("Invalid Start position.")
    }
    val visited: Array[Boolean] =  Array.fill[Boolean](_nodes)(false)
    dfsUtil(start, visited).toString()
  }

  override def traverse(start: Int): String = {
    dfs(start)
  }
}
