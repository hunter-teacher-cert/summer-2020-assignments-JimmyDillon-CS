public class Time {

    public static void main(String[] args) {
	/*
The point of this exercise is to (1) use some of the arithmetic operators, and (2) start thinking about compound entities (like time of day) that are represented with multiple values.

1. Create a new program called Time.java. From now on, we won’t remind you to start with a small, working program, but you should.
2. Following the example program in Section 2.4, create variables named hour, minute, and second. Assign values that are roughly the current time. Use a 24-hour clock so that at 2pm the value of hour is 14.
3. Make the program calculate and display the number of seconds since midnight.
4. Calculate and display the number of seconds remaining in the day.
5. Calculate and display the percentage of the day that has passed. You might run into problems when computing percentages with integers, so consider using floating-point.
6. Change the values of hour, minute, and second to reflect the current time. Then write code to compute the elapsed time since you started working on this exercise.

Hint: You might want to use additional variables to hold values during the computation. Variables that are used in a computation but never displayed are sometimes called “intermediate” or “temporary” variables.
	*/

	int start_hour = 17;
	int start_minute = 18;
	int start_second = 5;
	int end_hour = 17;
	int end_minute = 30;
	int end_second 10;

	int seconds_since_midnight = hour * 60 * 60 + minutes * 60 + seconds;
	int daily_seconds = 24 * 60 * 60;
	int seconds_remaining = daily_seconds - seconds_since-midnight;
	float percentage_passed = seconds_since_midnight / (daily_seconds) * 100;

	int start_sec = start_hour * 60 * 60 + start_minute * 60 + start_second;
	int end_sec = end_hour * 60 * 60 + end_minute * 60 + end_second;
	int delta_time = start_sec - end_sec;
	
	System.out.println("It has been " + seconds_since_midnight + " seconds since midnight.");
        System.out.println("There are " + seconds_remaining + " seconds remaining in the day.");
	System.out.println("Percentage of the day that has passed: " + percentage_passed);
        System.out.println(delta_time + " seconds have passed since you started this program");
    }
}
