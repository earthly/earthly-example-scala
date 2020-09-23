import doobie._
import doobie.implicits._
import cats.effect.IO
import scala.concurrent.ExecutionContext

object Main extends App {
  implicit val cs = IO.contextShift(ExecutionContext.global)

  val xa = Transactor.fromDriverManager[IO](
    "org.postgresql.Driver", 
    "jdbc:postgresql://localhost:5432/iso3166", 
    "postgres",
    "postgres"
  )
  val y = xa.yolo
  import y._

  sql"select name from country"
    .query[String] 
    .stream
    .take(5)
    .quick
    .unsafeRunSync

}