# stormpath-spring-boot-angular-example

This is a simple web app integrated with Stormpath supporting an Angular rich client UI.

You can see the example live [here](https://stormpath-spring-boot-angular.herokuapp.com/).

You can even deploy it to your own Heroku account: [![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://heroku.com/deploy) 

## Setup

* Create a Stormpath account at https://api.stormpath.com
* Create an API Key at https://api.stormpath.com and save it to: `~/.stormpath/apiKey.properties`

## Build

`mvn clean install`

## Run

`java -jar target/*.jar`

## Use

Browser to `localhost:8080` and you will see the Angular SPA.

You can create a Stormpath Account and then login, at which point the app will address you by name.

## Details

The included Angular app is served as a set of static pages that make use of the [Stormpath Angular SDK](https://github.com/stormpath/stormpath-sdk-angularjs).

The Angular app makes GET requests to the Spring Boot app to get view models for rendering, such as the login and register models.

It also makes POST requests to the Spring Boot app for perform operations like logging in and registering.

By default, The Angular app will handle routing. However, if someone bookmarks a page or does a force-refresh, it will cause a request to be sent to the Spring Boot app.

There's a single controller defined in the project: `AngularController`. It's only job is to ensure that requests to common auth endpoints (such as `/login` and `/register`) forward back to the Angular app.

We ensure tha that the Spring Boot app will *not* attempt to serve `text/html` requests for the auth endpoints by adding:

```
stormpath.web.produces = application/json
```

to the `application.properties` file. (The default is: `stormpath.web.produces = application/json, text/html`) This instructs the Stormpath Spring Boot integration to only handle `application/json` requests with the built-in auth endpoints and to let `text/html` requests pass through to this Spring Boot application. The `AngularController` has the path definitions for handling those auth endpoints.
