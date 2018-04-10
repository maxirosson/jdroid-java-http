# Http Library for Java & Android Apps

## Continuous Integration
|Branch|Status|Workflows|Insights|
| ------------- | ------------- | ------------- | ------------- |
|master|[![CircleCI](https://circleci.com/gh/maxirosson/jdroid-java-http/tree/master.svg?style=svg)](https://circleci.com/gh/maxirosson/jdroid-java-http/tree/master)|[Workflows](https://circleci.com/gh/maxirosson/workflows/jdroid-java-http/tree/master)|[Insights](https://circleci.com/build-insights/gh/maxirosson/jdroid-java-http/master)|
|staging|[![CircleCI](https://circleci.com/gh/maxirosson/jdroid-java-http/tree/staging.svg?style=svg)](https://circleci.com/gh/maxirosson/jdroid-java-http/tree/staging)|[Workflows](https://circleci.com/gh/maxirosson/workflows/jdroid-java-http/tree/staging)|[Insights](https://circleci.com/build-insights/gh/maxirosson/jdroid-java-http/staging)|
|production|[![CircleCI](https://circleci.com/gh/maxirosson/jdroid-java-http/tree/production.svg?style=svg)](https://circleci.com/gh/maxirosson/jdroid-java-http/tree/production)|[Workflows](https://circleci.com/gh/maxirosson/workflows/jdroid-java-http/tree/production)|[Insights](https://circleci.com/build-insights/gh/maxirosson/jdroid-java-http/production)|

## Features

* HTTP Service Layer
 * GET, POST, PUT, PATCH & DELETE methods
 * Headers appender
 * Response validator
 * Response mocks support
 * GZIP encoding
 * Cache support
 * [OkHttp Implementation](http://square.github.io/okhttp/)
* Parsers
  * [Gson parser](https://github.com/google/gson)
 
## Setup

Add the following lines to your `build.gradle`:

    repositories {
      jcenter()
    }

    dependencies {
      implementation 'com.jdroidtools:jdroid-java-http-okhttp:X.Y.Z'
    }

Replace the X.Y.Z by the [latest version](https://github.com/maxirosson/jdroid-java-http/releases/latest)

## Donations
Help us to continue with this project:

[![Donate](https://www.paypalobjects.com/en_US/i/btn/btn_donate_LG.gif)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=2UEBTRTSCYA9L)
