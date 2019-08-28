FROM alpine:latest
RUN apk --update add curl
CMD curl -X PUT http://host.docker.internal:8500/v1/kv/config/application.yml -d @./rediscli/application.yml
