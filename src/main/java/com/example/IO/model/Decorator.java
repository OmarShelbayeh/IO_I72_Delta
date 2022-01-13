package com.example.IO.model;

import java.util.ArrayList;

public abstract class Decorator implements Component{

    protected final Component component;

    public Decorator(Component component) {
        this.component = component;
    }
}
