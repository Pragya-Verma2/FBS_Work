#include <stdio.h>

struct Time {
    int hour;
    int min;
    int sec;
};

int main() {
    struct Time now, alarm;

    // Example: hardcoded time
    now.hour = 14;
    now.min = 30;
    now.sec = 45;

    printf("Current Time: %02d:%02d:%02d\n", now.hour, now.min, now.sec);

    // Input another time from user
    printf("Enter alarm time (hour min sec): ");
    scanf("%d %d %d", &alarm.hour, &alarm.min, &alarm.sec);

    printf("Alarm Time: %02d:%02d:%02d\n", alarm.hour, alarm.min, alarm.sec);

    return 0;
}
