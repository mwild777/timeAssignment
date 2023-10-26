public class Time {
    private int hour;
    private int minute;
    private int second;
    public Time() {
        this.hour = 0;
        this. minute = 0;
        this. second = 0;
    }
    public Time(int h, int m, int s) {
        this.hour = h;
        this.minute = m;
        this.second = s;
    }
    public void increment(int secondsToAdd) {
        this.hour =  this.hour + secondsToAdd / 3600;
        if (this.hour >= 24) {
            this.hour = this.hour - 24;
        }
        this.minute = this.minute + (secondsToAdd % 3600) / 60;
        if (this.minute >= 60) {
            this.minute = this.minute - 60;
            this.hour = this.hour + 1;
        }
        this.second = this.second + secondsToAdd % 60;
        if (this.second >= 60) {
            this.second = this.second - 60;
            this.minute = this.minute + 1;
        }
    }
    public static Time fromString(String string) {
        int hour = Integer.parseInt(string.substring(0,2));
        int minute = Integer.parseInt(string.substring(3,5));
        int second = Integer.parseInt(string.substring(6,8));
        return (new Time(hour, minute, second));
    }
    public void print(boolean tf) {
        if (tf == true) {
            System.out.println(hour + ":" + minute + ":" + second);
        }
        else {
            String amOrPm = " AM";
            if (hour > 12) {
                hour = hour - 12;
                amOrPm = " PM";
            }
            System.out.println(hour + ":" + minute + ":" + second + amOrPm);
        }
    }
}
