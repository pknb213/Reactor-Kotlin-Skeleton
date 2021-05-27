object Server {
    @JvmStatic
    fun main(args: Array<String>) {
        val server = HttpServer.create()
            .route{
                it
                    .get("/ping") { req, res -> res.sendString(Mono.just("Pong\n")) }
                    .get("/test") { req, res ->
                        res.sendString(Mono.just("1"))
                    }
            }
            .port(4500)
            .bindNow()
        server.onDispose().block()
    }
}