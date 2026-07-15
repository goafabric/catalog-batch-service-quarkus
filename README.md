# docker compose
go to /src/deploy/docker and do "./stack up"

# run native image
container image pull goafabric/catalog-batch-service-quarkus:$(grep '^version=' gradle.properties | cut -d'=' -f2) 
"${(@z)${CRUNTIME2:-docker run --pull always}}" --name catalog-batch-service-quarkus --rm -p 50600:50600 goafabric/catalog-batch-service-quarkus:$(grep '^version=' gradle.properties | cut -d'=' -f2)
