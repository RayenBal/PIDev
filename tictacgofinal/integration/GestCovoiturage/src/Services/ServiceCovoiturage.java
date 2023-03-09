/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entite.Covoiturage;
import Utils.DataSource;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.AWTException;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author sanabenfadhel
 */
public class ServiceCovoiturage implements IService<Covoiturage>{
 
    Connection con=DataSource.getInstance().getConnection();
    
    private Statement ste;
    private Covoiturage p;

    public ServiceCovoiturage() {
        
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    @Override
    public boolean  ajouter(Covoiturage c) throws SQLException
    {
                boolean verif=true;

    try {   String req = "INSERT INTO `Covoiturage`(`id_cov`, `idc`, `depart`, `destination`, `date_covoiturage`, `Prix` , `nbrplace` , `vehicule`) VALUES ( ?,?,?,?,?,?,?,?);";

     PreparedStatement pre=con.prepareStatement(req);
            pre.setInt(1, c.getId_cov());

    pre.setInt(2, c.getIdc());
        pre.setString(3, c.getDepart());
        pre.setString(4, c.getDestination());
        pre.setString(5,(c.getDate_covoiturage()));
        
        pre.setInt(6, c.getPrix());
        pre.setInt(7, c.getNbrplace());
        pre.setString(8,c.getVehicule());

         int rowsInserted = pre.executeUpdate();
     if (rowsInserted > 0) {
        
                           }
            
     }catch(SQLException e){
            System.out.println(e);
            verif=false;
        }
    return verif;
    }
    

    @Override
    public void update(Covoiturage c) throws SQLException {
        String req="UPDATE `Covoiturage` SET `idc`=?,`depart`=?,`destination`=?,`date_covoiturage`=?,`Prix`=? ,`nbrplace`=? where `id_cov` ="+c.getId_cov()+"";
        
        PreparedStatement pre=con.prepareStatement(req);

        pre.setInt(1, c.getIdc());
        pre.setString(2, c.getDepart());
        pre.setString(3, c.getDestination());
        pre.setString(4,(c.getDate_covoiturage()));
        
        pre.setInt(5, c.getPrix());
        pre.setInt(6, c.getNbrplace());
        pre.executeUpdate();
        System.out.println("Covoiturage mis a jour avec succés");

    }

    @Override
    public boolean supprime(Covoiturage c) throws SQLException {
        try{
            String req ="DELETE FROM `Covoiturage` WHERE id_cov ="+c.getId_cov()+"";
         Statement state;
         Connection cnx=DataSource.getInstance().getConnection();
         state=cnx.createStatement();
         state.execute(req);
         return true;
        }
        catch(SQLException ex){
            System.err.println(ex.getMessage());
            return false;
        }
    }

     @Override
    public List<Covoiturage> readAll() throws SQLException {
        ArrayList<Covoiturage> listcov = new ArrayList<>();

        String req = "select * from Covoiturage";

        ResultSet res = ste.executeQuery(req);

        while (res.next()) {
            int id_cov = res.getInt(1);
            int idc = res.getInt(2);
            String depart = res.getString("depart");
            String destination = res.getString(4);
            String date_covoiturage = res.getString(5);
            int Prix = res.getInt(6);
            int nbrplace = res.getInt(7);
            String vehicule = res.getString(8);
            Covoiturage c = new Covoiturage(id_cov, idc, depart, destination, date_covoiturage ,Prix , nbrplace, vehicule);
            // System.out.println(p);
            listcov.add(c);
        }
        return listcov;
        
        
    }

    @Override
    public Covoiturage findById(int id) throws SQLException {
Covoiturage d=new Covoiturage(); 
        String req = "select * FROM Covoiturage where id_cov = " + id + ";";

        ResultSet res = ste.executeQuery(req);
    while (res.next()) {
       int id_cov = res.getInt(1);
            int idc = res.getInt(2);
            String depart = res.getString("depart");
            String destination = res.getString(4);
            String date_covoiturage = res.getString(5);
            int Prix = res.getInt(6);
            int nbrplace = res.getInt(7);
            String vehicule = res.getString(8);
         d = new Covoiturage(id_cov, idc, depart, destination, date_covoiturage , Prix , nbrplace, vehicule);
    }
        
        return d;
        
    }
    private void printCovoiturages() {
    try {
        ServiceCovoiturage sc = new ServiceCovoiturage();
        List<Covoiturage> data = sc.readAll();

        // Create a new PDF document
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("covoiturages.pdf"));
        document.open();

        // Add the list of covoiturages to the document
        for (Covoiturage covoiturage : data) {
            Paragraph paragraph = new Paragraph(covoiturage.toString());
            document.add(paragraph);
        }

        document.close();

        // Show a success message
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Impression réussie");
        alert.setContentText("La liste des covoiturages a été imprimée avec succès.");
        alert.showAndWait();
    } catch (Exception e) {
        // Show an error message if an exception occurs
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Erreur lors de l'impression");
        alert.setContentText("Une erreur s'est produite lors de l'impression de la liste des covoiturages.");
        alert.showAndWait();
    }
}
    
    private void notifyUser(String message) {
        if (SystemTray.isSupported()) {
            try {
                // Initialiser SystemTray
                SystemTray tray = SystemTray.getSystemTray();

                // Créer une icône pour la notification
                java.awt.Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
                TrayIcon trayIcon = new TrayIcon(image, "Notification");

                // Ajouter l'icône au SystemTray
                tray.add(trayIcon);

                // Afficher la notification
                trayIcon.displayMessage("Notification", message, TrayIcon.MessageType.INFO);
            } catch (AWTException e) {
                System.err.println("Erreur lors de l'initialisation du SystemTray: " + e);
            }
        } else {
            System.out.println("SystemTray n'est pas pris en charge");
        }
    }

    
}
