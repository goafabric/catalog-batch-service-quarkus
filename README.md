# docker compose
go to /src/deploy/docker and do "./stack up"

# run native image
"${(@z)${CRUNTIME:-docker run --pull always}}" --name catalog-batch-service-quarkus --rm -p 50600:50600 \
-e 'quarkus.datasource.jdbc.url=jdbc:postgresql://postgres.host.docker.internal:5432/postgres' -e 'quarkus.datasource.username=postgres' -e 'quarkus.datasource.password=postgres' goafabric/catalog-batch-service-quarkus:$(grep '^version=' gradle.properties | cut -d'=' -f2)
