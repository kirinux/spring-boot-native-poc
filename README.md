### Usage

Could generate buildpack baed docker image (no maven profile)
or a native image (graalVM based) + docker image (using graal maven profile)

to build a docker image `mvn  spring-boot:build-image`
or with a native build `mvn  spring-boot:build-image -DskipTests -Pnative-docker`
then you can use `docker-compose`