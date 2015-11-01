package com.hackbulgari.niki;

import java.util.Scanner;

public class Main {
	private static final String path = "C:\\Users\\Rosen\\Desktop\\NikiProject";
	
	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
         String programmePath;
         System.out.println("Enter Programme path:");
         programmePath=scanner.nextLine();
		InstallDependencies dep = new InstallDependencies(path);
		dep.installPackages();
	}

}
