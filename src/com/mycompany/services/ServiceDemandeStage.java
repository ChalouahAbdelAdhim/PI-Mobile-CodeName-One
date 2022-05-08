/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.mycompany.entities.DemandeStage;
import com.mycompany.entities.Stage;
import com.mycompany.utils.Statics;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author user
 */
public class ServiceDemandeStage {
    
    public static ServiceDemandeStage instance =null;
    private ConnectionRequest req ;
    public static boolean resultOk = true;

    
    
    public static ServiceDemandeStage getInstance() {
         if (instance == null)
             instance = new ServiceDemandeStage();
         
         return instance;
    }

    public ServiceDemandeStage() {
        
        req=new ConnectionRequest();
    }
    
    public void AddDemandeStage(DemandeStage Demandestage){
    
    String url =Statics.BASE_URL+"demandestage/newjson";
            
        req.setUrl(url);
        req.addResponseListener((e)->{

        String str = new String(req.getResponseData());
            System.out.println("data=="+str);
        });
            NetworkManager.getInstance().addToQueueAndWait(req);
        }
   
    public ArrayList<DemandeStage>affichageDemandeStage() {
        ArrayList<DemandeStage> result = new ArrayList<>();
        
        String url = Statics.BASE_URL+"demandestage/demandestagejson";
        req.setUrl(url);
        
        req.addResponseListener((NetworkEvent evt) -> {
            JSONParser jsonp ;
            jsonp = new JSONParser();
            
            try {
                Map<String,Object>mapStage = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                
                List<Map<String,Object>> listOfMaps =  (List<Map<String,Object>>) mapStage.get("root");
                
                for(Map<String, Object> obj : listOfMaps) {
                    DemandeStage de = new DemandeStage();
                    
                    float iddemande = Float.parseFloat(obj.get("iddemande").toString());
                    
             //      float idstage =Float.parseFloat(obj.get("idstage").toString());
                    String etat = obj.get("etat").toString();
            //        float idpersonne = Float.parseFloat(obj.get("idpersonne").toString());
                    
                    
                    //float idpersonne = Float.parseFloat(obj.get("idpersonne").toString());
                    
                    de.setIdstage(10);
                    //System.out.println(de.getIdstage().getDescription());
                    de.setIdpersonne(107);
                    de.setEtat(etat);
                    de.setIddemande((int)iddemande);
                    
                    //re.setIdstage((int)idpersonne);
                    
                    //Date
                    // String DateConverter =  obj.get("date").toString().substring(obj.get("date").toString().indexOf("timestamp") + 10 , obj.get("date").toString().lastIndexOf("}"));
                    
                    // Date currentTime = new Date(Double.valueOf(DateConverter).longValue() * 1000);
                    
                    // SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    // String dateString = formatter.format(currentTime);
                    // re.setDate(dateString);
                    
                    //insert data into ArrayList result
                    result.add(de);
                    
                    
                }
            
            }catch(Exception ex) {
                
                ex.printStackTrace();
            }
        });
        
      NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha

      
    //    System.out.println("gggg"+result);
        return result;
        
        
    }
    
}
