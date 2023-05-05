Resources:
1. https://hackernoon.com/doing-microservices-user-sessions-right-the-fundamentals-hj3z34nu
2. https://articles.microservices.com/monolithic-vs-microservices-architecture-5c4848858f59
3. https://www.linkedin.com/pulse/api-gateway-pattern-ronen-hamias/
4. https://medium.com/fintechexplained/what-is-event-driven-microservices-architecture-278d9e5adf8a
5. https://dzone.com/articles/design-patterns-for-microservices

# Microservice:
It is the approach of building software systems where the application is broken down into smaller, independently deployable services that communicate with each using light-weight protocols, such as HTTP or messaging systems.
# Service Oriented Architecture
It is an architectural approach that emphasizes on the creation of reusable services that can be accessed by different applications and systems. SOA services often use heavy-weight protocols for communications such as SOAP.


# How to improve API response time if a particular service is taking a long time to respond.
- Optimize database queries: If your service relies on a database, inefficient or poorly optimized database queries can lead to slow response times. You can optimize queries by indexing frequently queried columns and minimizing the amount of data being retrieved.

- Use caching: Caching frequently accessed data can significantly reduce response times by reducing the number of database queries required. You can use in-memory caching solutions like Redis or Memcached, or implement client-side caching.

- Load balancing: If your service is handling a large volume of requests, load balancing can help distribute the load across multiple instances of the service, reducing the load on each individual instance and improving response times.

# Design patterns of Microservices
1. Aggregator
2. API Gateway
3. Chained or Chain Of Responsibility
4. Asynchronous messaging
5. Database or Shared data.
6. Event sourcing.
7. Branch.
8. Command Query Responsibility Segregation.
9. Circuit Breaker.
10. Decomposition.

Microservice design patterns were built on these principles:
- Scalability
- Availability
- Resilience
- Independent, autonomous
- Decentralized governance
- Failure isolation
- Auto-provisioning
- Continuous delivery through DevOps

## 1. Decomposition patterns
- Decompose by business capability: This is something that a business does in order to generate value.
- Decompose by subdomain involves using Domain-Driven Design (DDD); This breaks the whole domain model created for the enterprise into subdomains e.g. Order Class, might be decomposed into Order Management, Order Taking, Order Delivery etc., to avoid "God Classes". Each subdomain will have a model and the scope of each model is called the bounded context on which each microservice will be developed around.
- Strangler pattern: It involves breaking a service into different domains and hosting them as separate services. This helps with decomposing the monolithic application while it is being used live, by doing it one domain at a time. Eventually, the newly refactored application "strangles" or "replaces" the original application, until you can finally shut off the monolithic application.

## 2.  Integration patterns
- ### API Gateway pattern: 
    - This is the single point of entry for any microservice call.
    - It can work as a proxy service to route a request to the concerned microservice, abstracting the producer details.
    - It can send out request to multiple services and aggregate the responses to send back to the client.
    - It can convert the protocol request to another protocol and vice-versa, so that the producer and consumer can handle it.
- ### Aggregator pattern:
    - It resolves the issue of aggregating the data from different services and then sending the final response to the consumer. This can be done in two (2) ways:
      1. A composite microservice will make calls to all the required microservices, consolidate the data, and transform the data before sending back.
      2. An API Gateway can also partition the request to multiple microservices and aggregate the data before sending it to the consumer.
  N.B.: If business logic is to be applied, go for composite, otherwise go for API Gateway.
      
- ### Client-side UI Composition pattern:
    - With microservices, the UI has to be designed as a skeleton with multiple sections/regions of the screen/page. Each section will make a call to an individual backend microservice to pull the data. That is called composing UI components specific to the service.

## 3.  Database patterns
- ### Database per Service:
    -  One database per microservice must be designed; it must be private to that service only. It should be accessed by the microservice API only. It cannot be accessed by other services directly.
- ### Shared Database per Service
    - In this pattern, one database can be aligned with more than one microservice, but it has to be restricted to 2-3 maximum, otherwise scaling, autonomy, and independence will be challenging to execute.
- ### Command Query Responsibility Segregation (CQRS)
    - For database per service implementations, getting joint data from multiple services is really difficult; this pattern solves this problem by splitting the application in two (2) parts: The command side and the query side. The command side handles the "Create, Update, and Delete" requests. The query side handles the query part by using the materialized views of the database to precompute the queries and store the results in a table. The event sourcing pattern is usually used along with it to create events for any data change. Material views are kept up to date by subscribing to the stream of events.
- ### Saga Pattern
    - It solves the problem of data consistency across services. It is a way of handling long-running transactions in distributed systems, where a transaction spans multiple microservices. It breaks down the transaction into a series of smaller, local transactions, called `compensating transactions` used to undo its changes, that can be individually rolled back if something goes wrong. This ensures that the system remains consistent and that the transaction is eventually either completed or rolled back in its entirety.

## 4. Observability patterns
- ### Log Aggregation:
  -  It involves providing a centralized logging service that aggregates logs from each service instance. Users can search and analyze the logs. They can configure alerts that are triggered when certain messages appear in the logs. It helps us to understand the application behavior through logs for a particular request.
- ### Performance Metrics
  - It helps us keep a watch on the transactions so that patterns can be monitored and alerts sent when an issue happens, by collecting metrics to monitor application performance. A metrics service is required to gather statistics about individual operations. It should aggregate the metrics of an application service, which provides reporting and alerting. There are two model for aggregating metrics:
    1. Push - the service pushes metrics to the metrics service, e.g., New Relic.
    2. Pull - the metrics services pulls metrics from the service, e.g., Prometheus and Grafana.
- ### Distributed tracing
  - It provides a service for tracing a request end-to-end across multiple services, which is useful for troubleshooting. It assigns each external request a unique external request id, passes the external request id to all services, includes the external request id in all log messages. Records information (e.g. start time, end time) about the requests and operations performed when handling an external request in a centralized service.
- ### Health Check
  - 

## 5. Cross-Cutting Concern pattern
- ### External configuration:
  -  
- ### Service Discovery Pattern
  - 
- ### Circuit breaker pattern
  - 
- ### Blue-Green Deployment Pattern
  - 

# Event-driven architecture (EDA)
Events are used to trigger actions across multiple systems or services. Events are sort of like notifications, which contains data about the change of state that triggered that event, and this data can then be used by the consumers to perform some actions and so on. One benefit of Event-Driven microservices architecture is that it allows for the re-usability of existing microservices and also creating of new microservices as long as they can publish and subscribe to an event broker system.

- In messaging systems, a topic is a named entity that serves as a communication channel between publishers and subscribers. Publishers send messages to a topic, and subscribers receive messages from a topic.

Side notes:
  - Materialized views are database objects that contain the results of a precomputed query. Unlike regular views, which are virtual tables that represent the result of a stored query, materialized views store the actual data in a physical table. This means that the results of the query are precomputed and stored in the materialized view, allowing for faster access to the data when the query is executed again. While, Regular views are database objects that provide a virtual table based on the result set of an SQL query. They are not materialized, meaning they do not store the data themselves. Instead, they are simply stored queries that can be accessed and queried like a table.