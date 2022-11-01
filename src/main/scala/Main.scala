import org.neo4j.driver._

@main def hello: Unit =

  val driver = GraphDatabase.driver("bolt://localhost/7687", AuthTokens.basic("neo4j", "gruppe8"))

  val session = driver.session()

  val movieTitle = "MATCH (t:TopMovies) WHERE t.seriesTitle = \"The Shawshank Redemption\" RETURN t.seriesTitle AS seriesTitle"
  val director = "MATCH (t:TopMovies) WHERE t.seriesTitle = \"The Shawshank Redemption\" Return t.Director AS Director"



  val result = session.run(director)

  val record = result.next()

  print(record)
