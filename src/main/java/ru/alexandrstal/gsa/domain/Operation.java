package ru.alexandrstal.gsa.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Operation {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String code;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "operation")
    Set<Operation2Document> documentSet = new HashSet<>();

    @OneToMany( mappedBy = "operation")
    Set<Operation2Letter> letterSet = new HashSet<>();

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Document> getDocuments() {
        Set<Document> documents = new HashSet<>();
        for (Operation2Document operation2Document: documentSet) {
            documents.add(operation2Document.getDocument());
        }
        return documents;
    }

    public Set<Letter> getLetters() {
        Set<Letter> letters = new HashSet<>();
        for (Operation2Letter operation2Letter: letterSet) {
            letters.add(operation2Letter.getLetter());
        }
        return letters;
    }

}
