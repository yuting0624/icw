#!/usr/bin/env bash

mkdir -p $H2DATA

sh /docker-entrypoint-initdb.d/init.sh

exec "$@"