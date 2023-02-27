package eeaao

import eeaao.Scenario.activitiesScenario
import eeaao.Scenario.http
import io.gatling.javaapi.core.Simulation

class CoroutinesSimulation : Simulation() {
    init {
        setUp(activitiesScenario(mode = "Coroutines")).protocols(http(8082))
    }
}
