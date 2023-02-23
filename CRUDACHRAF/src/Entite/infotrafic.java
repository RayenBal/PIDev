/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author medzr
 */
public class infotrafic {
    private int idi;
    private String type;
    private String description;
    private int idc ; 

 
    public infotrafic(String type, String description,int idc) {
        this.type = type;
        this.description = description;
        this.idc= idc ; 

    }

    public infotrafic(int idi, String type, String description,int idc ) {
        this.idi = idi;
        this.type = type;
        this.description = description;
        this.idc=idc ; 
    }

    public infotrafic() {
     
    }

    public int getIdi() {
        return idi;
    }

    public void setIdi(int idi) {
        this.idi = idi;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public int getIdc() {
        return idc;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    @Override
    public String toString() {
        return "infotrafic" + "idi=" + idi + ", type=" + type + ", description=" + description +",idc"+idc+ '}';
    }
}
