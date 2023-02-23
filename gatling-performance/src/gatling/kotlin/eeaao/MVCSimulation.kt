package eeaao

import eeaao.ActivitiesScenario.getActivities
import eeaao.ActivitiesScenario.http
import io.gatling.javaapi.core.Simulation

class MVCSimulation : Simulation() {
    init {
        setUp(getActivities(scenario = "MVC")).protocols(http(8080))
    }
}
