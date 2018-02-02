package ru.alexandrstal.gsa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class GraphRelation {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Graph from;

    @ManyToOne
    private Graph to;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Graph getFrom() {
        return from;
    }

    public void setFrom(Graph from) {
        this.from = from;
    }

    public Graph getTo() {
        return to;
    }

    public void setTo(Graph to) {
        this.to = to;
    }
}
