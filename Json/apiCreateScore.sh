#!/bin/bash

curl -H "Content-type: application/json" -X POST http://localhost:8080/score/create/ -d @./scoreCreate.json
