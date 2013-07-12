package calendar;

public class Search {

    public int generate(String[][] calendar, int tday, int tmonth, boolean poczatek) {
        //zmienna boolean decyduje czy ma liczyc od poczatku czy od dnia dzisiejszego do konca (false do konca)
        int count = 0;
        boolean condition = false;
        if (calendar[tmonth - 1][tday - 1] != null) {
            count = 666;
        }
        if ((poczatek == false) && (calendar[tmonth - 1][tday - 1] == null)) {
            for (int i = tmonth - 1; ((i < 12) && (condition == false)); i++) {
                for (int j = tday - 1; ((j < calendar[i].length) && (i == tmonth - 1) && (condition == false)); j++) {
                    if (calendar[i][j] == null) {
                        count = count + 1;
                    } else {
                        condition = true;
                    }
                }
                for (int j = 0; ((j < calendar[i].length) && (i != tmonth - 1) && (condition == false)); j++) {
                    if (calendar[i][j] == null) {
                        count = count + 1;
                        if ((i == 11) && (j == 30)) {
                            count = 0;
                        }
                    } else {
                        condition = true;
                    }
                }
            }
        } else if ((poczatek == true) && (calendar[tmonth - 1][tday - 1] == null)) {
            for (int i = tmonth - 1; i < 12; i++) {
                for (int j = tday - 1; ((j < calendar[i].length) && (i == tmonth - 1)); j++) {
                    count = count + 1;
                }
                for (int j = 0; ((j < calendar[i].length) && (i != tmonth - 1)); j++) {
                    count = count + 1;
                }
            }
            for (int i = 0; ((i < tmonth) && (condition == false)); i++) {
                for (int j = 0; ((j < calendar[i].length) && (condition == false)); j++) {
                    if (calendar[i][j] == null) {
                        count = count + 1;
                    } else {
                        condition = true;
                    }
                }
            }
        }
        return count;
    }
}
