# What is this

Example App for Android Intent receive/send

See:

- AndroidManifest.xml
- src/net/bellbind/alcsearch/AlcSearch.java

# Application Usage

- Select text on the browser
- "Share" to "ALC/Eijiro" then browser open the Eijiro page of the text

# Development with android-sdk

## Build Setup

    git clone https://github.com/bellbind/AlcSearch.git
    cd AlcSearch
    cp build.properties.default build.properties
    android update project --path .

## Build and debug install

    ant compile
    ant debug
    ant install

## Uninstall debug version

    ant uninstall

# How to prepare icons

The icons are made by launcher icon generator of 
[Android Asset Studio](http://android-ui-utils.googlecode.com/hg/asset-studio/dist/index.html).

# Appendix: Making release apk

(These are example values in following commands. 
You should prepare your own values of them)

- apk name: Send_to_ALC
- apk package: net.bellbind.alcsearch
- keystore file: release-key.keystore
- keystore alias: bellbind

## Prepare self-signed keystore (just once)

    keytool -genkey -v -keyalg RSA -keystore release-key.keystore -alias bellbind -validity 10000

## Building signed apk

Build unsigned apk to "bin/Send_to_ALC-unsigned.apk":

    ant release

Copy apk file:

    cp bin/Send_to_ALC-unsigned.apk bin/Send_to_ALC.apk

Sign apk with jarsigner:

    jarsigner -keystore release-key.keystore bin/Send_to_ALC.apk bellbind

## Handling signed apk

Check signed apk as installable. 

Install signed apk by commandline:

    adb install bin/Send_to_ALC.apk

Uninstall signed apk by commandline:

    adb uninstall net.bellbind.alcsearch

## Notice: Do not use JDK7 jarsigner command to sign apk

Use JDK6 jarsigner command.

Signed apk with JDK7 jarsigner is NOT accepted by current android os.

"adb install" JDK7-signed apk says as:

    Failure [INSTALL_PARSE_FAILED_NO_CERTIFICATES]

## License

Copyright (c) 2011 [bellbind](http://twitter.com/bellbind)
Released under MIT licenses.