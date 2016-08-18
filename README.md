# stormpath-spring-boot-angular-example

Simple web app integrated with Stormpath supporting an Angular rich client UI.

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

This app has no explicit Spring Boot controllers defined!

It makes use of the built-in paths from the Stormpath Spring Boot Starter integration (like `/login`, `/register`, and `/forgot`).

The included Angular app is served as a set of static pages that make use of the [Stormpath Angular SDK]().

The Angular app makes GET requests to the Spring Boot app to get view models for rendering, such as the login and register models.
It also makes POST requests to the Spring Boot app for perform operations like logging in and registering.
