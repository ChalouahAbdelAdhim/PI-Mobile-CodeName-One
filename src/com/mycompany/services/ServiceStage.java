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
import com.codename1.ui.events.ActionListener;
import com.mycompany.entities.Stage;
import com.mycompany.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author user
 */
public class ServiceStage {
    
    public static ServiceStage instance =null;
    private ConnectionRequest req ;
    public static boolean resultOk = true;

    
    
    public static ServiceStage getInstance() {
         if (instance == null)
             instance = new ServiceStage();
         
         return instance;
    }

    public ServiceStage() {
        
        req=new ConnectionRequest();
    }
    
    public void AddStage(Stage stage){
    
    String url =Statics.BASE_URL+"stage/newstagejson?duree="+stage.getDuree()+"&type="+stage.getType()+"&domaine="+stage.getDomaine()+"&description="+stage.getDescription()+"&sujet="+stage.getSujet()+"&idpersonne="+stage.getIdpersonne();
            
        req.setUrl(url);
        req.addResponseListener((e)->{

        String str = new String(req.getResponseData());
            System.out.println("data=="+str);
        });
            NetworkManager.getInstance().addToQueueAndWait(req);
        }
   
    public ArrayList<Stage>affichageStage() {
        ArrayList<Stage> result = new ArrayList<>();
        
        String url = Statics.BASE_URL+"stage/stagejson";
        req.setUrl(url);
        
        req.addResponseListener((NetworkEvent evt) -> {
            JSONParser jsonp ;
            jsonp = new JSONParser();
            
            try {
                Map<String,Object>mapStage = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                
                List<Map<String,Object>> listOfMaps =  (List<Map<String,Object>>) mapStage.get("root");
                
                for(Map<String, Object> obj : listOfMaps) {
                    Stage re = new Stage();
                    
                    //dima id fi codename one float 5outhouha
                    float idstage = Float.parseFloat(obj.get("idstage").toString());
                    
                    float duree = Float.parseFloat(obj.get("duree").toString());
                    String type = obj.get("type").toString();
                    String domaine = obj.get("domaine").toString();
                    String sujet = obj.get("sujet").toString();
                    String description = obj.get("description").toString();
                    
                    //float idpersonne = Float.parseFloat(obj.get("idpersonne").toString());
                    
                    re.setIdstage((int)idstage);
                    re.setDuree((int)duree);
                    re.setType(type);
                    re.setDomaine(domaine);
                    re.setSujet(sujet);
                    re.setDescription(description);
                    //re.setIdstage((int)idpersonne);
                    
                    //Date
                    // String DateConverter =  obj.get("date").toString().substring(obj.get("date").toString().indexOf("timestamp") + 10 , obj.get("date").toString().lastIndexOf("}"));
                    
                    // Date currentTime = new Date(Double.valueOf(DateConverter).longValue() * 1000);
                    
                    // SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    // String dateString = formatter.format(currentTime);
                    // re.setDate(dateString);
                    
                    //insert data into ArrayList result
                    result.add(re);
                    
                    
                }
            
            }catch(Exception ex) {
                
                ex.printStackTrace();
            }
        });
        
      NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha

      
    //    System.out.println("gggg"+result);
        return result;
        
        
    }
    
    public boolean deleteStage(int id ) {
        String url = Statics.BASE_URL +"stage/deletejson?idstage="+id;
        
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                    
                    req.removeResponseCodeListener(this);
            }
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
        return  resultOk;
    }
    
    public boolean modifierStage(Stage stage) {
        String url = Statics.BASE_URL +"stage/editjson?idstage="+stage.getIdstage()+"&duree="+stage.getDuree()+"&description="+stage.getDescription()+"&type="+stage.getType()+"&sujet="+stage.getSujet()+"&domaine="+stage.getDomaine();
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOk = req.getResponseCode() == 200 ;  // Code response Http 200 ok
                req.removeResponseListener(this);
            }
        });
        
    NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha
    return resultOk;
        
    }
    
    public Stage DetailStage( int id , Stage stage) {
        
        String url = Statics.BASE_URL+"stage/showjson?idstage="+id;
        req.setUrl(url);
        
        String str  = new String(req.getResponseData());
        req.addResponseListener(((evt) -> {
        
            JSONParser jsonp = new JSONParser();
            try {
                
                Map<String,Object>obj = jsonp.parseJSON(new CharArrayReader(new String(str).toCharArray()));
                
                stage.setDuree(Integer.parseInt(obj.get("duree").toString()));
                stage.setType(obj.get("type").toString());
                stage.setDomaine(obj.get("domaine").toString());
                stage.setDescription(obj.get("description").toString());
                stage.setSujet(obj.get("sujet").toString());
                    
                
                stage.setIdpersonne(Integer.parseInt(obj.get("etat").toString()));
                
            }catch(IOException ex) {
                System.out.println("error related to sql :( "+ex.getMessage());
            }
            
            
            System.out.println("data === "+str);
            
            
            
        }));
        
              NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha

              return stage;
        
        
    }
    
    
    
}
    

