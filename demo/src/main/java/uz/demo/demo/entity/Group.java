package uz.demo.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "group1")
public class Group implements Serializable {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;
      @Column(name = "type")
      private String type;


    public void setId(Long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }



    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }


}
