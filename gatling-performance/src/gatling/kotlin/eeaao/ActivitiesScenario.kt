package eeaao

import io.gatling.javaapi.core.CoreDsl
import io.gatling.javaapi.http.HttpDsl

object ActivitiesScenario {
    fun getActivities(scenario: String) = CoreDsl.scenario(scenario).exec(
        CoreDsl.exec(
            HttpDsl.http("$scenario: Get Activities")
                .get("/activities")
        )
    ).injectOpen(CoreDsl.constantUsersPerSec(100.0).during(5))

    fun http(port: Int) =
        HttpDsl.http.baseUrl("http://localhost:$port")
            .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
            .acceptLanguageHeader("en-US,en;q=0.5")
            .acceptEncodingHeader("gzip, deflate")
            .userAgentHeader(
                "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0"
            )
}