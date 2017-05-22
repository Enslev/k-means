# k-means

To run with clusters initializing at `n` first observations, run:
```
java -jar .\kmeans.jar <n> <obs>
```
* `n` is the number of clusters you want
* `obs` is a space-seperated array with the observations in the dataset
##### Example
``` 
java -jar .\kmeans.jar 3 "2 4 8 11 15 19 20 27 30 31"
```
##### Gives
```
[2.0, 4.0] : 3.0
[8.0, 11.0, 15.0] : 11.333333333333334
[19.0, 20.0, 27.0, 30.0, 31.0] : 25.4
```
```[2.0, 4.0]``` is one cluster of observations
```3.0``` is the final locations of "cluster"


To run with clusters initializing at specific points, run:
```
java -jar kmeans.jar <clusterLoc> <obs>
```
* `n` is the number of clusters you want
* `clusterLoc` is a space-seperated array with the initial locations of the clusters
##### Example
``` 
java -jar kmeans.jar "5 8 10" "2 4 8 11 15 19 20 27 30 31"
```
##### Gives
```
[2.0, 4.0] : 3.0
[8.0, 11.0, 15.0] : 11.333333333333334
[19.0, 20.0, 27.0, 30.0, 31.0] : 25.4
```
```[2.0, 4.0]``` is one cluster of observations
```3.0``` is the final locations of "cluster"





Jeppe Enslev