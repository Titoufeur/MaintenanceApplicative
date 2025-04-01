package CalendarProject;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CalendarManager calendar = new CalendarManager();
        Scanner scanner = new Scanner(System.in);
        boolean continuer = true;

        while (continuer) {
            System.out.println(" .--..--..--..--..--..--..--..--..--..--..--..--..--..--..--..--..--..--..--..--. ");
            System.out.println("/ .. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\");
            System.out.println("\\ \\/\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ \\/ /");
            System.out.println(" \\/ /`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'\\/ / ");
            System.out.println(" / /\\                                                                        / /\\ ");
            System.out.println("/ /\\ \\   ██████╗ █████╗ ██╗     ███████╗███╗   ██╗██████╗  █████╗ ██████╗   / /\\ \\");
            System.out.println("\\ \\/ /  ██╔════╝██╔══██╗██║     ██╔════╝████╗  ██║██╔══██╗██╔══██╗██╔══██╗  \\ \\/ /");
            System.out.println(" \\/ /   ██║     ███████║██║     █████╗  ██╔██╗ ██║██║  ██║███████║██████╔╝   \\/ / ");
            System.out.println(" / /\\   ██║     ██╔══██║██║     ██╔══╝  ██║╚██╗██║██║  ██║██╔══██║██╔══██╗   / /\\ ");
            System.out.println("/ /\\ \\  ╚██████╗██║  ██║███████╗███████╗██║ ╚████║██████╔╝██║  ██║██║  ██║  / /\\ \\");
            System.out.println("\\ \\/ /   ╚═════╝╚═╝  ╚═╝╚══════╝╚══════╝╚═╝  ╚═══╝╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝  \\ \\/ /");
            System.out.println(" \\/ /                                                                        \\/ / ");
            System.out.println(" / /\\   ███╗   ███╗ █████╗ ███╗   ██╗ █████╗  ██████╗ ███████╗██████╗        / /\\ ");
            System.out.println("/ /\\ \\  ████╗ ████║██╔══██╗████╗  ██║██╔══██╗██╔════╝ ██╔════╝██╔══██╗      / /\\ \\");
            System.out.println("\\ \\/ /  ██╔████╔██║███████║██╔██╗ ██║███████║██║  ███╗█████╗  ██████╔╝      \\ \\/ /");
            System.out.println(" \\/ /   ██║╚██╔╝██║██╔══██║██║╚██╗██║██╔══██║██║   ██║██╔══╝  ██╔══██╗       \\/ / ");
            System.out.println(" / /\\   ██║ ╚═╝ ██║██║  ██║██║ ╚████║██║  ██║╚██████╔╝███████╗██║  ██║       / /\\ ");
            System.out.println("/ /\\ \\  ╚═╝     ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝╚═╝  ╚═╝      / /\\ \\");
            System.out.println("\\ \\/ /                                                                      \\ \\/ /");
            System.out.println(" \\/ /                                                                        \\/ / ");
            System.out.println(" / /\\.--..--..--..--..--..--..--..--..--..--..--..--..--..--..--..--..--..--./ /\\ ");
            System.out.println("/ /\\ \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\.. \\/\\ \\");
            System.out.println("\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `'\\ `' /");
            System.out.println(" `--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--'`--' ");
            System.out.println("=== Gestionnaire d'Événements ===");
            System.out.println("1 - Ajouter un rendez-vous personnel");
            System.out.println("2 - Ajouter une réunion");
            System.out.println("3 - Ajouter un événement périodique");
            System.out.println("4 - Afficher les événements dans une période");
            System.out.println("5 - Supprimer un événement par ID");
            System.out.println("6 - Quitter");
            System.out.print("Votre choix : ");
            String choix = scanner.nextLine();

            switch (choix) {
                case "1":
                    // Rendez-vous personnel
                    try {
                        System.out.print("Titre : ");
                        String titreStr = scanner.nextLine();
                        EventTitle titre = new EventTitle(titreStr);

                        System.out.print("Date et heure de début (yyyy-MM-ddTHH:mm) : ");
                        String dateStr = scanner.nextLine();
                        LocalDateTime dt = LocalDateTime.parse(dateStr);
                        EventDate date = new EventDate(dt);

                        System.out.print("Durée en minutes : ");
                        int dureeInt = Integer.parseInt(scanner.nextLine());
                        EventDuration duree = new EventDuration(dureeInt);

                        EventId id = EventId.generate();
                        PersonalMeeting rdv = new PersonalMeeting(id, titre, date, duree);
                        calendar.ajouterEvenement(rdv);
                        System.out.println("Événement ajouté avec ID : " + id.toString());
                    } catch (Exception e) {
                        System.out.println("Erreur: " + e.getMessage());
                    }
                    break;
                case "2":
                    // Réunion
                    try {
                        System.out.print("Titre : ");
                        String titreStr2 = scanner.nextLine();
                        EventTitle titre2 = new EventTitle(titreStr2);

                        System.out.print("Date et heure de début (yyyy-MM-ddTHH:mm) : ");
                        String dateStr2 = scanner.nextLine();
                        LocalDateTime dt2 = LocalDateTime.parse(dateStr2);
                        EventDate date2 = new EventDate(dt2);

                        System.out.print("Durée en minutes : ");
                        int dureeInt2 = Integer.parseInt(scanner.nextLine());
                        EventDuration duree2 = new EventDuration(dureeInt2);

                        System.out.print("Lieu : ");
                        String lieuStr = scanner.nextLine();
                        EventPlace eventPlace = new EventPlace(lieuStr);

                        System.out.print("Participants (séparés par des virgules) : ");
                        String participantsStr = scanner.nextLine();
                        String[] parts = participantsStr.split(",");
                        ArrayList<Participant> list = new ArrayList<>();
                        for(String part : parts) {
                            list.add(new Participant(part.trim()));
                        }
                        Participants participants = new Participants(list);

                        EventId id2 = EventId.generate();
                        Reunion reunion = new Reunion(id2, titre2, date2, duree2, eventPlace, participants);
                        calendar.ajouterEvenement(reunion);
                        System.out.println("Réunion ajoutée avec ID : " + id2.toString());
                    } catch(Exception e) {
                        System.out.println("Erreur: " + e.getMessage());
                    }
                    break;
                case "3":
                    // Événement périodique
                    try {
                        System.out.print("Titre : ");
                        String titreStr3 = scanner.nextLine();
                        EventTitle titre3 = new EventTitle(titreStr3);

                        System.out.print("Date et heure de début (yyyy-MM-ddTHH:mm) : ");
                        String dateStr3 = scanner.nextLine();
                        LocalDateTime dt3 = LocalDateTime.parse(dateStr3);
                        EventDate date3 = new EventDate(dt3);

                        System.out.print("Durée en minutes : ");
                        int dureeInt3 = Integer.parseInt(scanner.nextLine());
                        EventDuration duree3 = new EventDuration(dureeInt3);

                        System.out.print("Fréquence (en jours) : ");
                        int frequenceInt = Integer.parseInt(scanner.nextLine());
                        Frequency frequency = new Frequency(frequenceInt);

                        EventId id3 = EventId.generate();
                        PeriodicEvent ep = new PeriodicEvent(id3, titre3, date3, duree3, frequency);
                        calendar.ajouterEvenement(ep);
                        System.out.println("Événement périodique ajouté avec ID : " + id3.toString());
                    } catch(Exception e) {
                        System.out.println("Erreur: " + e.getMessage());
                    }
                    break;
                case "4":
                    // Afficher les événements dans une période
                    try {
                        System.out.print("Date et heure de début de la période (yyyy-MM-ddTHH:mm) : ");
                        String periodStartStr = scanner.nextLine();
                        LocalDateTime periodStartDt = LocalDateTime.parse(periodStartStr);
                        EventDate periodStart = new EventDate(periodStartDt);

                        System.out.print("Date et heure de fin de la période (yyyy-MM-ddTHH:mm) : ");
                        String periodEndStr = scanner.nextLine();
                        LocalDateTime periodEndDt = LocalDateTime.parse(periodEndStr);
                        EventDate periodEnd = new EventDate(periodEndDt);

                        TimeInterval period = new TimeInterval(periodStart, periodEnd);
                        java.util.List<Event> eventsInPeriod = calendar.getEvenementsDansPeriode(period);
                        if(eventsInPeriod.isEmpty()) {
                            System.out.println("Aucun événement trouvé dans cette période.");
                        } else {
                            eventsInPeriod.forEach(e -> System.out.println(e.description() + " (ID: " + e.getId().toString() + ")"));
                        }
                    } catch(Exception e) {
                        System.out.println("Erreur: " + e.getMessage());
                    }
                    break;
                case "5":
                    // Supprimer un événement
                    System.out.print("Entrez l'ID de l'événement à supprimer : ");
                    String idStr = scanner.nextLine();
                    try {
                        EventId idToRemove = EventId.fromString(idStr);
                        calendar.supprimerEvenement(idToRemove);
                        System.out.println("Événement supprimé.");
                    } catch(Exception e) {
                        System.out.println("Erreur: " + e.getMessage());
                    }
                    break;
                case "6":
                    continuer = false;
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        }
        scanner.close();
    }
}
