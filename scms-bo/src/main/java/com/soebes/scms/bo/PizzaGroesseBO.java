package com.soebes.scms.bo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = TabellenNamen.PIZZA_GROESSE)
public class PizzaGroesseBO extends BaseBO {
    private String bezeichnung;

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((bezeichnung == null) ? 0 : bezeichnung.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PizzaGroesseBO other = (PizzaGroesseBO) obj;
        if (bezeichnung == null) {
            if (other.bezeichnung != null)
                return false;
        } else if (!bezeichnung.equals(other.bezeichnung))
            return false;
        return true;
    }
}
