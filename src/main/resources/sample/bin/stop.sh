#!/bin/sh
. `dirname $0`/env.sh

if [ -e "$PID_FILE" ]; then
  kill `cat "$PID_FILE"`
  rm "$PID_FILE"
  echo "Stopped."
fi