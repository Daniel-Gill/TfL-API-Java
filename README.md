# TfL API in Java

This WIP project adds an easy way to access the TfL API. The project has been set up using Gradle.

To use the library, start at `TfLAPI`, then you can use static variables to access certain API endpoints. For example:

```java
TfLAPI.Line.route() // returns a list of lines with attatched valid routes
```

## Current Endpoints

Currently implemented in this library is:

- /Line/Route
- /Line/Route?serviceType
- /Line/{id}/Route
- /Line/{ids}/Route
- /Line/Mode/{mode}/Disruption
- /Line/Mode/{modes}/Disruption
- /Line/Mode/{id}/Disruption
- /Line/Mode/{ids}/Disruption
- /Line/Mode/{mode}/Status
- /Line/Mode/{modes}/Status
