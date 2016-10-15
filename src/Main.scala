import graphs.{SimpleGraph, BfsGraph, DfsGraph}

import scala.io.StdIn

/**
  * @author Wai Phyo
  */
object Main {
  def main(args: Array[String]): Unit = {
    val myGraph = new SimpleGraph(10)
    myGraph.addEdge(0, 3)
    myGraph.addEdge(5, 4)
    myGraph.addEdge(4, 5)
    myGraph.addEdge(6, 7)
    myGraph.addEdge(1, 4)
    myGraph.addEdge(2, 5)
    myGraph.addEdge(3, 6)
    myGraph.addEdge(4, 7)
    myGraph.addEdge(5, 8)
    myGraph.addEdge(6, 9)
    myGraph.addEdge(7, 8)
    myGraph.addEdge(8, 8)
    myGraph.addEdge(9, 2)
    println(myGraph.getGraph)
    //println(myGraph.dfs(0))
    myGraph.asInstanceOf[BfsGraph].bfs(getStartNode)
    println("BFS Trasversal & DFS Trasversal")
    println("===============================")
    var graph = graphDetails()
    var loopControl: Boolean = true
    while(loopControl) {
      printMainMenu()
      StdIn.readInt() match {
        case 1 => graph.getGraph
        case 2 => bfsTraversals(graph)
        case 3 => dfsTraversals(graph)
        case 4 => graph = graphDetails()
        case 0 => loopControl = false
      }
    }
  }

  private def printMainMenu(): Unit = {
    println("Enter 1 to view graph details.")
    println("Enter 2 to view BFS")
    println("Enter 3 to view DFS")
    println("Enter 4 for new graph")
    println("Enter 0 to exit")
  }

  private def graphDetails(): SimpleGraph = {
    println("Enter total number of nodes")
    val nodes = StdIn.readInt()
    println(s"Graph's nodes will be from 0 to ${nodes - 1}")
    val graph = new SimpleGraph(nodes)
    println("Let's add some nodes.")
    var addingNode = true
    while (addingNode) {
      println("Enter source node.")
      val from = StdIn.readInt()
      println("Enter destination node.")
      graph.addEdge(from, StdIn.readInt())
      println("Are you done? Y or N")
      if (StdIn.readChar() == 'Y') {
        addingNode = false
      }
    }
    graph
  }

  private def getStartNode: Int = {
    println("Enter the starting node for the traversal")
    StdIn.readInt()
  }

  private def bfsTraversals(graph: SimpleGraph): Unit = {
    val bfsGraph: BfsGraph = graph.asInstanceOf[BfsGraph]
    println(bfsGraph.bfs(getStartNode))
  }

  private def dfsTraversals(graph: SimpleGraph): Unit = {
    val dfsGraph: DfsGraph = graph.asInstanceOf[DfsGraph]
    println(dfsGraph.dfs(getStartNode))
  }


}
