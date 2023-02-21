package eeaao

import eeaao.ActivitiesScenario.getActivities
import eeaao.ActivitiesScenario.http
import io.gatling.javaapi.core.Simulation

class LoomSimulation : Simulation() {
    init {
        setUp(getActivities(scenario = "Loom")).protocols(http(8083))
    }
}
