/*
 *   Tyler Weatherby
 *   Created: January  30, 2017
 *   Updated: December 29, 2017
 *   Miltary time is the codes internal standard.
 *   It calculates Regular Time from Military Time.
 *   Hours range from 0000 to 2359
 *   Regular time display is possible
 */
package clock;
import java.util.*;


public class Clock
{
    // Member variables
    private int hour; // Tracks the current hour in milTime
    private int minute; // Tracks the current Minute
    private boolean isPM; // Tracks whether it is AM/PM
     
    // Constructors, must set in Military Time
    public Clock()
    {
        // Default Constructor sets time to 1200 or 12:00PM
        hour = 12;
        minute = 0;
        isPM = true;
    }
    public Clock(int h)
    {
        // If only hour specified, sets to HH:00 (AM/PM)
        // If hour is invalid will set to 1200 or 12:00PM
        setHour(h);
    }
    public Clock(int h, int m)
    {
        // Sets time when hour and minute specified
        setTime(h, m);
    }
    public Clock(int h, int m, boolean AMPM)
    {
        setHour(h);
        setMinute(m);
        setPM(AMPM);
    }
    // Methods -- milTime will be standard
    // Setters
    public void setTime(int h, int m)
    {
        setHour(h);
        setMinute(m);
    }
    public void setHour(int h)
    {
        hour = h;
        minute = 0;
        if (hour > 23 || hour < 0)
        {
            hour = 12;
            isPM = true;
            }
        else
        {
        // Nothing needs to happen if true.
        }     
        changePM(hour);
    }
    public void setMinute(int m)
    {
        minute = m;
        if (minute > 59 || minute < 0)
        {
            minute = 0;
        }
        changePM(hour);
    }
    public void setPM(boolean AMPM)
    {
        if (AMPM == false)
        {
            isPM = false;
            if (hour > 11)
            {
                hour -= 12;
            }
        }
        else
        {
            isPM = true;
            if (hour <= 11)
            {
                hour += 12;
            }
        }
    }

    // Getters
    public String getRegTime()
    {
        int regHour = hour;
        String AMPM = new String("");
        if (hour >= 12)
        {
            regHour -= 12;
            AMPM = "PM";
        }
        else
        {
            AMPM = "AM";
        }
        if(regHour == 0)
        {
            regHour = 12;
        }
        // String time = new String(regHour + ":" + String.format("%02d",minute) + AMPM);  
        String time = new String(String.format("%1$2s", regHour) + ":" + String.format("%02d", minute) + AMPM);  
        return time;
    }
    public String getMilTime()
    {
        String time = new String(String.format("%02d", hour) + "" + String.format("%02d", minute));
        return time;
    }
    public boolean getPM()
    {
        return isPM;
    }
    // Mutators
    public void addTime(int h, int m)
    {
        addHour(h);
        addMinute(m);
    }
    public void subTime(int h, int m)
    {
        subHour(h);
        subMinute(m);
    }
    public void addHour(int h)
    {
        if(h >= 0)
        {
            hour += h;
            hour = hour % 24;
        }
        if (h < 0)
        {
            subHour(-1 * h);
        }
        changePM(hour);
    }
    public void addMinute(int m)
    {
        if (m >= 0)
        {
            minute += m;            
            int hoursLeft = 0;
            hoursLeft = minute/60;
            minute = minute % 60;
            addHour(hoursLeft);
        }
        if (m < 0)
        {
           subMinute(-1 * m);
        }  
    }
    public void subMinute(int m)
    {
        if(m < 0)
        {
            addMinute(-1 * m);   
        }
        else
        {
        int hoursLeft = 0;    
        minute -= m;
        while (minute < 0)
        {
            hoursLeft += 1;
            minute += 60;
        }
        subHour(hoursLeft);
        }
    }
    public void subHour(int h)
    {
        if(h < 0)
        {
            addHour(-1 * h);
        }
        else
        {
        hour -= h;
        hour = hour % 24;
        if (hour < 0)
        {
            hour += 24;
        }
        changePM(hour);
        }
    }
        private void changePM(int h)
    {
        if (h >= 12)
        {
            isPM = true;
        }
        else
        {
            isPM = false;
        }
    }
}
