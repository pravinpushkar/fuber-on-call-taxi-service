# fuber-on-call-taxi-service
[![FOSSA Status](https://app.fossa.com/api/projects/git%2Bgithub.com%2Fpravinpushkar%2Ffuber-on-call-taxi-service.svg?type=shield)](https://app.fossa.com/projects/git%2Bgithub.com%2Fpravinpushkar%2Ffuber-on-call-taxi-service?ref=badge_shield)


# Execute below commands to test the taxi registration and bookings

```

curl -X POST http://localhost:8080/register/taxi/taxiId/1/taxitype/NORMAL
curl -X POST http://localhost:8080/register/taxi/taxiId/2/taxitype/PINK


curl -X POST http://localhost:8080/update/taxilocation/taxiId/1/xcord/0/ycord/0
curl -X POST http://localhost:8080/update/taxilocation/taxiId/2/xcord/0/ycord/0

curl -X POST http://localhost:8080/book/trip/x1/0/y1/0/x2/2/y2/2

curl -X POST http://localhost:8080/update/trip/endtrip/taxiId/1

```

## License
[![FOSSA Status](https://app.fossa.com/api/projects/git%2Bgithub.com%2Fpravinpushkar%2Ffuber-on-call-taxi-service.svg?type=large)](https://app.fossa.com/projects/git%2Bgithub.com%2Fpravinpushkar%2Ffuber-on-call-taxi-service?ref=badge_large)
