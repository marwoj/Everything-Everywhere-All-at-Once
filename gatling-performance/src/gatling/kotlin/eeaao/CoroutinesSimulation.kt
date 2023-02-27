package eeaao

import eeaao.ActivitiesScenario.activitiesScenario
import eeaao.ActivitiesScenario.http
import io.gatling.javaapi.core.Simulation

class CoroutinesSimulation : Simulation() {
    init {
        setUp(activitiesScenario(mode = "Coroutines")).protocols(http(8082))
    }
}
