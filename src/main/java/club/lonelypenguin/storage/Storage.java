/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package club.lonelypenguin.storage;

/**
 *
 * @author dbundgaard
 */
public class Storage {
    
    
    
    private String title;
    private String address;
    
    public Storage(String title, String address) {
        this.title = title;
        this.address = address;
        
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}
