package calendar;

public class GenerateYear {

    public String[][] generate() {
        GenerateMonth month = new GenerateMonth(); 
        String[][] year = new String[12][];
        for (int i = 0; i < 12; i++) {
            year[i] = month.generate(i + 1);
        }
        return year;
    }
}