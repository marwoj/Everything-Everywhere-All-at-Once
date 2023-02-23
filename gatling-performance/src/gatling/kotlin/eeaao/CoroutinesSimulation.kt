package eeaao

import eeaao.ActivitiesScenario.getActivities
import eeaao.ActivitiesScenario.http
import io.gatling.javaapi.core.Simulation

class CoroutinesSimulation : Simulation() {
    init {
        setUp(getActivities(scenario = "Coroutines")).protocols(http(8082))
    }
}
