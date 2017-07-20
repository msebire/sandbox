#!/bin/sh

if [ "$TRAVIS_PULL_REQUEST" = "false" ]; then
    mvn -B clean org.jacoco:jacoco-maven-plugin:prepare-agent package sonar:sonar
else
    mvn -B clean package -B
fi
