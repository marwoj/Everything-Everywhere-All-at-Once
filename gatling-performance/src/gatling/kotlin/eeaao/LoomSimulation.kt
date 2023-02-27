package eeaao

import eeaao.ActivitiesScenario.activitiesScenario
import eeaao.ActivitiesScenario.http
import io.gatling.javaapi.core.Simulation

class LoomSimulation : Simulation() {
    init {
        setUp(activitiesScenario(mode = "Loom")).protocols(http(8083))
    }
}
