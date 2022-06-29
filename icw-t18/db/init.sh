#!/bin/sh

set -e
. /docker-entrypoint-initdb.d/db.env

if [ ${PASSWORD} != "" ]; then
  PASSWORD="-password $PASSWORD"
fi

java -cp /h2/bin/h2.jar org.h2.tools.RunScript \
  -url "jdbc:h2:/h2-data/${DBNAME}" -user ${USERNAME} ${PASSWORD} -script /docker-entrypoint-initdb.d/*.sql -showResults
