#!/bin/bash
read -p 'Instances directory to test (0 : toy_instances, 1 : instances): ' dir

filename="res"
touch $filename

if [[ $dir = 0 ]]; then
	path="../data/toy_instances"
else
	path="../data/instances"
fi

echo -e '\n\n\t\033[4mFarthest insertion heuristic (h1)\033[0m\n'>$filename

for file in $path/*.tsp; do
	echo -e "$file\n" >> $filename
	java tsp/MainTSP -h1 $file >> $filename
	echo -e '\n' >> $filename
done

echo -e '\n\n\t\033[4mArc insertion heuristic (h2)\033[0m\n'>>$filename

for file in $path/*.tsp; do
	echo -e "$file\n" >> $filename
	java tsp/MainTSP -h2 $file >> $filename
	echo -e '\n' >> $filename
done

echo -e '\n\n\t\033[34mSee results in res !\033[0m\n\n'
