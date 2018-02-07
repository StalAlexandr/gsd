package ru.alexandrstal.gsa.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Node implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Embedded
    private Position position;

    @OneToMany(mappedBy = "from")
    private Set<Graph> from = new HashSet<>();

    @OneToOne(cascade = CascadeType.PERSIST)
    Status status;

    @OneToMany(mappedBy = "to")
    private Set<Graph> to  = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Set<Graph> getFrom() {
        return from;
    }

    public void setFrom(Set<Graph> from) {
        this.from = from;
    }

    public Set<Graph> getTo() {
        return to;
    }

    public void setTo(Set<Graph> to) {
        this.to = to;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}


