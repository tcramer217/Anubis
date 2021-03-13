#!/usr/bin/python
import Adafruit_DHT

humidity, temperature = Adafruit_DHT.read_retry(11, 4)

tempF = (temperature * 1.8) + 32
print(tempF)
print(humidity)
