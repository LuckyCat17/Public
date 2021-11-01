package model;

import java.util.HashMap;

public class CRUD implements ICRUD {

    HashMap<Integer, Persona> listaPersone = new HashMap<Integer, Persona>();

    @Override
    public void inserisci(Persona p) {
        listaPersone.put(p.getId(), p);
    }

    @Override
    public void modifica(Integer key, Persona p) {
        listaPersone.put(key, p);
    }

    @Override
    public void elimina(Integer key) {
        listaPersone.remove(key);

    }

    @Override
    public Persona duplica(Persona p) {
        Persona x = null;
        x.setId(p.getId());
        x.setNome(p.getNome());
        x.setCognome(p.getCognome());
        x.setDataDiNascita(p.getDataDiNascita());
        x.setLuogoDiNascita(p.getLuogoDiNascita());
        return x;
    }

    @Override
    public Persona leggi(Integer key) {
        if (listaPersone.containsKey(key)) {
            return listaPersone.get(key);
        } else {
            Persona p = null;
            return p;
        }

    }

    @Override
    public HashMap<Integer, Persona> leggi() {
        return listaPersone;
    }

    public void scorriArray(HashMap<Integer, Persona> temp) {
        for (Integer x : leggi().keySet()) {
            System.out.println(temp.get(x).toString());
        }
    }

}
