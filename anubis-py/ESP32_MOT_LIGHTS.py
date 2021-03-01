import time

import machine

print("PIR Module And LED Test (CMD+C to exit)")
time.sleep(2000)
print("Ready...")

ledPinId = 2
pirPinId = 7

while True:
    ledPin = machine.Pin(ledPinId, Pin.OUT)
    pirPin = machine.Pin(pirPinId, Pin.IN)

    ledPin.on()
    print(pirPin.value())
    time.sleep(250)
    ledPin.off()
