# Food service

## Description
It allows the user to add a dish with specified toppings,
upon a successful `POST` request the user receives URL links to an image
that possibly resembles the food added. 

The application is web oriented,
essentially it is a REST service allowing the user to add dishes with toppings from a limited set.

## Used technologies

### Spring boot

**Spring boot** was used for creating the REST service, the following endpoints are available:

```
GET /dishes
GET /dishes/{id}
POST /dishes
``` 

Additionally, the `/dishes` endpoint has the following optional query parameters:

```
lang={language}
curr={currency}
```

The supported language set is `{ro, en}`.

The supported currency set consists of the currencies available here `https://api.exchangeratesapi.io/latest?base=USD`.

### MongoDB

For persisting the data, **MongoDB** was used. Because Java is object-oriented and MongoDB follows a document structure,
this was the perfect match. No overhead was experienced in storing the objects as Java objects can be directly mapped to
MongoDB's BSON documents. 

### Java Swing

**Java Swing** was used for creating a client program with a user interface. After successfully adding a new dish to the
collection the user is presented with a picture that possibly resembles the food added.

### Java RMI

**Java Remote Method Invocation** was used for transferring the created food object from the client to the server.

### Java Internationalization

**Java Internationalization** was used for conveniently representing the application specific strings
in different languages.