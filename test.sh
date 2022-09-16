./stop.sh

nohup ./start.sh  > /tmp/test.out 2>&1 &

echo ":::Aguartando start Java:::"
# sleep 5
mvn test

./stop.sh
