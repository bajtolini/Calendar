package calendar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Calendar {

    public static void main(String[] args) throws IOException {
        //przerobione zostaly tylko pozycje 4 z menu, pozycja 1 (dodac wypisywanie znakow w kalendarzu przy uzyciu listy)
        //deklarowanie listy obiektow (meetingow)
        List<Happenings> meetingSet = new ArrayList<>();
        //pytania do petli
        String loop = "N";
        Scanner sreading = new Scanner(System.in);
        //generowanie kalendarza
        String[][] calendar = new String[12][];
        GenerateYear year = new GenerateYear();
        calendar = year.generate();
        //deklaracja zmiennej do pytan z menu
        Scanner scanner = new Scanner(System.in);
        int answear = 20;
        //odczyt z pliku (mozna pozniej dodac do klasy
        try {
            BufferedReader file = new BufferedReader(new FileReader("out.txt"));
            String CurrentLine;
            while ((CurrentLine = file.readLine()) != null) {
                if (CurrentLine.contains("event")) {
                    meetingSet.add(new Meeting());
                    meetingSet.get(meetingSet.size() - 1).setDescription(CurrentLine);
                    CurrentLine = file.readLine();
                    meetingSet.get(meetingSet.size() - 1).setDate(CurrentLine);
                } else if (CurrentLine.contains("birthday")) {
                    meetingSet.add(new Birthday());
                    meetingSet.get(meetingSet.size() - 1).setDescription(CurrentLine);
                    CurrentLine = file.readLine();
                    meetingSet.get(meetingSet.size() - 1).setDate(CurrentLine);
                }
            }
        } catch (FileNotFoundException t) {
            System.out.println("file not found");
        }
        //rozpoczecie glownej czesci programu menu
        while (loop.equals("N")) {
            System.out.println("Write number of the operation which You want to execute:");
            System.out.println("1.Show entire calendar,"); //dziala
            System.out.println("2.Show precize month,"); //dziala
            System.out.println("3.Show how many days left to the next events,"); //dziala
            System.out.println("4.Add event,"); //dziala
            System.out.println("5.Erase event,"); //dziala
            answear = scanner.nextInt();
            //rozpatrzenie odpowiedzi uzytkownika
            if (answear == 1) {
                Show show = new Show();
                show.generate(calendar, meetingSet);
            } else if (answear == 2) {
                ShowMonth show = new ShowMonth();
                int sanswear;
                Scanner tscanner = new Scanner(System.in);
                System.out.println("Which month would You like to see?");
                sanswear = tscanner.nextInt();
                show.generate(calendar, sanswear, meetingSet);
            } else if (answear == 3) {
                ClosestEvent closest = new ClosestEvent();
                closest.generate(meetingSet);
            } else if (answear == 4) {
                /* wczesniejsza wersja (teraz jest dodawanie do listy)
                 * Event2 add = new Event2();
                 * add.generate(calendar);
                 */
                String event = "";
                while (!event.contains("birthday") && !event.contains("event")) {
                    System.out.println("Type in what type of event you would like to add (birthday/event):");
                    Scanner escanner = new Scanner(System.in);
                    event = escanner.nextLine();
                    event = event.toLowerCase();
                    if (event.equals("birthday")) {
                        System.out.println("Type in date at which you would like to add event (mm-dd):");
                        String date;
                        Scanner dscanner = new Scanner(System.in);
                        date = dscanner.nextLine();
                        System.out.println("Write the description of the Birthday (whose birthday is it, etc.)");
                        Scanner cscanner = new Scanner(System.in);
                        String content = "2013-" + date + " 20:00 - birthday - " + cscanner.nextLine();
                        meetingSet.add(new Birthday());
                        int index = meetingSet.size() - 1;
                        meetingSet.get(index).setDate(date);
                        meetingSet.get(index).setDescription(content);
                    } else if (event.equals("event")) {
                        System.out.println("Type in date at which you would like to add event(yyyy-mm-dd hh:MM):");
                        String date;
                        Scanner dscanner = new Scanner(System.in);
                        date = dscanner.nextLine();
                        System.out.println("Write the description of the event");
                        Scanner cscanner = new Scanner(System.in);
                        String content = date + " - event - " + cscanner.nextLine();
                        meetingSet.add(new Meeting());
                        int index = meetingSet.size() - 1;
                        meetingSet.get(index).setDate(date);
                        meetingSet.get(index).setDescription(content);
                    } else {
                        System.out.println("Type your answear once again.");
                    }
                }
                Collections.sort(meetingSet, new CompareDate());
            } else if (answear == 5) {
                ErasingEvent erase = new ErasingEvent();
                erase.generate(meetingSet);
            }
            System.out.println("End? Y/N");
            try {
                loop = sreading.nextLine();
                loop = loop.toUpperCase();
            } catch (InputMismatchException r) {
                System.out.println("Write Y/N!");
                loop = "N";
            }
            if (loop.equals("Y")) {
                SimpleDateFormat dateformatEvent = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                SimpleDateFormat dateformatBirthday = new SimpleDateFormat("MM-dd");
                File writing = new File("out.txt");
                // tworzy plik jezeli nie istnieje i zapisuje wszystko z listy
                if (!writing.exists()) {
                    writing.createNewFile();
                }
                FileWriter fw = new FileWriter(writing.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                for (int i = 0; i < meetingSet.size(); i++) {
                    bw.write(meetingSet.get(i).getDescription());
                    if (meetingSet.get(i).getDescription().contains("event")) {
                        bw.newLine();
                        bw.write(new String(dateformatEvent.format(meetingSet.get(i).getDate())));
                        bw.newLine();
                    } else if (meetingSet.get(i).getDescription().contains("birthday")) {
                        bw.newLine();
                        bw.write(new String(dateformatBirthday.format(meetingSet.get(i).getDate())));
                        bw.newLine();
                    }
                }
                bw.close();
            }
        }
    }
}