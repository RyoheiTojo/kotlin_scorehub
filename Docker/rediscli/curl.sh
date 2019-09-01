#!/bin/sh

curl -X PUT http://host.docker.internal:8500/v1/kv/config/application.yml --data-binary @/rediscli/application.yml
curl -X PUT http://host.docker.internal:8500/v1/kv/config/application-local.yml --data-binary @/rediscli/application-local.yml
