package calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Meeting implements Happenings {

    private static final String FORMAT = "yyyy-mm-dd hh:MM";
    private String description;
    private Date date;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(String date) {
        try {
        this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(date);
        } catch (ParseException r) {
            System.out.println("ERROR - ParseException");
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.description);
        hash = 13 * hash + Objects.hashCode(this.date);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT);
        String sDate = (null == this.date ? "" : sdf.format(this.date));
        return "Meeting{" + "description=" + description + ", date=" + sDate + '}';
    }
}
