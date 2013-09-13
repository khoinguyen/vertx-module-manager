#!/bin/sh
. `dirname $0`/env.sh

vertx run "$MAIN_FILE" -conf "$CONF_FILE"