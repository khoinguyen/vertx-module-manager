#!/bin/sh
BIN_DIR=`dirname "$0"`
HOME_DIR="`( cd \"$BIN_DIR/..\" && pwd )`" 
BIN_DIR="$HOME_DIR/bin"
LOG_DIR="$HOME_DIR/logs"
CONF_DIR="$HOME_DIR/conf"

PID_FILE="$HOME_DIR/app.pid"
CONF_FILE="$CONF_DIR/config.json"
LOG_FILE="$LOG_DIR/app.log"
MAIN_FILE="$BIN_DIR/app.js"
VERTX_MODS_DIR="$HOME_DIR/mods"

STATUS="Not running"
if [ -e "$PID_FILE" ]; then
  PID_NO=`cat "$PID_FILE"`

  if [ "$(ps | grep "$PID_NO" | awk '{print $1}' | grep "$PID_NO")" == "$PID_NO" ]; then
    STATUS="Running"
  fi
fi 

echo "============================================"
echo "  Home directory: $HOME_DIR"
echo "  Bin directory:  $BIN_DIR"
echo "  Config file:  $CONF_FILE"
echo "  PID file:  $PID_FILE"
echo "  Log file:  $LOG_FILE"
echo "  Module directory:  $VERTX_MODS_DIR"
echo "  Status: $STATUS"
echo "============================================"