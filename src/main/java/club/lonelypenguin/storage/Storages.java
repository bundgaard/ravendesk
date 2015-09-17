/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package club.lonelypenguin.storage;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dbundgaard
 */
public class Storages {
    private static final String PREFIX = "raven_";
    List<Storage> entries = new ArrayList<Storage>();
    
    public List<Storage> getEntries() {
        List<Storage> l_entries = new ArrayList<Storage>();
        try {
            File tmpFolder = new File("/tmp");
//            FilenameFilter filter = new FilenameFilter();
//            filter.accept("/tmp", PREFIX + "*.txt");
//            File[] files = tmpFolder.listFiles();
        }catch(Exception e){
            
        }
        return l_entries;
    }
    
    
    
}
