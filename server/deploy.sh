#!/bin/sh
WAR_FILE=$1
ADMIN_USER=$2

echo "[INFO] Deploying artifact \"$WAR_FILE\" to the Docker Payara."
$PAYARA_PATH/bin/asadmin --user $ADMIN_USER --passwordfile=/opt/pwdfile deploy --force /opt/payara/target/$WAR_FILE
