package com.pilyak.testmavenproject.models;


public enum Role {
	ADMIN, CLIENT, MANAGER;
	
	private Role role;

	public Role getRole() {
        return role;
    }
	public void setRole(int i) {
		if(i == 1)
			role = Role.CLIENT;
		if(i == 2)
			role = Role.ADMIN;
		if(i == 3)
			role = Role.MANAGER;
	}
}

