# TSP-CVRP


                                  ┌────────────────────────────────────────┐
                                  │                TSP-CVRP                │
                                  ├────────────────────────────────────────┤
                                  │                                        │
                                  │   Heuristics for Routing/Semestre 8    │
                                  │              ENSEIRB-MATMECA           │
                                  │          ~mbounakhla, ~mrihani         │
                                  │                                        │
                                  └────────────────────────────────────────┘

## Description

This project is written in Java. It implements heuristics for problems traveling salesman (*TSP*) and vehicle routing with capacity constraints. (*CVRP*).

## Motivation

This project is part of the *fourth year* of *computer science engineering* program at *Bordeaux Graduate School of Engineering*, also known as [ENSEIRB-MATMECA][].
It is a mini project as part of the flood and combinatorial option (Flot et combinatoire *IF230*).


## Use


Just run (in the main directory TSP-CVRP/) command:

./test.sh

and follow the instructions.

Exp of execution order for the application of heuristic 1 (Farthest insertion) on ../data/instances/a280.tsp instance:

	./test.sh
	1
	../data/instances/a280.tsp

> To generate a file src/res containing the results of the two heuristics (Farthest Insertion & Arc insertion) on the instances of toy_instances / or instances/, just run (in the
src /) directory:

./tests

and follow the instructions.

## Contributors

- Mehdi BOUNAKHLA - Mehdi.Bounakhla@enseirb-matmeca.fr
- [Mohammed RIHANI][] - Mohammed.Rihani@enseirb-matmeca.fr


[Mohammed RIHANI]: http://mrihani.vvv.enseirb-matmeca.fr
[ENSEIRB-MATMECA]: http://www.enseirb-matmeca.fr
[Bordeaux-INP]: https://www.bordeaux-inp.fr/
