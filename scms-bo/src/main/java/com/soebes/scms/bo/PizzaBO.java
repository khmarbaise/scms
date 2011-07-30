package com.soebes.scms.bo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Die Pizza
 *
 * @author Karl Heinz Marbaise
 *
 */
@Entity
@Table(name = TabellenNamen.PIZZA)
public class PizzaBO extends BaseBO {
    private PizzaGroesseBO pizzaGroesse;
    private List<ZutatBO> zutatenListe;

    @OneToOne
    @JoinColumn(name = "fk_pizza_groesse")
    public PizzaGroesseBO getPizzaGroesse() {
        return pizzaGroesse;
    }
    public void setPizzaGroesse(PizzaGroesseBO pizzaGroesse) {
        this.pizzaGroesse = pizzaGroesse;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "zutaten_liste"
    )
    public List<ZutatBO> getZutatenListe() {
        return zutatenListe;
    }
    public void setZutatenListe(List<ZutatBO> zutatenListe) {
        this.zutatenListe = zutatenListe;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((pizzaGroesse == null) ? 0 : pizzaGroesse.hashCode());
        result = prime * result
                + ((zutatenListe == null) ? 0 : zutatenListe.hashCode());
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
        PizzaBO other = (PizzaBO) obj;
        if (pizzaGroesse == null) {
            if (other.pizzaGroesse != null)
                return false;
        } else if (!pizzaGroesse.equals(other.pizzaGroesse))
            return false;
        if (zutatenListe == null) {
            if (other.zutatenListe != null)
                return false;
        } else if (!zutatenListe.equals(other.zutatenListe))
            return false;
        return true;
    }

}
