#!/bin/bash

evidentVersion=Evident-0.0.1.jar
evidentWar=Evident-0.0.1.war

mydir=`pwd`/.extract/
webapps=$mydir/webapps/
confdir=$mydir/conf/

# If not exists directory create it.
mkdir -p $webapps
mkdir -p $confdir


META_DIR="META-INF"
CONTEXT_FILE="$META_DIR/context.xml"
GLOBAL_WEB_FILE="META-INF/web.xml"
jar xf $evidentVersion $evidentWar
jar xf $evidentWar $CONTEXT_FILE $GLOBAL_WEB_FILE

echo "---" $mydir
echo "---" $webapps

mv $evidentWar $webapps
cp $CONTEXT_FILE $confdir
cp $GLOBAL_WEB_FILE $confdir
rm -Rf $META_DIR


java -jar $evidentVersion  -httpPort=8080 --extractDirectory $mydir
