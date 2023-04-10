package eeaao

import eeaao.Scenario.activitiesScenario
import eeaao.Scenario.http
import io.gatling.javaapi.core.Simulation

class MVCSimulation : Simulation() {
    init {
        setUp(activitiesScenario(mode = "MVC")).protocols(http(8080))
    }
}
