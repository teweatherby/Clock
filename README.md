# Clock

## Constructors
* public Clock()

Constructing an object with no parameters creates an object set to 1200 or 12:00 PM

* public Clock(int h)

Constructing an object with one integer (0-23) creates an object set to HH00 or HH:00 (AM/PM)
If initialized outside of normal boundaries the object will set itself to 1200 or 12:00 PM

* public Clock(int h, int m)

Constructing an object with two integers (0-23, 0-59) creates an object set to HHMM or HH:MM (AM/PM)
If initialized outside of normal boundaries the object variables will set themselves to 12:00 PM

* public Clock(int h, int m, bool AMPM)

## Setters
* public void setTime(int h, int m)

This function will set the time to the specified hour, minute integer.
Anything out of bounds will set the time to 1200 or 12:00 PM

* public void setHour(int h)

This function will set the hour to the specified integer (0-23).
Anything out of bounds will set the hour to 12:MM PM.

* public void setMinute(int m)

This function will set the minute to the specified integer (0-59).
Anything out of bounds will be set to HH:00 (AM/PM)

* public void setPM(boolean AMPM)

This function will set the clock to AM or PM based on input.
False = AM, True = PM

The difference between this function and setPM is this: changePM is meant to operate internally with the arithmetic to determine whether it is AM or PM.

setPM is meant to give the user an option to set the clock to AM or PM without affecting the current time.

## Getters
* public String getRegTime()

This function converts the variables into a readable 12 hour clock.

* public String getMilTime()

This function converts the variables into a readable 2400 hour clock.

* public boolean getPM()

This function will return whether is reading out AM (0/false) or PM (1/true)

## Mutators
* public void addHour(int h)

This function takes in an integer value, and adds it to the clocks hours. This function considers the possibility that someone would want to add negative hours to the clock.

* public void addMinute(int m)

This function takes in an integer value and subtracts it from the clocks minutes. This function considers the possibility that someone would want to add negative minutes to the clock.

* public void subHour(int h)

This function takes in an integer value and subtracts it from the clocks hours. This function considers the possibility that someone would want to subtract negative hours.

* public void subMinute(int m)

This function takes in an integer value and subtracts it from the clocks minutes. This function considers the possibility someone would want to subtract negative minutes.

* public void addTime(int h, int m)

This function takes in two integer values for the hour and minute respectively. It will then add the values to the hour and minute values of the clock. This function considers the possibility of adding negative integers.

* public void subTime(int h, int m)

This function takes in two integer values for the hour and minute respectively. It will then subtract the values from the hour and minute values of the clock. This function considers the possibility of subtracting negative integers.

* private void changePM(int h)

This function takes in the current hour of the object and decides if it’s PM.
If h for hours is 12 through 23, it is considered PM.

The difference between this function and setPM is this: changePM is meant to operate internally with the arithmetic to determine whether it is AM or PM.

setPM is meant to give the user an option to set the clock to AM or PM without affecting the current time.
