object Join extends App{

  val strArray = Array(
    "1, 3, 4, 7, 13",
    "1, 2, 4, 13, 15").toList

  val maps = strArray.map(m => m.split(",").map(x => x.trim.toInt -> x.trim.toInt).toMap)
  val left = maps(0)
  val right = maps(1)

  def join(leftMap:Map[Int, Int], rightMap:Map[Int,Int]) = {

    // use the list intersect
    val keys = leftMap.keys.toList.intersect(rightMap.keySet.toList).toSet
    leftMap.view.filterKeys(keys).toMap ++ rightMap.view.filterKeys(keys).toMap
  }

  def crossJoin(leftMap:Map[Int, Int], rightMap:Map[Int,Int]) = {

    // just combine all the keys operation so is distinct
    val keys = leftMap.keySet ++ rightMap.keySet
    leftMap.view.filterKeys(keys).toMap ++ rightMap.view.filterKeys(keys).toMap
  }

  val joined = join(left, right)
  println(joined.values.mkString(","))

  val crossJoined = crossJoin(left, right)
  println(crossJoined.values.mkString(","))
}
