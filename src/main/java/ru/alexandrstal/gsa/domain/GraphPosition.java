package ru.alexandrstal.gsa.domain;

import javax.persistence.Embeddable;

@Embeddable
public class GraphPosition {

    private Integer height;
    private Integer width;
    private Integer xposition;
    private Integer yposition;

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getXposition() {
        return xposition;
    }

    public void setXposition(Integer xposition) {
        this.xposition = xposition;
    }

    public Integer getYposition() {
        return yposition;
    }

    public void setYposition(Integer ypositipn) {
        this.yposition = ypositipn;
    }
}
