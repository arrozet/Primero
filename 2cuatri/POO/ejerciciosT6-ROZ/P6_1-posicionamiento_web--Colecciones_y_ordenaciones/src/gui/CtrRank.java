package gui;

//import rank.SiteExtended;
import rank.WebExtended;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
//import java.nio.file.Files;
import java.nio.file.Path;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class CtrRank implements ActionListener {
    private ViewRank vRank;
    private WebExtended web;

    public CtrRank(ViewRank vr) {
        vRank = vr;
    }

    public void actionPerformed(ActionEvent event) {
        ViewRank.Command command = ViewRank.Command.valueOf(event.getActionCommand());
        try {
            switch (command) {
            // D:\!UMA\!!UMA_CODE\1\2cuatri\POO\ejerciciosT6-ROZ\P6_1-posicionamiento_web--Colecciones_y_ordenaciones\src\links.txt
                case  CREATE: {
                  //
                	createLinks(vRank.getFileName());
                  
                  vRank.addOutputLine("Create web\n"+web.toString());
                  //
                    break;
                }
                case CLICK: {
                	//
                	web.click(vRank.getSiteName());
                	vRank.addOutputLine("Clicking site "+web.getSite(vRank.getSiteName()));
                	//
                    break;
                }
                case BYNAME: {
                	//
                	// orden natural
                	vRank.addOutputLine("Sites by name\n" + web.getSitesByName());
                	//
                    break;
                }
                case BYRANK: {
                	//
                	// orden alternativo
                	vRank.addOutputLine("Sites by rank\n" + web.getSitesByRank());
                	//
                    break;
                }
                case SIMULATE: {
                	//
                	web.simulateClick(1000);
                	vRank.addOutputLine("Simulate 1000 clicks ");
                	//
                    break;
                }
                case SWITCH: {
                    //
                	web.SwitchSiteWithName(vRank.getSiteName());
                	vRank.addOutputLine("Switch "+web.getSite(vRank.getSiteName()));
                	//
                    break;
                }
            }
        } catch (IllegalArgumentException | NoSuchElementException e) {
            vRank.setError(e.getMessage());
        } catch (NullPointerException e) {
            vRank.setError("Web not create");
        } catch (IOException e) {
            vRank.setError("File Not Found");
        }
        
    }

    private void createLinks(String fn) throws IOException {
    	//
    	web = new WebExtended();
        Scanner sc= new Scanner(Path.of(fn)); 
        while(sc.hasNextLine()) {
      	  web.addLink(sc.nextLine());
        }
        //
    }
}
