FROM payara/server-full:181

ARG WAR_FILE

# default credentials
ENV ADMIN_USER besynext
ENV ADMIN_PASSWORD besynext
ENV DOMAIN besynext_domain
ENV DEPLOY_HOME /opt/payara
ENV POOL_NAME BeSyNextPool
ENV DB_NAME besynext
ENV DB_SCHEMA ds-yggdrasil
ENV PATH $PATH:$DEPLOY_HOME

# prepare the password configuration
RUN echo 'AS_ADMIN_PASSWORD='$ADMIN_PASSWORD'\n'\
> /opt/pwdfile

# create new domain with datasource configuration
RUN /opt/payara41/bin/asadmin create-domain --user $ADMIN_USER --passwordfile=/opt/pwdfile $DOMAIN

# copy payara domain libs
COPY ./docker/payara/lib/postgresql-besy.jar $PAYARA_PATH/glassfish/domains/$DOMAIN/lib

# init admin configurations
RUN \
 $PAYARA_PATH/bin/asadmin start-domain $DOMAIN && \
 $PAYARA_PATH/bin/asadmin --user $ADMIN_USER --passwordfile=/opt/pwdfile enable-secure-admin && \
 $PAYARA_PATH/bin/asadmin restart-domain $DOMAIN && \
  $PAYARA_PATH/bin/asadmin create-jdbc-connection-pool --user $ADMIN_USER --passwordfile=/opt/pwdfile --datasourceclassname org.postgresql.ds.PGSimpleDataSource --restype javax.sql.DataSource --property User=$ADMIN_USER:Password=$ADMIN_PASSWORD:DatabaseName=$DB_NAME:ServerName=ds-yggdrasil-postgres:PortNumber=5432:currentSchema=$DB_SCHEMA $POOL_NAME && \
  $PAYARA_PATH/bin/asadmin create-jdbc-resource --user $ADMIN_USER --passwordfile=/opt/pwdfile --connectionpoolid $POOL_NAME jdbc/$POOL_NAME

# copy logging properties
COPY ./src/main/resources/logging.properties $PAYARA_PATH/glassfish/domains/$DOMAIN/config/logging.properties

# copy script for redeployments
COPY deploy.sh $DEPLOY_HOME/deploy.sh

# copy BMW JAAF security library
COPY  ./lib/jaaf-core-jee7-1.06.00.jar /opt/payara41/glassfish/lib/jaaf-core-jee7-1.06.00.jar

# copy WAR file
COPY  ./target/$WAR_FILE /opt/payara41/glassfish/domains/$DOMAIN/autodeploy/$WAR_FILE

# start the Payara server
ENTRYPOINT $PAYARA_PATH/bin/asadmin start-domain --debug -v besynext_domain
