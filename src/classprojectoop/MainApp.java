/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package classprojectoop;

/**
 *
 * @author Jason
 */
public class MainApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         DatabaseTableCreater dbc = new DatabaseTableCreater();
         dbc.createDatabase();
         HermesFrame frame = new HermesFrame();
         FrameForPanels ffp = new FrameForPanels();
         frontMainPage fmp = new frontMainPage();
         frontPage fp = new frontPage();
         messageForm mf = new  messageForm();
         userProfileForm upf = new userProfileForm();
         MainPageImage mpi = new MainPageImage();

        
    }
    
}
