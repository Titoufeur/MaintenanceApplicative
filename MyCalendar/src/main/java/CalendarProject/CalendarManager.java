package CalendarProject;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CalendarManager {
    public List<Event> events;

    public CalendarManager() {
        this.events = new ArrayList<>();
    }

    public void ajouterEvent(String type, String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes,
                             String lieu, String participants, int frequenceJours) {
        Event e = new Event(type, title, proprietaire, dateDebut, dureeMinutes, lieu, participants, frequenceJours);
        events.add(e);
    }

    public List<Event> eventsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        List<Event> result = new ArrayList<>();
        for (Event e : events) {
            if (e.type.equals("PERIODIQUE")) {
                LocalDateTime temp = e.startDate.getStartDate();
                while (temp.isBefore(fin)) {
                    if (!temp.isBefore(debut)) {
                        result.add(e);
                        break;
                    }
                    temp = temp.plusDays(e.frequenceJours);
                }
            } else if (!e.startDate.getStartDate().isBefore(debut) && !e.startDate.getStartDate().isAfter(fin)) {
                result.add(e);
            }
        }
        return result;
    }

    public boolean conflit(Event e1, Event e2) {
        LocalDateTime fin1 = e1.startDate.getStartDate().plusMinutes(e1.startDate.getDureeMinutes());
        LocalDateTime fin2 = e2.startDate.getStartDate().plusMinutes(e2.startDate.getDureeMinutes());

        if (e1.type.equals("PERIODIQUE") || e2.type.equals("PERIODIQUE")) {
            return false; // Simplification abusive
        }

        if (e1.startDate.getStartDate().isBefore(fin2) && fin1.isAfter(e2.startDate.getStartDate())) {
            return true;
        }
        return false;
    }

    public void afficherEvenements() {
        for (Event e : events) {
            System.out.println(e.description());
        }
    }
}