package edu.epam.shape.entity;

import edu.epam.shape.observer.Observable;
import edu.epam.shape.observer.Observer;
import edu.epam.shape.observer.impl.QuadrangleObserver;

public class Quadrangle extends Shape implements Observable<QuadrangleObserver> {
    private EntryPoint a;
    private EntryPoint b;
    private EntryPoint c;
    private EntryPoint d;
    private Observer<Quadrangle> observer;

    public Quadrangle(EntryPoint a, EntryPoint b, EntryPoint c, EntryPoint d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public EntryPoint getA() {
        return a;
    }

    public void setA(EntryPoint a) {
        this.a = a;
        notifyObserver();
    }

    public EntryPoint getB() {
        return b;
    }

    public void setB(EntryPoint b) {
        this.b = b;
        notifyObserver();
    }

    public EntryPoint getC() {
        return c;
    }

    public void setC(EntryPoint c) {
        this.c = c;
        notifyObserver();
    }

    public EntryPoint getD() {
        return d;
    }

    public void setD(EntryPoint d) {
        this.d = d;
        notifyObserver();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Rectangle{");
        sb.append("a=").append(a);
        sb.append(", b=").append(b);
        sb.append(", c=").append(c);
        sb.append(", d=").append(d);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void attach(QuadrangleObserver observer) {
            this.observer = observer;
    }

    @Override
    public void detach(QuadrangleObserver observer) {
            this.observer = null;
    }

    @Override
    public void notifyObserver() {
            if(observer != null) {
                observer.performedArea(this);
                observer.performedPerimeter(this);
            }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quadrangle quadrangle = (Quadrangle) o;
        return a.equals(quadrangle.a) && b.equals(quadrangle.b) && c.equals(quadrangle.c) && d.equals(quadrangle.d);
    }

    @Override
    public int hashCode() {
        int hash = ((a == null) ? 0 : a.hashCode());
        hash = hash * 31 + ((b == null) ? 0 : b.hashCode());
        hash = hash * 31 + ((c == null) ? 0 : c.hashCode());
        hash = hash * 31 + ((d == null) ? 0 : d.hashCode());
        return hash;
    }
}
