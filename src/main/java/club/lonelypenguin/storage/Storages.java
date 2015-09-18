/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package club.lonelypenguin.storage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dbundgaard
 */
public class Storages {

    private static final String PREFIX = "raven_";
    private final List<Storage> entries = new ArrayList<Storage>();
    
    public Storages() {
        List<Storage> l_entries = new ArrayList<Storage>();
        try {
            File tmpFolder = new File("/tmp");
            FilenameFilter filter = new FilenameFilter() {

                @Override
                public boolean accept(File dir, String name) {
                    boolean hasPrefix = name.startsWith(PREFIX);
                    return (hasPrefix && name.endsWith(".txt"));
                }
            };
            File[] files = tmpFolder.listFiles(filter);
            for (File foundFile : files) {
                // filename = title
                // contents = address
                BufferedReader reader = new BufferedReader(new FileReader(foundFile));
                l_entries.add(new Storage(foundFile.getName().replace(".txt", ""), reader.readLine()));
                reader.close();

            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        entries.addAll(l_entries);
    }

    public List<Storage> getEntries() {
        return entries;
    }

}
