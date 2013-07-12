package calendar;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class GenerateMonthPlate {

    public void generatePlate(int month) {
        if (month == 1) {
            System.out.println("January");
        } else if (month == 2) {
            System.out.println("February");
        } else if (month == 3) {
            System.out.println("March");
        } else if (month == 4) {
            System.out.println("April");
        } else if (month == 5) {
            System.out.println("May");
        } else if (month == 6) {
            System.out.println("June");
        } else if (month == 7) {
            System.out.println("July");
        } else if (month == 8) {
            System.out.println("August");
        } else if (month == 9) {
            System.out.println("September");
        } else if (month == 10) {
            System.out.println("October");
        } else if (month == 11) {
            System.out.println("November");
        } else if (month == 12) {
            System.out.println("December");
        }
    }

    public void generateSign(String value, int day) {
        //funkcja nie uzywana przy listach
        if (value == null) {
            System.out.print("  ");
        } else if (value.contains("*"/*przed listami bylo tutaj "event"*/)) {
            System.out.print("* ");
        } else if (value.contains("^"/*przed listami bylo tutaj "birthday"*/)) {
            System.out.print("^ ");
        }
        if (day < 10) {
            System.out.print(" ");
        }
    }

    public void generateDescription(List<Happenings> meetingSet, int month) {
        for (int i = 0; i < meetingSet.size(); i++) {
            java.util.Calendar cal = java.util.Calendar.getInstance();
            cal.setTime(meetingSet.get(i).getDate());
            int eventsMonth = cal.get(cal.MONTH);
            int eventsDay = cal.get(cal.DAY_OF_MONTH);
            for (int j = 1; j < 32; j++) {
                //wyciagnac z date-a miesiac i porownac liczby!!!!
                if ((eventsMonth == month - 1) && (eventsDay == j)) {
                    System.out.println(meetingSet.get(i).getDescription());
                }
            }
        }
        /*pierwsza wersja w ktorej nie bylo listy 
         * for (int i = 0; i < month.length; i++) {
         *     try {
         *     if (month[i].contains("event")) {
         *         System.out.println(month[i]);
         *     } else if (month[i].contains("birthday")) {
         *         System.out.println(month[i]);
         *     }
         *     } catch (NullPointerException y) {
         *     }
         * }
         * System.out.println();
         */
    }
}