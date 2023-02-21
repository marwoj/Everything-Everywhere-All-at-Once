# Everything Everywhere All at Once

Measure efficiency of REST endpoint written in Spring but using: Project Reactor, Coroutines, Loom

### MVC

`./gradlew  :mvc:bootRun`

`./gradlew  :gatling-performance:gatlingRun-eeaao.MVCSimulation`

### Reactor

`./gradlew  :reactor:bootRun`

`./gradlew  :gatling-performance:gatlingRun-eeaao.ReactorSimulation`

### Coroutines

`./gradlew  :coroutines:bootRun`

`./gradlew  :gatling-performance:gatlingRun-eeaao.CoroutinesSimulation`

### Loom

`./gradlew  :loom:bootRun`

`./gradlew  :gatling-performance:gatlingRun-eeaao.LoomSimulation`

### Run all simulations

`./gradlew  :gatling-performance:gatlingRun`