package ru.alexandrstal.gsa.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Graph implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Embedded
    private GraphPosition position;

    @OneToMany(mappedBy = "from")
    private Set<GraphRelation> from = new HashSet<>();

    @OneToMany(mappedBy = "to")
    private Set<GraphRelation> to  = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GraphPosition getPosition() {
        return position;
    }

    public void setPosition(GraphPosition position) {
        this.position = position;
    }

    public Set<GraphRelation> getFrom() {
        return from;
    }

    public void setFrom(Set<GraphRelation> from) {
        this.from = from;
    }

    public Set<GraphRelation> getTo() {
        return to;
    }

    public void setTo(Set<GraphRelation> to) {
        this.to = to;
    }
}


