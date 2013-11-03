.PHONY : main
main: 
	mvn -q -Dmaven.test.skip=true install android:redeploy android:run

.PHONY : test
test:
	mvn test -q 

.PHONY : kill
kill:
	adb shell "pkill com.meishixing"

.PHONY : launch-main
launchmain:
	adb shell "am start -n com.meishixing.crazysight/.MainActivity"

.PHONY : deploy
deploy:
	mvn android:redeploy

vim:
	echo "1" 1&>2
	echo "0" 1&>2
	echo "-1" 1&>2
	echo "-2" 1&>2
	echo "-3" 1&>2
	echo "-4" 1&>2
	echo "-5" 1&>2
	echo "-6" 1&>2
	echo "-7" 1&>2
	echo "-8" 1&>2
	echo "-9" 1&>2
	echo "-10" 1&>2

.PHONY : release
release:
	mvn install -Psign

.DEFAULT_GOAL := main
