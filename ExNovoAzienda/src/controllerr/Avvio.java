package controllerr;

import model.*;
import view.Vista;

public class Avvio {
    public static void main(String[] args) {
        Persona p = null;
        CRUD crud = new CRUD();
        Vista view = new Vista();
        int scelta = 0;
        int cercaID;
        String risposta;
        int id = 1;

        do {
            view.menu();
            scelta = view.leggiIntero("Inserisci l'azione da fare: ");
            while (scelta > 7 || scelta <= 0) {
                scelta = view.leggiIntero("Scegli un numero compreso tra 1 e 7");
            }
            switch (scelta) {
            case 1:
                view.menuTipo();
                int scelta2 = view.leggiIntero("Cosa vuoi inserire?");
                switch (scelta2) {
                case 1:
                    p = new Dipendente();
                    break;
                case 2:
                    p = new Manager();
                    break;
                case 3:
                    p = new Dirigente();
                    break;
                }
                if (crud.leggi().size() >= 1) {
                    id = crud.leggi(crud.leggi().size() - 1).getId() + 1;
                }
                p.setId(id);
                view.mascheraInserimento(p);
                crud.inserisci(p);
                id++;
                break;
            case 2:
                int i;
                boolean trovato = false;
                cercaID = view.leggiIntero("Inserisci L'ID da modificare: ");
                for (i = 0; i < crud.leggi().size(); i++) {
                    if (cercaID == crud.leggi(i).getId()) {
                        trovato = true;
                        view.visualizzaStringa(crud.leggi(i).toString());
                        break;
                    }
                }
                if (trovato) {
                    System.out.println(p);
                    view.mascheraModifica(crud.duplica(crud.leggi(i)));
                    risposta = view.leggiStringa("Vuoi modificare la persona? Si/No ");
                    if (risposta.equalsIgnoreCase("si")) {
                        System.out.println(p);
                        crud.modifica(i, p);
                    } else if (risposta.equalsIgnoreCase("no")) {
                        view.visualizzaStringa("Modifica annullata, premi invio");
                        System.out.println(p);
                    }
                } else {
                    view.visualizzaStringa("ID non trovato, premi invio per continuare");
                }
                break;
            case 3:
                boolean trovatoE = false;
                cercaID = view.leggiIntero("Inserisci L'ID: ");
                int c;
                for (c = 0; c < crud.leggi().size(); c++) {
                    if (cercaID == crud.leggi(c).getId()) {
                        trovatoE = true;
                        break;
                    }
                }
                if (trovatoE) {
                    risposta = view.leggiStringa("Sei sicuro di voler eliminare il seguente? " + crud.leggi(c));
                    if (risposta.equalsIgnoreCase("si")) {
                        crud.elimina(c);
                        view.visualizzaStringa("Eliminato!");
                    } else {
                        view.visualizzaStringa("Non eliminato, premi invio per continuare");
                        break;
                    }
                }
                break;
            case 4:
                boolean trovatoT = false;
                cercaID = view.leggiIntero("Inserisci l'ID da trovare: ");
                int x;
                for (x = 0; x < crud.leggi().size(); x++) {
                    if (cercaID == crud.leggi(x).getId()) {
                        trovatoE = true;
                        break;
                    }
                }
                if (trovatoT) {
                    view.visualizzaStringa("Trovato! " + crud.leggi(x).toString());
                } else {
                    view.visualizzaStringa("ID sbagliato o non trovato ");
                }
                break;
            case 5:
                view.scorriArray(crud.leggi());
                break;
            case 6:
                break;
            case 7:
                crud.salva();
                break;

            }

        } while (scelta != 7);

    }
}