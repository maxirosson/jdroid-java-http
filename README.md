# Http Library for Java & Android Apps

## Continuous Integration
|Branch|Status|
| ------------- | ------------- |
|Master|[![Build Status](https://travis-ci.org/maxirosson/jdroid-java-http.svg?branch=master)](https://travis-ci.org/maxirosson/jdroid-java-http)|
|Staging|[![Build Status](https://api.travis-ci.org/maxirosson/jdroid-java-http.svg?branch=staging)](https://travis-ci.org/maxirosson/jdroid-java-http)|
|Production|[![Build Status](https://api.travis-ci.org/maxirosson/jdroid-java-http.svg?branch=production)](https://travis-ci.org/maxirosson/jdroid-java-http)|

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
      implementation 'com.jdroidframework:jdroid-java-http-okhttp:X.Y.Z'
    }

Replace the X.Y.Z by the [latest version](https://github.com/maxirosson/jdroid-java-http/releases/latest)

## Donations
Help us to continue with this project:

[![Donate](https://www.paypalobjects.com/en_US/i/btn/btn_donate_LG.gif)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=2UEBTRTSCYA9L)
