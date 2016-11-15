import graphs.{SimpleGraph, BfsGraph, DfsGraph}

import scala.io.StdIn

/**
  * @author Wai Phyo
  */
object Main {
  def main(args: Array[String]): Unit = {
    println("Test Runs")
    testBfsDfs()
    println("BFS Trasversal & DFS Trasversal")
    println("===============================")
    var loopControl: Boolean = true
    while(loopControl) {
      printMainMenu()
      StdIn.readInt() match {
        case 1 => bfs()
        case 2 => dfs()
        case 0 => loopControl = false
      }
    }
  }

  private def testBfsDfs(): Unit = {
    val bfsGraph = new BfsGraph(10)
    bfsGraph.addEdge(0, 3)
    bfsGraph.addEdge(5, 4)
    bfsGraph.addEdge(4, 5)
    bfsGraph.addEdge(6, 7)
    bfsGraph.addEdge(1, 4)
    bfsGraph.addEdge(2, 5)
    bfsGraph.addEdge(3, 6)
    bfsGraph.addEdge(4, 7)
    bfsGraph.addEdge(5, 8)
    bfsGraph.addEdge(6, 9)
    bfsGraph.addEdge(7, 8)
    bfsGraph.addEdge(8, 8)
    bfsGraph.addEdge(9, 2)
    println(bfsGraph.getGraph)
    println(bfsGraph.traverse(0))
    val dfsGraph = new DfsGraph(10)
    dfsGraph.addEdge(0, 3)
    dfsGraph.addEdge(5, 4)
    dfsGraph.addEdge(4, 5)
    dfsGraph.addEdge(6, 7)
    dfsGraph.addEdge(1, 4)
    dfsGraph.addEdge(2, 5)
    dfsGraph.addEdge(3, 6)
    dfsGraph.addEdge(4, 7)
    dfsGraph.addEdge(5, 8)
    dfsGraph.addEdge(6, 9)
    dfsGraph.addEdge(7, 8)
    dfsGraph.addEdge(8, 8)
    dfsGraph.addEdge(9, 2)
    dfsGraph.traverse(0)
    println(dfsGraph.getGraph)
    println(dfsGraph.traverse(0))
  }

  private def printMainMenu(): Unit = {
    println("Enter 1 for BFS")
    println("Enter 2 for DFS")
    println("Enter 0 to exit")
  }

  private def bfs(): Unit = {
    val graph = new BfsGraph(inputNodes())
    graphDetails(graph)
  }

  private def dfs(): Unit = {
    val graph = new DfsGraph(inputNodes())
    graphDetails(graph)
  }

  private def inputNodes(): Int = {
    println("Enter total number of nodes")
    StdIn.readInt()
  }

  private def graphDetails(graph: SimpleGraph): Unit = {
    println(s"Graph's nodes will be from 0 to ${graph.getNodes - 1}")
    var loopControl: Boolean = true
    while(loopControl) {
      graphMenu()
      StdIn.readInt() match {
        case 1 => addEdge(graph)
        case 2 => println(graph.getGraph)
        case 3 => println(graph.traverse(getStartNode))
        case 0 => loopControl = false
      }
    }
  }

  private def graphMenu(): Unit = {
    println("Enter 1 to add edges.")
    println("Enter 2 to view graph.")
    println("Enter 3 to traversal.")
    println("Enter 0 to quit.")
  }

  private def addEdge(graph: SimpleGraph) = {
    println("Enter source node.")
    val from = StdIn.readInt()
    println("Enter destination node.")
    graph.addEdge(from, StdIn.readInt())
  }

  private def getStartNode: Int = {
    println("Enter the starting node for the traversal")
    StdIn.readInt()
  }
}
