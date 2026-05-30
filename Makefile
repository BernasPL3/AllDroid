APP_NAME=AllDroid

build:
	gradle assembleDebug

release:
	gradle assembleRelease

clean:
	gradle clean

apk:
	find . -name "*.apk"

install:
	adb install app/build/outputs/apk/debug/app-debug.apk

run: build apk
