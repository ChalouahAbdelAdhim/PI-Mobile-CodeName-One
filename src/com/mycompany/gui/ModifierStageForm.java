/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.FloatingHint;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.Stage;
import com.mycompany.services.ServiceStage;

/**
 *
 * @author user
 */
public class ModifierStageForm extends BaseForm {
 Form current;
    public ModifierStageForm(Resources res , Stage r) {
         super("Newsfeed",BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical
    
        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Ajout Stage");
        getContentPane().setScrollVisible(false);
        
        
        super.addSideMenu(res);
        
        TextField duree = new TextField (String.valueOf(r.getDuree()), "Duree" , 20 , TextField.ANY);
        TextField type = new TextField(r.getType(), "Type" , 20 , TextField.ANY);
        TextField domaine = new TextField(r.getDomaine(), "Domaine" , 20 , TextField.ANY);
        TextField description = new TextField(r.getDescription(), "Description" , 20 , TextField.ANY);
        TextField sujet = new TextField(r.getSujet(), "Objet" , 20 , TextField.ANY);
        

        
        duree.setUIID("NewsTopLine");
        type.setUIID("NewsTopLine");
        domaine.setUIID("NewsTopLine");
        description.setUIID("NewsTopLine");
        sujet.setUIID("NewsTopLine");
        
        duree.setSingleLineTextArea(true);
        description.setSingleLineTextArea(true);
        type.setSingleLineTextArea(true);
        domaine.setSingleLineTextArea(true);
        sujet.setSingleLineTextArea(true);
       
        Button btnModifier = new Button("Modifier");
       btnModifier.setUIID("Button");
       
       //Event onclick btnModifer
       
       btnModifier.addPointerPressedListener(l ->   { 
           
           r.setDuree(Integer.parseInt(duree.getText()));
           r.setDescription(description.getText());
           r.setDomaine(domaine.getText());
           r.setType(type.getText());
           r.setSujet(sujet.getText());
           
          
      
       
       //appel fonction modfier stage men service
       
       if(ServiceStage.getInstance().modifierStage(r)) { // if true
           new ListStageForm(res).show();
       }
        });
       Button btnAnnuler = new Button("Annuler");
       btnAnnuler.addActionListener(e -> {
           new ListStageForm(res).show();
       });
       
       
       Label l2 = new Label("");
       
       Label l3 = new Label("");
       
       Label l4 = new Label("");
       
       Label l5 = new Label("");
       
       Label l1 = new Label();
        
        Container content = BoxLayout.encloseY(
                l1, l2,l3,l4,l5, 
                new FloatingHint(duree),
                createLineSeparator(),
                new FloatingHint(type),
                createLineSeparator(),
                new FloatingHint(domaine),
                createLineSeparator(),
                new FloatingHint(description),
                createLineSeparator(),
                new FloatingHint(sujet),
                createLineSeparator(),
                
                btnModifier,
                btnAnnuler
                
               
        );
        
        add(content);
        show();
        
        
    }
}