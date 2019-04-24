//Viene usato solo in caso di NON-MODULAR java...
package it.ma.main;

public class Launcher {
    
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.vm.version"));
//        System.out.println(System.getProperty("java.library.path"));
        System.out.println(System.getProperty("java.library.path"));
        MainApp.main(args);
    }
}