package edu.nku.CSC440.stagbar.dataaccess;

/** Class used by the application to store information on the current user. */
public class User {
	private String username;
	private PermissionLevel permissionLevel;

	public User(String username, PermissionLevel permissionLevel) {
		this.username = username;
		this.permissionLevel = permissionLevel;
	}

	public PermissionLevel getPermissionLevel() {
		return permissionLevel;
	}

	public String getUsername() {
		return username;
	}
}