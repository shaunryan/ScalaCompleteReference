object Intersect extends App {

  val strArray = Array("1, 3, 4, 7, 13", "1, 2, 4, 13, 15")
  val lists = strArray.map(i => i.split(",").map(_.trim.toInt))
  val join = lists(0).intersect(lists(1)).sorted

  print(join.mkString(", "))

}
