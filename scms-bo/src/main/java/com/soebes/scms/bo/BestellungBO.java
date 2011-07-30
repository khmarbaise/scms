package com.soebes.scms.bo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = TabellenNamen.BESTELLUNG)
public class BestellungBO extends BaseBO {
    private KundeBO kunde;
    private FilialeBO filiale;
    private PizzaBO pizza;
    private Date bestellDatum;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name = "fk_kunde")
    public KundeBO getKunde() {
        return kunde;
    }

    public void setKunde(KundeBO kunde) {
        this.kunde = kunde;
    }
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name = "fk_filiale")
    public FilialeBO getFiliale() {
        return filiale;
    }

    public void setFiliale(FilialeBO filiale) {
        this.filiale = filiale;
    }
    public Date getBestellDatum() {
        return bestellDatum;
    }
    public void setBestellDatum(Date bestellDatum) {
        this.bestellDatum = bestellDatum;
    }

    public void setPizza(PizzaBO pizza) {
        this.pizza = pizza;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name = "fk_pizza")
    public PizzaBO getPizza() {
        return pizza;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((bestellDatum == null) ? 0 : bestellDatum.hashCode());
        result = prime * result + ((filiale == null) ? 0 : filiale.hashCode());
        result = prime * result + ((kunde == null) ? 0 : kunde.hashCode());
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
        BestellungBO other = (BestellungBO) obj;
        if (bestellDatum == null) {
            if (other.bestellDatum != null)
                return false;
        } else if (!bestellDatum.equals(other.bestellDatum))
            return false;
        if (filiale == null) {
            if (other.filiale != null)
                return false;
        } else if (!filiale.equals(other.filiale))
            return false;
        if (kunde == null) {
            if (other.kunde != null)
                return false;
        } else if (!kunde.equals(other.kunde))
            return false;
        return true;
    }

}
