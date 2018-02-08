package ru.alexandrstal.gsa.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@JsonSerialize(using = ru.alexandrstal.gsa.domain.serializer.GraphSerializer.class)
public class Graph {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Node from;

    @NotNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Node to;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Operation operation;

    public Long getId() {
        return id;
    }

    public Node getFrom() {
        return from;
    }

    public void setFrom(Node from) {
        this.from = from;
        from.getFrom().add(this);
    }

    public Node getTo() {
        return to;
    }

    public void setTo(Node to) {
        to.getTo().add(this);
        this.to = to;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
