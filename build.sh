#bin/bash
mvn package
cd manager
docker build -t nidin001/manager:latest .
docker push nidin001/manager:latest

cd ../worker
docker build -t nidin001/worker:latest .
docker push nidin001/worker:latest
cd ..