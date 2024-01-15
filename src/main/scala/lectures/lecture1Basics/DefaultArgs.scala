/* @author Larissa Gomes
 * @version 0.1
 * @date 2024-01-12
 */
package lectures.lecture1Basics

object DefaultArgs extends App {

  def trFact(x: Int, accumulator: Int = 1): Int = {
    if (x <= 1) accumulator
    else trFact(x - 1, x * accumulator)
  }

  val fact10 = trFact(5)
  println(fact10)

  def savePicture(format: String = "jpg", width: Int = 1080, height: Int = 1920): Unit = println("Saving Picture...")

  savePicture(width = 840)
}
