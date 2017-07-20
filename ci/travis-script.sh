#!/bin/sh

if [ "$TRAVIS_SECURE_ENV_VARS" = "true" ]; then
    openssl aes-256-cbc -d -k "$OPENSSL_PASSPHRASE" -in ci/pubring.gpg.enc -out ci/pubring.gpg
    openssl aes-256-cbc -d -k "$OPENSSL_PASSPHRASE" -in ci/secring.gpg.enc -out ci/secring.gpg
    mvn -B clean org.jacoco:jacoco-maven-plugin:prepare-agent package sonar:sonar
    mvn -B -DskipTests=true -s ./ci/settings.xml clean verify
else
    mvn -B clean verify
fi
