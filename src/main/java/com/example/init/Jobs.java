package com.example.init;

import java.util.Calendar;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import st.tool.FormatCalendar;

@Component
public class Jobs {
public final static long ONE_Minute =  60 * 1000;
    
    @Scheduled(fixedDelay=ONE_Minute)
    public void fixedDelayJob(){
        System.out.println(FormatCalendar.format(Calendar.getInstance())+" >>fixedDelay执行....");
    }
    
    @Scheduled(fixedRate=ONE_Minute)
    public void fixedRateJob(){
        System.out.println(FormatCalendar.format(Calendar.getInstance())+" >>fixedRate执行....");
    }

    @Scheduled(cron="0 15 3 * * ?")
    public void cronJob(){
        System.out.println(FormatCalendar.format(Calendar.getInstance())+" >>cron执行....");
    }
}
