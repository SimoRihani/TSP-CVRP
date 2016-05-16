#!/bin/bash

read -p 'Heuristic to use (1: h1, 2: h2) : ' h
read -p 'Instance path : ' path

cd src/

if [[ $h = 1 ]]; then
  h="h1"
  echo -e '\n\n\t\033[4mClarkeWright heuristic (h1)\033[0m\n'
elif [[ $h = 2 ]]; then
  h="h2"
  echo -e '\n\n\t\033[4mGiantTour heuristic (h2)\033[0m\n'
else
  h="h1"
fi

make clean && make && java cvrp/MainCVRP -$h $path
