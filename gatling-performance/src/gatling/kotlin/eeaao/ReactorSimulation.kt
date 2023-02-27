package eeaao

import eeaao.ActivitiesScenario.activitiesScenario
import eeaao.ActivitiesScenario.http
import io.gatling.javaapi.core.Simulation

class ReactorSimulation : Simulation() {
    init {
        setUp(activitiesScenario(mode = "Reactor")).protocols(http(8081))
    }
}
