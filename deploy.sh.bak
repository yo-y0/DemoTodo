#!/bin/sh

compose_file=$(find todoServer -type f -name docker-compose.yml)

if [ -z "$compose_file" ]; then
  echo "ERROR: File not found"
  exit 1
fi

compose_dir=$(dirname "$compose_file")

cd "$compose_dir"

docker-compose build

docker-compose up -d

if [ $? -eq 0 ]; then
  echo "Script executed successfully!"
else
  echo "Error encountered while running docker-compose"
fi
