package calendar;

import java.util.List;

public class ShowMonth {

    public void generate(int month, List<Happenings> meetingSet) {
        int i = month - 1;
        int day = 0;
        int eventsMonth = 0;
        java.util.Calendar cal = java.util.Calendar.getInstance();
        int monthlenght = 0;
        if ((i == 0) || (i == 2) || (i == 4) || (i == 6) || (i == 7) || (i == 9) || (i == 11)) {
            monthlenght = 31;
        } else if ((i == 3) || (i == 5) || (i == 8) || (i == 10)) {
            monthlenght = 30;
        } else if (i == 1) {
            monthlenght = 28;
        }
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
        for (int j = 0; j < monthlenght; j++) {
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
                if (j + 1 == monthlenght) {
                    System.out.println();
                    m.generateDescription(meetingSet, month);
                }
            }
        }
    }
}