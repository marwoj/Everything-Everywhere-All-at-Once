# Everything Everywhere All at Once

Measure efficiency of REST endpoint written in Spring but using: Project Reactor, Coroutines, Loom

### MVC

Run application:
`./gradlew  :mvc:bootRun`

Run simulation:
`./gradlew  :gatling-performance:gatlingRun-eeaao.MVCSimulation`

### Reactor
Run application:
`./gradlew  :reactor:bootRun`

Run simulation:
`./gradlew  :gatling-performance:gatlingRun-eeaao.ReactorSimulation`

### Coroutines
Run application:
`./gradlew  :coroutines:bootRun`

Run simulation:
`./gradlew  :gatling-performance:gatlingRun-eeaao.CoroutinesSimulation`

### Loom
Run application:
`./gradlew  :loom:bootRun`

Run simulation:
`./gradlew  :gatling-performance:gatlingRun-eeaao.LoomSimulation`

### Run all simulations

Clean reports:
`./gradlew  :gatling-performance:clean`

Before run, make sure that all services are running

Run all simulations:
`./gradlew  :gatling-performance:gatlingRun`

Build all applications:

`./gradlew  :mvc:assemble :reactor:assemble :coroutines:assemble :loom:assemble`