package eeaao

import eeaao.ActivitiesScenario.activitiesScenario
import eeaao.ActivitiesScenario.http
import io.gatling.javaapi.core.Simulation

class MVCSimulation : Simulation() {
    init {
        setUp(activitiesScenario(mode = "MVC")).protocols(http(8080))
    }
}
