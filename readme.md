
#### features
    * support multiple rovers
    * rovers does not collide (stop just before the collision)

#### API details
    * refer RoverResource.java

## local setup

###### build project

maven clean package

###### build image

docker build . -t nasa/rover

###### Run app on cluster

kubectl apply -k .

###### TODO work
    * swagger
