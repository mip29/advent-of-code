import org.http4s.ember.client.EmberClientBuilder
import cats.effect.{IO, Resource}
import org.http4s.Uri
import org.http4s.client.Client
import org.http4s.implicits.uri

trait AdventOfCodeService[F[_]]:
  def getInput(year: Int, day: Int): F[String]

//  def submitAnswer(answer: String): Either[String, F[Unit]]

class AdventOfCodeServiceImpl(client: Client[IO]) extends AdventOfCodeService[IO]:

  private val baseUri: Uri = uri"https://adventofcode.com"

  def getInput(day: Int, year: Int): IO[String] =
    val uri = baseUri / year / "day" / day / "input"
    client.expect[String](uri)


