/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

/**
 *
 * @author user
 */
public class DemandeStage {
    
    private int iddemande;
    private String etat;
    private int idstage;
    private int idpersonne;

    public DemandeStage() {
    }
    
    

    public DemandeStage(int iddemande, String etat, int idstage, int idpersonne) {
        this.iddemande = iddemande;
        this.etat = etat;
        this.idstage = idstage;
        this.idpersonne = idpersonne;
    }

    public DemandeStage(String etat, int idstage, int idpersonne) {
        this.etat = etat;
        this.idstage = idstage;
        this.idpersonne = idpersonne;
    }

    public int getIddemande() {
        return iddemande;
    }

    public void setIddemande(int iddemande) {
        this.iddemande = iddemande;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public int getIdstage() {
        return idstage;
    }

    public void setIdstage(int idstage) {
        this.idstage = idstage;
    }

    public int getIdpersonne() {
        return idpersonne;
    }

    public void setIdpersonne(int idpersonne) {
        this.idpersonne = idpersonne;
    }

    @Override
    public String toString() {
        return "DemandeStage{" + "iddemande=" + iddemande + ", etat=" + etat + ", idstage=" + idstage + ", idpersonne=" + idpersonne + '}';
    }

    

   
    
    
    
    
}
