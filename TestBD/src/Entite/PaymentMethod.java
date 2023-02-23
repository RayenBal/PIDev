/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entite;

/**
 *
 * @author INFOTEC
 */
public class PaymentMethod {
    private int id;
    private int UserID;
    private int type;
    

    public PaymentMethod(int id , int UserID , int type ) {
        this.id= id;
        this.UserID=UserID;
        this.type= type;
    }
    
    public PaymentMethod( int UserID , int type) {
        this.UserID = UserID;
        this.type= type;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    
    
    @Override
    public String toString() {
        return "PaiementMethod{" + "id=" + id + ", UserID =" + UserID + ", type=" + type + '}';
    }
}
