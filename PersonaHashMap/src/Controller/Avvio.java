package Controller;

import model.CRUD;
import model.Persona;
import view.Vista;

public class Avvio {
    public static void main(String[] args) {
        Vista view = new Vista();
        CRUD crud = new CRUD();
        Persona p;
        int scelta;
        Integer id = 1;
        Integer cercaKey;

        do {
            view.menu();
            scelta = view.leggiIntero("Scegli l'azione da eseguire");
            while (scelta <= 0 || scelta > 6) {
                scelta = view.leggiIntero("Devi scegliere un azione compresa tra 1 e 6");
            }
            switch (scelta) {
            case 1:
                Persona p1 = new Persona();
                if (crud.leggi().size() >= 1) {
                    id = crud.leggi().size() + 1;
                }
                p1.setId(id);
                view.mascheraInserimento(p1);
                crud.inserisci(p1);
                id++;
                break;
            case 2:
                cercaKey = view.leggiIntero("Inserisci l'ID da modificare");
                String risposta;
                boolean trovato = false;
                Integer x = null;
                for (Integer k : crud.leggi().keySet()) {
                    if (crud.leggi(k).getId() == cercaKey) {
                        trovato = true;
                        x = k;
                    }
                }
                if (trovato) {
                    p = crud.duplica(crud.leggi(x));
                    view.mascheraModifica(p);
                    risposta = view.leggiStringa("Sicuro di voler modificare? (si/no): ");
                    if (risposta.equalsIgnoreCase("si")) {
                        crud.modifica(x, p);
                    } else {
                        System.out.println("Modifica annullata");
                    }
                } else {
                    System.out.println("ID non trovato");
                }
                break;
            case 3:
                boolean trovatoElimina = false;
                Integer xElimina = null;
                xElimina = view.leggiIntero("Inserisci l'ID da eliminare: ");
                for (Integer k : crud.leggi().keySet()) {
                    if (crud.leggi(k).getId() == xElimina) {
                        trovatoElimina = true;
                        xElimina = k;
                    }
                }
                p = crud.leggi(xElimina);
                if (trovatoElimina) {
                    String rispostaElimina1 = view.leggiStringa("Sei sicuro di voler eliminare? si/no");
                    if (rispostaElimina1.equals("si")) {
                        crud.elimina(xElimina);
                        System.out.println("Eliminato!");
                    } else {
                        System.out.println("Eliminato!");
                    }
                }
                break;
            case 4:
                boolean caseTrovato = false;
                Integer cercaTrovato = null;
                cercaTrovato = view.leggiIntero("Inserisci l'ID da trovare ");
                for (Integer k : crud.leggi().keySet()) {
                    if (crud.leggi(k).getId() == cercaTrovato) {
                        caseTrovato = true;
                        cercaTrovato = k;
                    }
                }
                p = crud.leggi(cercaTrovato);
                if (caseTrovato) {
                    crud.leggi(cercaTrovato).toString();
                }
            case 5:
                crud.scorriArray(crud.leggi());
                break;
            case 6:
                view.schedaDipendente(crud.leggi());
            }
        } while (scelta != 7);
    }
}
