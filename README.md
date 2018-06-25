# Data Linker

**An easy way to convert data into RDF**

Data Linker is a tool capable of transforming a CSV(Comma-Separated Values) archive into RDF data, making semantic links automatically.

### Services

It was decomposed into three core independently deployable applications.

#### Dataset service
Receives the datasets that should be watched and linked.

GET    /datasets/{dataset}  Get specified dataset

GET    /datasets            Get all watched datasets

POST   /datasets           Insert a new dataset to be linked

DELETE /datasets/{dataset}  Removes a dataset from being watched


#### Transformation service

Links datasets and transforms them into RDF

#### Notification service

Sends the new RDF dump URL via email.

## Infrastructure services

### Config service

Loads config files from the local classpath.

### Gateway
Single entry point into the system, used to handle requests by routing them to the appropriate backend service.


