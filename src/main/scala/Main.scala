import cats.effect.{IO, IOApp}
import org.http4s.ember.client.EmberClientBuilder
import org.typelevel.log4cats.LoggerFactory
import org.typelevel.log4cats.slf4j.Slf4jFactory

given LoggerFactory[IO] = Slf4jFactory.create[IO]

object Main extends IOApp.Simple {
  override def run: IO[Unit] = {
    EmberClientBuilder.default[IO].build.use { client =>
      val adventOfCodeService = new AdventOfCodeServiceImpl(client)
      for {
        input <- adventOfCodeService.getInput(2015, 1)
        _ <- IO.println(input)
      } yield ()
    }
  }

}
