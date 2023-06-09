#!/bin/bash

if [ $EUID != 0 ]; then
    sudo "$0" "$@"
    exit $?
fi

set -o errexit

if curl -h > /dev/null 2>&1; then
  echo "Found curl command !"
else
  echo "Using this script requires curl to be installed !"
  exit 1
fi

[ -d "./target/" ] && rm -Rf "./target"

ANTLR_FILE=/usr/local/lib/antlr-4.12.0-complete.jar

if [ -f "$ANTLR_FILE" ]; then
    echo "Found ANTLR Tools 4.12.0"
else
    echo "Downloading missing ANTLR Tools 4.12.0"
    curl -o /usr/local/lib/antlr-4.12.0-complete.jar https://www.antlr.org/download/antlr-4.12.0-complete.jar
fi

export CLASSPATH=".:/usr/local/lib/antlr-4.12.0-complete.jar:$CLASSPATH"

find ./src -type f -name "*.java" > _srcs
javac -d ./target @_srcs
rm _srcs

cd target
printf "Manifest-Version: 1.0\nMain-Class: net.tsbe.App\nClass-Path: /usr/local/lib/antlr-4.12.0-complete.jar\n" > MANIFEST.MF
find . -type f -name "*.class" > _classes
if jar cvfm ssl-compiler.jar MANIFEST.MF @_classes > /dev/null 2>&1; then
    echo -e "\033[32mSuccessfully generated JAR executable\033[0m at /target/ssl-compiler.jar"
else
    echo -e "\033[31mCould not generate JAR executable\033[0m, however, the compiled class files are available at: /target"
    echo "Execute the following lines to run the app :"
    echo "    CLASSPATH=\".:/usr/local/lib/antlr-4.12.0-complete.jar:\$CLASSPATH\""
    echo "    java net.tsbe.App <input_file>"
fi
rm MANIFEST.MF _classes
