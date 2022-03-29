package uz.demo.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Dictionary implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String  uz;
    private String  en;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUz() {
        return uz;
    }

    public void setUz(String uz) {
        this.uz = uz;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }


}
