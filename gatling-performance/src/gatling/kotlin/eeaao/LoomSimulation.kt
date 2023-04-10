package eeaao

import eeaao.Scenario.activitiesScenario
import eeaao.Scenario.http
import io.gatling.javaapi.core.Simulation

class LoomSimulation : Simulation() {
    init {
        setUp(activitiesScenario(mode = "Loom")).protocols(http(8083))
    }
}
