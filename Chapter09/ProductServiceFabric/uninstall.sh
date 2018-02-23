#!/bin/bash

sfctl application delete --application-id ProductServiceFabric
sfctl application unprovision --application-type-name ProductServiceFabricType --application-type-version 1.0.0
sfctl store delete --content-path ProductServiceFabric
