package com.tcramer.anubis.service;

import com.pi4j.component.lcd.LCDTextAlignment;
import com.pi4j.component.lcd.impl.GpioLcdDisplay;
import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LcdServiceImpl implements LcdService {

    // converting https://www.mbtechworks.com/projects/drive-an-lcd-16x2-display-with-raspberry-pi.html to java
    private static final int LCD_LINE_1 = 0;
    private static final int LCD_LINE_2 = 1;

    @Autowired
    public LcdServiceImpl() {
    }

    @Override
    public String doLcdMessage() throws InterruptedException {
        final GpioController gpio = GpioFactory.getInstance();
        final GpioLcdDisplay lcd =
                new GpioLcdDisplay(2,16, RaspiPin.GPIO_11,RaspiPin.GPIO_10,
                        RaspiPin.GPIO_25, RaspiPin.GPIO_24, RaspiPin.GPIO_23, RaspiPin.GPIO_01);
        final GpioPinDigitalInput myButtons[] = {
                gpio.provisionDigitalInputPin(RaspiPin.GPIO_25, "B1", PinPullResistance.PULL_UP),
                gpio.provisionDigitalInputPin(RaspiPin.GPIO_24, "B2", PinPullResistance.PULL_UP),
                gpio.provisionDigitalInputPin(RaspiPin.GPIO_23, "B3", PinPullResistance.PULL_UP),
                gpio.provisionDigitalInputPin(RaspiPin.GPIO_01, "B4", PinPullResistance.PULL_UP)
        };

        // create and register gpio pin listener
        gpio.addListener(new GpioPinListenerDigital() {
            @Override
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                if(event.getState() == PinState.LOW){
                    lcd.writeln(LCD_LINE_2,  event.getPin().getName() + " PRESSED" , LCDTextAlignment.ALIGN_CENTER);
                }
                else {
                    lcd.writeln(LCD_LINE_2,  event.getPin().getName() + " RELEASED" , LCDTextAlignment.ALIGN_CENTER);
                }
            }
        }, myButtons);

        lcd.clear();
        Thread.sleep(1000);
        lcd.write(LCD_LINE_2, "WAAAAAAAAAAT!!!");
        return "";
    }
}
