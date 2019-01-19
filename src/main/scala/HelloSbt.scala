import java.time.{LocalDate,Month}
import java.time.{LocalDate, Month}



object HelloSbt extends App {
  println("Sbt says Hello!!")

  val t1 = Task("Write blog on SBT", LocalDate.of(2016,Month.JANUARY,10), Seq("blogging"))
  println("Task created: " + t1)

}



