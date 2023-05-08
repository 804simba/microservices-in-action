Zipkin is used for distributed tracing in microservices systems. Where distributed tracing is the latency measurement of each component in a distributed transaction where multiple microservices are invoked  to serve a single business use case.
It is useful for debugging when a lot of distributed underlying systems are involved and the application becomes slow,
it helps to identify the slow service.

Sleuth is used to generate trace and span ids and add them in the headers of each service call in the headers and MDC.



https://www.baeldung.com/mdc-in-log4j-2-logback

Mapped Diagnostic Context provides a way to enrich log messages with information that could be unavailable in the scope where the logging actually occurs but that can be indeed useful to better track the execution of the program.