package calendar;

import java.util.Comparator;

public class CompareDate implements Comparator<Happenings> {

    @Override
    public int compare(Happenings o1, Happenings o2) {
         return o1.getDate().compareTo(o2.getDate());
    }
}
