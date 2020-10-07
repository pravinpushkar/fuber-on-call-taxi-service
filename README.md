# fuber-on-call-taxi-service

# Execute below commands to test the taxi registration and booking

```

curl -X POST http://localhost:8080/register/taxi/taxiId/1/taxitype/NORMAL
curl -X POST http://localhost:8080/register/taxi/taxiId/2/taxitype/PINK


curl -X POST http://localhost:8080/update/taxilocation/taxiId/1/xcord/0/ycord/0
curl -X POST http://localhost:8080/update/taxilocation/taxiId/2/xcord/0/ycord/0

curl -X POST http://localhost:8080/book/trip/x1/0/y1/0/x2/2/y2/2

```