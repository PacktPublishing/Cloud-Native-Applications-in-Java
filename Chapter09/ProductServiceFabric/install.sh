#!/bin/bash

sfctl application upload --path ProductServiceFabric --show-progress
sfctl application provision --application-type-build-path ProductServiceFabric
sfctl application create --app-name fabric:/ProductServiceFabric --app-type ProductServiceFabricType --app-version 1.0.0
