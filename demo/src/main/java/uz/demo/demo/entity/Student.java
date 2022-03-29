package uz.demo.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name ="bu_student")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(min = 3 , max = 255)
    @Column(name = "name")
    private  String name ;

    @ManyToOne
    private Group typeId ;

    @OneToOne
    @NotNull
    @JoinColumn(name = "account_id" , unique = true )
    private Account accountId;

    @OneToMany
    private Set<Book> bookIds;

    @ManyToMany
    private List<Subject> subjectIds;

    public List<Subject> getSubjectIds() {
        return subjectIds;
    }



    public void setSubjectIds(List<Subject> subjectIds) {
        this.subjectIds = subjectIds;
    }

    public Set<Book> getBookIds() {
        return bookIds;
    }



    public void setBookIds(Set<Book> bookIds) {
        this.bookIds = bookIds;
    }

    public void setId(Long id) {
        this.id = id;
    }





    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }


    public Group getTypeId() {
        return typeId;
    }

    public void setTypeId(Group typeId) {
        this.typeId = typeId;
    }



    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


}
