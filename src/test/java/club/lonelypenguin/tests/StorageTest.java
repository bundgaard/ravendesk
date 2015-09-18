/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package club.lonelypenguin.tests;

import club.lonelypenguin.storage.Storage;
import club.lonelypenguin.storage.Storages;

/**
 *
 * @author dbundgaard
 */
public class StorageTest {
    public static void main(String[] args) {
        Storages storage = new Storages();
        for(Storage s : storage.getEntries()) {
            System.out.println(s.getTitle() + " " + s.getAddress());
        }
    }
    
}
