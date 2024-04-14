/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parmat.entitylib;

import java.util.ArrayList;

/**
 *
 * @author matthieuparmentier
 */
public class Entity {
    private String name;
    private ArrayList<Property> properties;
    
    public final void setName(String name) throws Exception {
        if (name != null && name.length() > 0 && name.length() <= 50)
            this.name = name;
        else
            throw new Exception("Invalid name.");
    }
    
    public final void setProperties(ArrayList<Property> props) throws Exception {
        if (props == null)
            throw new Exception("Invalid properties.");
        this.properties = props;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Property> getProperties() {
        return properties;
    }
    
    public Entity() throws Exception {
        this.setName("undefined");
        this.setProperties(new ArrayList());
    }
    
    public Entity(String name) throws Exception {
        this.setName(name);
        this.setProperties(new ArrayList());
    }
    
    public Entity(String name, ArrayList<Property> props) throws Exception {
        this.setName(name);
        this.setProperties(props);
    }
    
    public static double testEntityClass() throws Exception {
        int score = 0;
        
        var ent = new Entity();
        assert ent.getName().equals("undefined");
        assert ent.getProperties() != null;
        assert ent.getProperties().isEmpty();
        score++;
        
        ent = new Entity("clients");
        assert ent.getName().equals("clients");
        assert ent.getProperties() != null;
        assert ent.getProperties().isEmpty();
        score++;
        
        ent = new Entity("sales", new ArrayList<>());
        assert ent.getName().equals("sales");
        assert ent.getProperties() != null;
        assert ent.getProperties().isEmpty();
        score++;
        
        return score / 3 * 100;
    }
}
