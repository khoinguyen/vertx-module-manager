#!/bin/sh
. `dirname $0`/env.sh

if [ ! -e "$PID_FILE" ]; then
  export VERTX_MODS="$VERTX_MODS_DIR"
  nohup vertx run "$MAIN_FILE" -conf "$CONF_FILE" > "$LOG_FILE" &
  echo "$!" > "$PID_FILE"
  echo "Started."
else
  echo "PID file existed. Please check if it is running."
fi