package model;

import java.util.Date;

public class Dipendente extends Persona {
    private double stipendio;

    public Dipendente() {
        super();
    }

    public Dipendente(int id, String nome, String cognome, Date dataDiNascita, double stipendio) {
        super(id, nome, cognome, dataDiNascita);
        this.stipendio = stipendio;
    }

    @Override
    public String toString() {
        return super.toString() + "," + stipendio;
    }

    public double getStipendio() {
        return stipendio;
    }

    public void setStipendio(double stipendio) {
        this.stipendio = stipendio;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(stipendio);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Dipendente other = (Dipendente) obj;
        if (Double.doubleToLongBits(stipendio) != Double.doubleToLongBits(other.stipendio))
            return false;
        return true;
    }

}
