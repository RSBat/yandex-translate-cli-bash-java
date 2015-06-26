#!/bin/bash
if [ $# -eq 0 ]
  then
    echo "Enter text for translate"
    exit 1;
fi
java -classpath /usr/bin/ YandexTranslate "$1"