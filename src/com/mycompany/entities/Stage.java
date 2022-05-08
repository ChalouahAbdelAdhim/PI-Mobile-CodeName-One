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
public class Stage {
    
    private int idstage;
    private int duree;
    private String type,domaine,description,sujet;
    private String datedebut,datefin;
    private int idpersonne;

    public Stage() {
    }

    public Stage(int duree, String type, String domaine, String description, String sujet, String datedebut, String datefin) {
        this.duree = duree;
        this.type = type;
        this.domaine = domaine;
        this.description = description;
        this.sujet = sujet;
        this.datedebut = datedebut;
        this.datefin = datefin;
    }

    public Stage(int duree, String type, String domaine, String description, String sujet, int idpersonne) {
        this.duree = duree;
        this.type = type;
        this.domaine = domaine;
        this.description = description;
        this.sujet = sujet;
        this.idpersonne = idpersonne;
    }

    

    public int getIdstage() {
        return idstage;
    }

    public void setIdstage(int idstage) {
        this.idstage = idstage;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(String datedebut) {
        this.datedebut = datedebut;
    }

    public String getDatefin() {
        return datefin;
    }

    public void setDatefin(String datefin) {
        this.datefin = datefin;
    }

    public int getIdpersonne() {
        return idpersonne;
    }

    public void setIdpersonne(int idpersonne) {
        this.idpersonne = idpersonne;
    }

    @Override
    public String toString() {
        return "Stage{" + "idstage=" + idstage + ", duree=" + duree + ", type=" + type + ", domaine=" + domaine + ", description=" + description + ", sujet=" + sujet + ", datedebut=" + datedebut + ", datefin=" + datefin + ", idpersonne=" + idpersonne + '}';
    }
    
    
    
    
    
    
    
    
}
