#!/bin/bash

filename="res"
touch $filename
path="../CVRP_Instances_Augerat/"

echo -e '\n\n\t\033[4mClarkeWright heuristic (h1)\033[0m\n'>$filename

for file in $path/*.vrp; do
	echo -e "$file\n" >> $filename
	java cvrp/MainCVRP -h1 $file >> $filename
	echo -e '\n' >> $filename
done

echo -e '\n\n\t\033[4mGiantTour heuristic (h2)\033[0m\n'>>$filename

for file in $path/*.vrp; do
	echo -e "$file\n" >> $filename
	java cvrp/MainCVRP -h2 $file >> $filename
	echo -e '\n' >> $filename
done

echo -e '\n\n\t\033[34mSee results in res !\033[0m\n\n'
