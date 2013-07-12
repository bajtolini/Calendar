package calendar;

import java.util.List;
import java.util.Calendar;

public class Show {

    public void generate(String[][] year, List<Happenings> meetingSet) {
        int x = 0;
        int day;
        int month;
        Calendar cal = Calendar.getInstance();
        if (meetingSet.isEmpty()) {
            day = month = 40;
        } else {
            cal.setTime(meetingSet.get(x).getDate());
            day = cal.get(Calendar.DAY_OF_MONTH);
            month = cal.get(Calendar.MONTH);
        }
        GenerateMonthPlate m = new GenerateMonthPlate();
        for (int i = 0; i < 12; i++) {
            m.generatePlate(i + 1);
            for (int j = 0; j < year[i].length; j++) {
                if ((j + 1) % 7 == 0) {
                    System.out.print(j + 1);
                    if ((i == month) && (j + 1 == day)) {
                        if (j < 9) {
                            System.out.print("!  ");
                        } else {
                            System.out.print("! ");
                        }
                        if (x != meetingSet.size() - 1) {
                            x = x + 1;
                            cal.setTime(meetingSet.get(x).getDate());
                            day = cal.get(Calendar.DAY_OF_MONTH);
                            month = cal.get(Calendar.MONTH);
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
                    if ((i == month) && (j + 1 == day)) {
                        if (j < 9) {
                            System.out.print("!  ");
                        } else {
                            System.out.print("! ");
                        }
                        if (x != meetingSet.size() - 1) {
                            x = x + 1;
                            cal.setTime(meetingSet.get(x).getDate());
                            day = cal.get(Calendar.DAY_OF_MONTH);
                            month = cal.get(Calendar.MONTH);
                        }
                    } else {
                        if (j < 9) {
                            System.out.print("   ");
                        } else {
                            System.out.print("  ");
                        }
                    }
                }
                if (j + 1 == year[i].length) {
                    System.out.println();
                    m.generateDescription(meetingSet, i + 1);
                }
            }
            System.out.println();
        }
    }

    /* pierwsza wersja przed dodaniem list
     * GenerateMonthPlate m = new GenerateMonthPlate();
     * for (int i = 0; i < 12; i++) {
     *     m.generatePlate(i + 1);
     *     for (int j = 0; j < year[i].length; j++) {
     *         if ((j + 1) % 7 == 0) {
     *             System.out.print(j + 1);
     *             m.generateSign(year[i][j], j + 1);
     *             System.out.println();
     *         } else {
     *             System.out.print(j + 1);
     *             m.generateSign(year[i][j], j + 1);
     *         }
     *         if (j + 1 == year[i].length) {
     *             System.out.println();
     *         }
     *     }
     *     m.generateDescription(MeetingSet, i + 1);
     * }
     */
}