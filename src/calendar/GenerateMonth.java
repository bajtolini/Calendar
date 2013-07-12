package calendar;

public class GenerateMonth {

    public String[] generate(int nmonth) {
        String[] month = null;
        if (nmonth == 2) {
            month = new String[28];
        } else if ((nmonth % 2 != 0) && (nmonth < 8)) {
            month = new String[31];
        } else if ((nmonth % 2 == 0) && (nmonth < 8) && (nmonth != 2)) {
            month = new String[30];
        } else if ((nmonth % 2 == 0) && (nmonth > 8)) {
            month = new String[31];
        } else if ((nmonth % 2 != 0) && (nmonth > 8)) {
            month = new String[30];
        } else if (nmonth == 8) {
            month = new String[31];
        }
        for (int i = 0; i < month.length; i++) {
            month[i] = null;
        }
        return month;
    }
}