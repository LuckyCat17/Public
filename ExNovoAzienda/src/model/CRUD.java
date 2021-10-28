package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import view.Vista;

public class CRUD implements ICRUD {

    ArrayList<Persona> azienda = new ArrayList<Persona>();
    Vista view = new Vista();

    @Override
    public void inserisci(Persona p) {
        azienda.add(p);
    }

    @Override
    public void modifica(int indice, Persona p) {
        azienda.set(indice, p);
    }

    @Override
    public void elimina(int indice) {
        azienda.remove(indice);

    }

    @Override
    public ArrayList<Persona> leggi() {
        return azienda;
    }

    @Override
    public Persona leggi(int indice) {
        return azienda.get(indice);

    }

    @Override
    public Persona duplica(Persona p) {
        Persona x = null;
        if (p instanceof Dipendente && !(p instanceof Manager) && !(p instanceof Dirigente)) {
            x = new Dipendente();
        } else if (p instanceof Manager && !(p instanceof Dirigente)) {
            x = new Manager();
        } else if (p instanceof Dirigente) {
            x = new Dirigente();
        }
        x.setId(p.getId());
        x.setNome(p.getNome());
        x.setCognome(p.getCognome());
        x.setDataDiNascita(p.getDataDiNascita());
        if (p instanceof Dipendente) {
            ((Dipendente) x).setStipendio(((Dipendente) p).getStipendio());
        }
        if (p instanceof Manager) {
            ((Manager) x).setAreaDiResponsabilita(((Manager) p).getAreaDiResponsabilita());
        }
        if (p instanceof Dirigente) {
            ((Dirigente) x).setLivelloFunzionale(((Dirigente) p).getLivelloFunzionale());
        }
        return x;
    }

    @Override
    public boolean carica() {
        Persona p = null;
        try (BufferedReader bw = new BufferedReader(new FileReader("azienda.dat"))) {
            String linea = bw.readLine();
            while (linea != null) {
                String[] attributi = linea.split(",");
                if (attributi.length == 7) {
                    p = new Dirigente();
                }
                if (attributi.length == 6) {
                    p = new Manager();
                }
                if (attributi.length == 5) {
                    p = new Dipendente();
                }
                p.setId(Integer.parseInt(attributi[0]));
                p.setNome(attributi[1]);
                p.setCognome(attributi[2]);
                p.setDataDiNascita(view.dataInserimento(attributi[3]));
                if (p instanceof Dipendente) {
                    ((Dipendente) p).setStipendio(Double.parseDouble(attributi[4]));
                }
                if (p instanceof Manager) {
                    ((Manager) p).setAreaDiResponsabilita(attributi[5]);
                }
                if (p instanceof Dirigente) {
                    ((Dirigente) p).setLivelloFunzionale(attributi[6]);
                }
                inserisci(p);
                linea = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean salva() {
        try (FileWriter fw = new FileWriter("azienda.dat")) {
            for (int i = 0; i < azienda.size(); i++) {
                fw.write(azienda.get(i).toString() + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public CRUD() {
        carica();
        if (carica() == true) {
            view.visualizzaStringa("File caricato con successo");
        }
    }

}
