/* @author Larissa Gomes
 * @version 0.1
 * @date 2024-01-20
 */

package lectures.lecture2OOP

object Enums extends App {

  enum Permission {
    case READ, WRITE, EXECUTE, NONE

    def openDocument(): Unit = {
      if(this == READ) println("Opening document...")
      else println("Reading not allowed.")
    }
  }

  val somePermission = Permission.READ
  somePermission.openDocument()
  println(somePermission.ordinal)

  val anothePermission = Permission.valueOf("WRITE")
  anothePermission.openDocument()
  println(anothePermission.ordinal)

  enum PermissionWithBits(bits: Int) {
    case READ extends PermissionWithBits(4) // 100
    case WRITE extends PermissionWithBits(2) // 010
    case EXECUTE extends PermissionWithBits(1) // 001
    case NONE extends PermissionWithBits(0) // 000
  }

  object PermissionWithBits {
    def fromBits(bits: Int): PermissionWithBits = PermissionWithBits.NONE
  }
}
