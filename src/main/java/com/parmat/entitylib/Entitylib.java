/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.parmat.entitylib;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matthieuparmentier
 */
public class Entitylib {

    public static void main(String[] args) {
        try {
            System.out.println("Attribute class score: " + Attribute.testAttibuteClass() + "%");
            System.out.println("Property class score: " + Property.testProperty() + "%");
            System.out.println("Entity class score: " + Entity.testEntityClass() + "%");
        } catch (Exception ex) {
            Logger.getLogger(Entitylib.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
