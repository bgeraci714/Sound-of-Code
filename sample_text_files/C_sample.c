#include <stdio.h>

struct time 
{
    int hours;
    int minutes;
    int seconds;
};

int elapsed_time (struct time tInitial, struct time tFinal)
{
    int convertToSeconds (struct time t);
    int timeDifference, timeFinal, timeInitial;
    
    timeFinal   = convertToSeconds (tFinal);
    timeInitial = convertToSeconds (tInitial); 
    
    if (timeFinal < timeInitial)
        timeDifference = (timeFinal + 24 * 3600) - timeInitial;
    else
        timeDifference = timeFinal - timeInitial;
    
    printf ("timeDifference = %i\n", timeDifference); 
    
    return timeDifference;
}

void convertToHours (int t)
{
    struct time convertedTime;
    convertedTime.hours     = t / 3600;
    convertedTime.minutes   = (t - convertedTime.hours * 3600) / 60;
    convertedTime.seconds   = t % 60;
    
    printf ("The time difference is %.2i/%.2i/%.2i\n", 
            convertedTime.hours, convertedTime.minutes, 
            convertedTime.seconds);  
}


int convertToSeconds (struct time t)
{
    int secondsTotal = t.hours * 3600 + t.minutes * 60 + t.seconds;
    
    return secondsTotal;
}

int main (void)
{
    int elapsed_time (struct time tInitial, struct time tFinal);
    int convertToSeconds (struct time t);
    void convertToHours (int t);
    
    struct time t1 = {  0, 46, 13 };
    struct time t2 = { 16,  2,  6 }; 
    
    int timeDiff;
    
    timeDiff = elapsed_time (t1, t2); 
    
    convertToHours (timeDiff);
    
    
    return 0;
}

