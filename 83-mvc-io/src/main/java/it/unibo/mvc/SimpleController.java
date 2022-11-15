package it.unibo.mvc;

import java.util.*;
import java.lang.*;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private final List<String> history;
    private int index;

    public SimpleController(){
        this.history = new ArrayList<>();
        this.index=0;
    }

    @Override
    public void setString(String s) {
        // TODO Auto-generated method stub
        history.add(s);
        this.index=history.indexOf(s);
    }

    @Override
    public String getString() {
        // TODO Auto-generated method stub
        return this.history.get(this.index);
    }

    @Override
    public List<String> getHistory() {
        // TODO Auto-generated method stub
        List<String> all = new ArrayList<>();
        all.addAll(this.history);
        return all;
    }

    @Override
    public void printString() throws IllegalStateException {
        // TODO Auto-generated method stub
        if(this.history.get(this.index).equals(null) || this.history.get(this.index).equals("")) {
            throw new IllegalStateException("the string is unset");
        }
        else {
            System.out.println(this.history.get(this.index));
        }
    }

}
