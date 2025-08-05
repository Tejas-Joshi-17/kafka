rm -rf ./logs/*.*

# Kill any running jmeter-testing process
PID=$(ps -ef | grep "delivery-service-kafka" | grep -v grep | awk '{print $2}')
if [[ -n $PID ]]; then
  kill -9 "$PID"
  echo "Already Running Process Stopped ..."
else
  echo "Ready to Build Project"
fi

source "/home/tejas-joshi/Documents/Software/Sdkman/bin/sdkman-init.sh"
sdk use java 17.0.12-oracle
sdk use gradle 8.10.2

gradle clean build

source setenv.sh

#cp -r ./cfg ./build/libs
#cp -r ./docker-start.sh ./build/libs
cp -r ./src/main/resources/application.properties ./build/libs
cp -r ./src/main/resources/logback-spring.xml ./build/libs

java -jar -Dspring.application.name="delivery-service-kafka" ./build/libs/delivery-service-1.0.1.jar