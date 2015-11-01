package com.hackbulgari.niki;

import java.io.File;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class InstallDependencies {
	public static final String allPackages = "/all_packages.json";
	public static final String dependencies = "/dependencies.json";
	public static final String folderInstalledModules = "/installed_modules";
	private String programmePath;
	private JSONObject depObj;
	private JSONObject allPackObj;

	public InstallDependencies(String programmePath) {
		this.programmePath = programmePath;
		depObj = new JSONObject(
				ReadFiles.generateJsonObj(generatePath(dependencies)));
		allPackObj = new JSONObject(
				ReadFiles.generateJsonObj(generatePath(allPackages)));
	}

	private String generatePath(String fileName) {
		return this.programmePath + fileName;
	}

	private boolean hasPackage(String file) {
		String fileName = generatePath(folderInstalledModules) + file;
		return new File(fileName).isDirectory();
	}

	private void createPackage(String moduleName) {
		System.out.println("Installing " + moduleName + ".");
		String modulePath = generatePath(folderInstalledModules) + moduleName;
		File filePackage = new File(modulePath);

		if (!filePackage.exists()) {
			filePackage.mkdir();
		}
	}

	private void installing(JSONObject jsonObject, String packageName) {
		JSONArray helpArr = null;
		String s = "In order to install" + " " + packageName + ", we need"
				+ " ";
		if (!(hasPackage(packageName))) {
			createPackage(packageName);
			helpArr = jsonObject.getJSONArray(packageName);

			if (helpArr.length() != 0) {

				for (int j = 0; j < helpArr.length(); j++) {
					if (helpArr.length() == 1 || j == helpArr.length() - 1) {
						s += helpArr.getString(j) + ".";
					} else {
						s += helpArr.getString(j) + " and ";
					}

				}
				System.out.println(s);
			}

			for (int i = 0; i < helpArr.length(); i++) {
				installing(jsonObject, helpArr.getString(i));
			}

		} else {
			System.out.println(packageName + " " + "is already installed.");
		}
	}

	public void installPackages() {
		ArrayList<String> packagesToInstall = new ArrayList<>();
		JSONArray deps = depObj.names();
		JSONArray helpArr = null;

		for (int i = 0; i < deps.length(); i++) {

			try {
				helpArr = depObj.getJSONArray(deps.getString(i));

				for (int j = 0; j < helpArr.length(); j++) {
					packagesToInstall.add(helpArr.getString(j));
				}
			} catch (Exception e) {
				System.out.println(deps.getString(i) + " has no packages!!!");
			}
		}
		for (int i = 0; i < packagesToInstall.size(); i++) {

			installing(allPackObj, packagesToInstall.get(i));

		}

		System.out.println("All done.");
	}

}
