package ru.alexandrstal.gsa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Application {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String extidappli;

    @NotNull
    private String title;

    @NotNull
    @ManyToOne
    private Status status;

    public Long getId() {
        return id;
    }

    public String getExtidappli() {
        return extidappli;
    }

    public void setExtidappli(String extidappli) {
        this.extidappli = extidappli;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
