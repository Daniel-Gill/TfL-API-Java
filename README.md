# TfL API in Java

This WIP project adds an easy way to access the TfL API. The project has been set up using Gradle.

To use the library, start at `TfLAPI`, then you can use static variables to access certain API endpoints. For example:

```java
TfLAPI.Line.getRoutes() // returns a list of lines with attatched valid routes
```

## Current Endpoints

Currently implemented in this library is:

- /Line/Route
