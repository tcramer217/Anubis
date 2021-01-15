#!/usr/bin/python
import sys
import Adafruit_DHT

humidity, temperature = Adafruit_DHT.read_retry(11, 4)

fTemp = (temperature * 1.8) + 32
print fTemp
print humidity
