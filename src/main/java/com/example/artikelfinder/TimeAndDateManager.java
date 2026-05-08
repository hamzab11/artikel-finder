package com.example.artikelfinder;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeAndDateManager {
    public String getCurrentTime() {
        SimpleDateFormat stf = new SimpleDateFormat("HH:mm:ss");
        return stf.format(new Date());
    }

    public String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yyyy");
        return sdf.format(new Date());
    }
}
