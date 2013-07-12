package calendar;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Event2 {

    public void generate(String[][] calendar) {
        //pierwsze pytanie
        int day = 0, month = 0;
        while (day == 0 && month == 0) {
            System.out.println("At what date do you want to add event? (dd-mm)");
            Scanner reading = new Scanner(System.in);
            Pattern p = Pattern.compile("(\\d+{0,1})(\\-)(\\d+{0,1})");
            String date = reading.nextLine();
            Matcher m = p.matcher(date);
            if (m.find()) {
                day = Integer.parseInt(m.group(1));
                month = Integer.parseInt(m.group(3));
            }
        }
        //drugie pytanie
        Scanner sreading = new Scanner(System.in);
        String answear = "";
        while (!answear.contains("birthday") && !answear.contains("event")) {
            System.out.println("What type of event do you want to add? Birthday or event?");
            answear = sreading.nextLine();
            answear = answear.toLowerCase();
            if (answear.equals("birthday")) {
                Scanner treading = new Scanner(System.in);
                System.out.println("Write the description of the Birthday (hour, whose birthday is it, etc.)");
                String content = treading.nextLine();
                calendar[month - 1][day - 1] = day + "-" + month + " birthday - " + content;
            } else if (answear.equals("event")) {
                Scanner treading = new Scanner(System.in);
                System.out.println("Write the description of the event (hour, what type of event is it, etc.)");
                String content = treading.nextLine();
                calendar[month - 1][day - 1] = day + "-" + month + " event - " + content;
            } else {
                System.out.println("Type your answear once again.");
            }
        }
    }
}
