#!/bin/sh
sudo docker build -t docker-customer-service
sudo docker run -p 8080:8080 -t docker-customer-service

