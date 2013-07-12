package calendar;

import java.util.*;
import java.text.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClosestEvent {

    public void generate(List<Happenings> meetingSet) {
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("MM-dd");
        String date = format.format(now);
        int tmonth = 0, tday = 0;
        while (tmonth == 0 && tday == 0) {
            Pattern p = Pattern.compile("(\\d+{0,1})(\\-)(\\d+{0,1})");
            Matcher m = p.matcher(date);
            if (m.find()) {
                tmonth = Integer.parseInt(m.group(1));
                tday = Integer.parseInt(m.group(3));
            }
        }
        for (int i = 0; i < meetingSet.size(); i++) {
            java.util.Calendar cal = java.util.Calendar.getInstance();
            cal.setTime(meetingSet.get(i).getDate());
            int day = cal.get(java.util.Calendar.DAY_OF_MONTH);
            if (tmonth - 1 < cal.get(java.util.Calendar.MONTH)) {
                int ddifference;
                if (day > tday) {
                    ddifference = day - tday;
                } else {
                    ddifference = tday - day;
                }
                int mdifference = (cal.get(java.util.Calendar.MONTH) + 1) - tmonth;
                System.out.println(meetingSet.get(i).getDescription() + " month left:" + mdifference + " days left:" + ddifference);
            } else if (tmonth - 1 > cal.get(java.util.Calendar.MONTH)) {
                int ddifference;
                if (day > tday) {
                    ddifference = day - tday;
                } else {
                    ddifference = tday - day;
                }
                int mdifference = (12 - tmonth) + cal.get(java.util.Calendar.MONTH) + 1;
                int ydifference = cal.get(java.util.Calendar.YEAR) - 2013;
                if (ydifference != 0) {
                    System.out.println(meetingSet.get(i).getDescription() + " month left:" + mdifference + " days left:" + ddifference);
                }
            } else {
                int ddifference;
                if (day > tday) {
                    ddifference = day - tday;
                } else {
                    ddifference = tday - day;
                }
                int mdifference = 0;
                System.out.println(meetingSet.get(i).getDescription() + "|| month left:" + mdifference + "|| days left:" + ddifference);
            }
        }
        /*
         Date now = new Date();
         SimpleDateFormat format = new SimpleDateFormat("MM-dd");
         String date = format.format(now);
         Scanner reading = new Scanner(System.in);
         int x = 0, y = 0;
         while (x == 0 && y == 0) {
         Pattern p = Pattern.compile("(\\d+{0,1})(\\-)(\\d+{0,1})");
         Matcher m = p.matcher(date);
         if (m.find()) {
         x = Integer.parseInt(m.group(1));
         y = Integer.parseInt(m.group(3));
         }
         }
         Search count = new Search();
         int result = count.generate(calendar, y, x, false);
         if (result == 666) {
         System.out.println("The next event/birthday is TODAY!");
         } else if ((result > 0) && (result != 666)) {
         System.out.println("The next event/birthday will be in: " + result);
         } else {
         result = count.generate(calendar, y, x, true);
         if (result > 0) {
         System.out.println("The next event/birthday will be in: " + result);
         } else if (result == 0) {
         System.out.println("There aren't any events nor birthday in your calendar");
         }
         }
         */
    }
}
