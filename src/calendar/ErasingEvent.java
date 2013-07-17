package calendar;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ErasingEvent {

    public void generate(List<Happenings> meetingSet) {
        int tday = 0, tmonth = 0;
        while (tday == 0 && tmonth == 0) {
            System.out.println("At what date do you want to erase event? (dd-mm)");
            Scanner reading = new Scanner(System.in);
            Pattern p = Pattern.compile("(\\d+{0,1})(\\-)(\\d+{0,1})");
            String date = reading.nextLine();
            Matcher m = p.matcher(date);
            if (m.find()) {
                tday = Integer.parseInt(m.group(1));
                tmonth = Integer.parseInt(m.group(3));
            }
        }
        for (int i = 0; i < meetingSet.size(); i++) {
            java.util.Calendar cal = java.util.Calendar.getInstance();
            cal.setTime(meetingSet.get(i).getDate());
            int day = cal.get(java.util.Calendar.DAY_OF_MONTH);
            int month = cal.get(java.util.Calendar.MONTH) + 1;
            if ((tday == day) && (tmonth == month)) {
                System.out.println(meetingSet.get(i).getDescription());
                System.out.println("Is this the event you want to erase? y/n");
                Scanner reading = new Scanner(System.in);
                String answear = reading.nextLine();
                answear = answear.toLowerCase();
                if (answear.equals("y")) {
                    meetingSet.remove(i);
                }
            }
        }
    }
}