package model;

import java.util.ArrayList;

public interface ICRUD {
    public void inserisci(Persona p);

    public void modifica(int indice, Persona p);

    public void elimina(int indice);

    public ArrayList<Persona> leggi();

    public Persona leggi(int indice);

    public Persona duplica(Persona p);

    public boolean carica();

    public boolean salva();

}
