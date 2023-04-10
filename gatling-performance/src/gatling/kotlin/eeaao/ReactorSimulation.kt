package eeaao

import eeaao.Scenario.activitiesScenario
import eeaao.Scenario.http
import io.gatling.javaapi.core.Simulation

class ReactorSimulation : Simulation() {
    init {
        setUp(activitiesScenario(mode = "Reactor")).protocols(http(8081))
    }
}
