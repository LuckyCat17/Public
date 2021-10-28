package view;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import model.*;
import java.util.ArrayList;

public class Vista {

    public void menu() {
        System.out.println("1)Inserisci ");
        System.out.println("2)Modifica ");
        System.out.println("3)Elimina ");
        System.out.println("4)Trova ");
        System.out.println("5)Stampa elenco ");
        System.out.println("6)Stampa scheda ");
        System.out.println("7)Salva ed esci ");
    }

    public void menuTipo() {
        System.out.println("1)Dipendente");
        System.out.println("2)Manager");
        System.out.println("3)Dirigente");
    }

    public void mascheraInserimento(Persona p) {
        p.setNome(leggiStringa("Inserisci il nome: "));
        p.setCognome(leggiStringa("Inserisci il cognome: "));
        p.setDataDiNascita(dataInserimento(leggiStringa("Inserisci la data xx/xx/xxxx: ")));
        if (p instanceof Dipendente) {
            ((Dipendente) p).setStipendio(leggiDecimale("Inserisci lo stipendio: "));
        }
        if (p instanceof Manager) {
            ((Manager) p).setAreaDiResponsabilita(leggiStringa("Inserisci area di responsabilita: "));
        }
        if (p instanceof Dirigente) {
            ((Dirigente) p).setLivelloFunzionale(leggiStringa("Inserisci livello funzionale: "));
        }
    }

    public void mascheraModifica(Persona p) {
        String nuovoVal = "";

        nuovoVal = leggiStringa("Nome:[ " + p.getNome() + " ]");
        if (!nuovoVal.equals("")) {
            p.setNome(nuovoVal);
        }
        nuovoVal = leggiStringa("Cognome:[ " + p.getCognome() + " ]");
        if (!nuovoVal.equals("")) {
            p.setCognome(nuovoVal);
        }
        nuovoVal = leggiStringa("Data di nascita:[ " + p.getDataDiNascita() + " ]");
        if (!nuovoVal.equals("")) {
            p.setDataDiNascita(dataInserimento(nuovoVal));
        }
        if (p instanceof Dipendente) {
            nuovoVal = leggiStringa("Stipendio:[ " + ((Dipendente) p).getStipendio() + " ]");
            if (!nuovoVal.equals("")) {
                ((Dipendente) p).setStipendio(Double.parseDouble(nuovoVal));
            }
        }
        if (p instanceof Manager) {
            nuovoVal = leggiStringa("Area di responsabilita:[ " + ((Manager) p).getAreaDiResponsabilita() + " ]");
            if (!nuovoVal.equals("")) {
                ((Manager) p).setAreaDiResponsabilita(nuovoVal);
            }
        }
        if (p instanceof Dirigente) {
            nuovoVal = leggiStringa("Livello funzionale:[ " + ((Dirigente) p).getLivelloFunzionale() + " ]");
            if (!nuovoVal.equals("")) {
                ((Dirigente) p).setLivelloFunzionale(nuovoVal);
            }
        }
    }

    public Date dataInserimento(String data) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d = null;
        try {
            d = sdf.parse(data);

        } catch (Exception e) {
            d = null;
            e.printStackTrace();
        }
        return d;
    }

    public void scorriArray(ArrayList<Persona> temp) {
        for (int i = 0; i < temp.size(); i++) {
            System.out.println(temp.get(i).toString());
        }
    }

    public int leggiIntero(String messaggio) {
        Scanner input = new Scanner(System.in);
        int numero;
        System.out.print("|" + messaggio);
        numero = Integer.parseInt(input.nextLine());
        return numero;
    }

    public double leggiDecimale(String messaggio) {
        Scanner input = new Scanner(System.in);
        double numero;
        System.out.print("|" + messaggio);
        numero = Double.parseDouble(input.nextLine());
        return numero;
    }

    public String leggiStringa(String messaggio) {
        Scanner input = new Scanner(System.in);
        String stringa;
        System.out.print("|" + messaggio);
        stringa = input.nextLine();
        return stringa;
    }

    public void visualizzaStringa(String messaggio) {
        System.out.println(messaggio);
    }

}
