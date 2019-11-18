package ch.zhaw.gpi;

import java.util.Date;

public class GreetingServiceImpl implements GreetingService {

    @Override
    public String getGreetingWithDate(String message) {
        return "You entered: " + message + " on " + new Date();
    }

    
}

