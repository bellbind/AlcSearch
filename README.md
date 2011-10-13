# What is this

Example App for Android Intent receive/send

See:

- AndroidManifest.xml
- src/net/bellbind/alcsearch/AlcSearch.java

# Build Setup

    git clone https://github.com/bellbind/AlcSearch.git
    cd AlcSearch
    cp build.properties.default build.properties
    android update project --path

# Build and debug install

    ant compile
    ant debug
    ant install

# Usage

- Select text on the browser
- "Share" to "ALC/Eijiro" then browser open the Eijiro page of the text

# Uninstall debug version

    ant uninstall

# Appendix: Making release apk

(These are example values in following commands. 
You should prepare your own values of them)

- apk name: Send_to_ALC
- apk package: net.bellbind.alcsearch
- keystore file: release-key.keystore
- keystore alias: bellbind

0. Prepare self-signed keystore (just once)

    keytool -genkey -v -keyalg RSA -keystore release-key.keystore -alias bellbind -validity 10000

1. Build unsigned apk to "bin/Send_to_ALC-unsigned.apk"

    ant release

2. Copy apk file

    cp bin/Send_to_ALC-unsigned.apk bin/Send_to_ALC.apk

3. Sign apk with jarsigner

    jarsigner -keystore release-key.keystore bin/Send_to_ALC.apk bellbind

4. Check signed apk installable

    adb install bin/Send_to_ALC.apk

5. Uninstall signed apk by commandline

    adb uninstall net.bellbind.alcsearch

## Notice: Use JDK6 jarsigner to sign apk

Signed apk with JDK7 jarsigner is NOT accepted by current android os.

"adb install" JDK7-signed apk says as:

    Failure [INSTALL_PARSE_FAILED_NO_CERTIFICATES]

