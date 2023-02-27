package eeaao

import io.gatling.javaapi.core.CoreDsl.constantUsersPerSec
import io.gatling.javaapi.core.CoreDsl.scenario
import io.gatling.javaapi.http.HttpDsl.http

object ActivitiesScenario {
    fun activitiesScenario(mode: String) =
        scenario(mode)
            .exec(http("$mode: Get author activities").get("/activities/author/1"))
            .exec(http("$mode: Get activity details").get("/activities/0/author"))
            .exec(http("$mode: Get author statistics").get("/activities/author/1/statistics"))
            .injectOpen(constantUsersPerSec(5.0).during(5))

    fun http(port: Int) =
        http.baseUrl("http://localhost:$port")
            .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
            .acceptLanguageHeader("en-US,en;q=0.5")
            .acceptEncodingHeader("gzip, deflate")
            .userAgentHeader(
                "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0"
            )
}