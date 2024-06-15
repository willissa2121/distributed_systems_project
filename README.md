## Semester Project
Group Members: Preston Kelly, Scott Willis, Jacob Formico

## How To Use

To run this application, [Maven](https://maven.apache.org/), [Java 17](https://www.oracle.com/java/technologies/downloads/#java17), and [Docker](https://www.docker.com/products/docker-desktop/). You can see the exact version I am using listed above. From your command line:

```bash
# The first step is to run teh following command to ensure a clean build environement:
$ mvn clean

# To build the docker images for this application, open a command-line 
# window and execute the following command:
$ mvn clean install package

$ cd image-service #Enters image service directory
$ docker build -t image-service:latest . # builds image
$ cd ../metadata-service # Enters metadata service directory
$ docker build -t metadata-service:latest . # builds image
$ cd ../configserver # Enters configserver directory
$ docker build -t configserver:latest . # builds image
$ cd ..  #returns to base directory

# Now we are going to use docker-compose to start the actual image.  To start the docker image, stay in the directory containing  your source code (same level as this document) and  Run the following command: 
$ docker-compose -f docker/docker-compose.yml up -d
# The -d flag is used to run in detached mode so you can keep using your terminal
# You may need to run this twice as the image-service container tends to start to fast

# To stop the containers, run the following commands:
$ docker-compose -f docker/docker-compose.yml down
# You can add the following flag, -v, to remove the volume which will restore you database to its state with the default data provided
```
### Access the database
As we are using the a postgres image, it is possible to access the database. To do so, you can access the container while it is running by docker desktop and running an exec shell on the postgres container.

The following line will allow for access to the database
```bash
# Signing into the DB
$ psql -U dockeruser dockerdb

# From this point, you can interact with the database like any normal psql database.
```

## Troubleshooting
For some reason, I am requried to run teh docker compose twice for everything to be runnning
Exposed daemon on tcp://localhost:2375 in settings
Still working to get docker start command to run
