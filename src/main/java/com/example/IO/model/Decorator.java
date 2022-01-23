package com.example.IO.model;

/**
 * Class responsible for use defined decorator
 * @version 1.0
 */
public abstract class Decorator implements Component{

    /**
     * Component instance
     */
    protected final Component component;

    /**
     * Constructor
     * @param component - component instance
     */
    public Decorator(Component component) {
        this.component = component;
    }
}
