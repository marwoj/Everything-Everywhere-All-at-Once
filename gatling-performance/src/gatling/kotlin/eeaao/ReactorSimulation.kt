package eeaao

import eeaao.ActivitiesScenario.getActivities
import eeaao.ActivitiesScenario.http
import io.gatling.javaapi.core.Simulation

class ReactorSimulation : Simulation() {
    init {
        setUp(getActivities(scenario = "Reactor")).protocols(http(8081))
    }
}
