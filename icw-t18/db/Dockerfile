FROM openjdk:11-jdk AS build-env

ENV RELEASE_DATE 2019-10-14

RUN wget http://www.h2database.com/h2-$RELEASE_DATE.zip -O h2.zip \
    && unzip h2.zip -d . \
    && rm h2.zip

RUN ln -s $(ls /h2/bin/*jar) /h2/bin/h2.jar

RUN mkdir /docker-entrypoint-initdb.d
COPY ./sql/*.sql /docker-entrypoint-initdb.d
COPY ./init.sh /docker-entrypoint-initdb.d
COPY ./db.env /docker-entrypoint-initdb.d
RUN chmod 444 /docker-entrypoint-initdb.d/*.sql && \
    chmod 444 /docker-entrypoint-initdb.d/*.env && \
    chmod a+x /docker-entrypoint-initdb.d/*.sh && \
    find /docker-entrypoint-initdb.d -type f | xargs sed -i 's/\r//'

FROM openjdk:11-jre-slim
RUN apt-get update && \
    apt-get install -y --no-install-recommends && \
    apt-get upgrade -y --allow-unauthenticated && \
    apt-get clean -y

ENV H2DATA /h2-data

COPY --from=build-env /h2/bin/ /h2/bin
COPY --from=build-env /docker-entrypoint-initdb.d /docker-entrypoint-initdb.d

EXPOSE 8082 9092

COPY docker-entrypoint.sh /usr/local/bin/
RUN chmod a+x /usr/local/bin/docker-entrypoint.sh && sed -i 's/\r//' /usr/local/bin/docker-entrypoint.sh
ENTRYPOINT ["/usr/local/bin/docker-entrypoint.sh"]

CMD java -cp /h2/bin/h2.jar org.h2.tools.Server \
  -web -webAllowOthers -tcp -tcpAllowOthers -baseDir $H2DATA