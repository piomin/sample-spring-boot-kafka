# Spring Kafka with Spring Boot Demo Project [![Twitter](https://img.shields.io/twitter/follow/piotr_minkowski.svg?style=social&logo=twitter&label=Follow%20Me)](https://twitter.com/piotr_minkowski)

[![CircleCI](https://circleci.com/gh/piomin/sample-spring-boot-kafka.svg?style=svg)](https://circleci.com/gh/piomin/sample-spring-boot-kafka)

[![SonarCloud](https://sonarcloud.io/images/project_badges/sonarcloud-black.svg)](https://sonarcloud.io/dashboard?id=piomin_sample-spring-boot-kafka)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=piomin_sample-spring-boot-kafka&metric=bugs)](https://sonarcloud.io/dashboard?id=piomin_sample-spring-boot-kafka)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=piomin_sample-spring-boot-kafka&metric=coverage)](https://sonarcloud.io/dashboard?id=piomin_sample-spring-boot-kafka)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=piomin_sample-spring-boot-kafka&metric=ncloc)](https://sonarcloud.io/dashboard?id=piomin_sample-spring-boot-kafka)

In this project I'm demonstrating you the most interesting features of [Spring Kafka Project](https://spring.io/projects/spring-kafka) for integrating Spring Boot with Apache Kafka.

1. Learn how to manage Kafka customer offset with Spring Kafka for Spring Boot app. The details may be found in the article: [Kafka Offset with Spring Boot](https://piotrminkowski.com/2024/03/11/kafka-offset-with-spring-boot/)
2. Straightforward Spring Boot examples to illustrate how your application can inadvertently lose messages or process them twice due to the Kafka offset commit mechanism. The details may be found in the article: [Deep Dive into Kafka Offset Commit with Spring Boot](https://piotrminkowski.com/2026/03/27/deep-dive-into-kafka-offset-commit-with-spring-boot/)

## Usage

First, run Docker or Podman.

Start consumer:
```shell
cd consumer
mvn spring-boot:test-run
```

In logs, find the Kafka address, which is generated automatically using Spring Boot Testcontainers support in dev mode.

Then export Kafka address as env variable:
```shell
export KAFKA_URL=<YOUR_KAFKA_URL>
```

Start producer:
```shell
cd producer
mvn spring-boot:run
```