#!/bin/sh

a=$#

if a==0
then
echo myscript:ERROR no arguments supplied
echo myscript: USAGE : my script argument1[argumets...]
else
echo the number of arguments : $#
echo the arguments : $1 $2 $3
echo the first argument $1
echo the second argument $2
echo the third argument $3
fi

