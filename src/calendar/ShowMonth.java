package calendar;

import java.util.List;

public class ShowMonth {

    public void generate(String[][] year, int month, List<Happenings> meetingSet) {
        int i;
        int day = 0;
        int eventsMonth = 0;
        java.util.Calendar cal = java.util.Calendar.getInstance();
        for (i = 0; (i < meetingSet.size() && !(meetingSet.isEmpty())); i++) {
            cal.setTime(meetingSet.get(i).getDate());
            eventsMonth = cal.get(java.util.Calendar.MONTH);
            day = cal.get(java.util.Calendar.DAY_OF_MONTH);
            if (eventsMonth + 1 == month) {
                break;
            }
        }
        GenerateMonthPlate m = new GenerateMonthPlate();
        m.generatePlate(month);
        for (int j = 0; j < year[month - 1].length; j++) {
            if ((j + 1) % 7 == 0) {
                System.out.print(j + 1);
                if ((eventsMonth + 1 == month) && (j + 1 == day)) {
                    if (j < 9) {
                        System.out.print("!  ");
                    } else {
                        System.out.print("! ");
                    }
                    if (i != meetingSet.size() - 1) {
                        i = i + 1;
                        cal.setTime(meetingSet.get(i).getDate());
                        day = cal.get(java.util.Calendar.DAY_OF_MONTH);
                        eventsMonth = cal.get(java.util.Calendar.MONTH);
                    }
                } else {
                    if (j < 9) {
                        System.out.print("   ");
                    } else {
                        System.out.print("  ");
                    }
                }
                System.out.println();
            } else {
                System.out.print(j + 1);
                if ((eventsMonth + 1 == month) && (j + 1 == day)) {
                    if (j < 9) {
                        System.out.print("!  ");
                    } else {
                        System.out.print("! ");
                    }
                    if (i != meetingSet.size() - 1) {
                        i = i + 1;
                        cal.setTime(meetingSet.get(i).getDate());
                        day = cal.get(java.util.Calendar.DAY_OF_MONTH);
                        eventsMonth = cal.get(java.util.Calendar.MONTH);
                    }
                } else {
                    if (j < 9) {
                        System.out.print("   ");
                    } else {
                        System.out.print("  ");
                    }
                }
                if (j + 1 == year[month - 1].length) {
                    System.out.println();
                    m.generateDescription(meetingSet, month);
                }
            }
        }
    }
}