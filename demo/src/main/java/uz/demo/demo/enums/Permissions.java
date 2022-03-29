package uz.demo.demo.enums;

public enum Permissions {
    EMPLOYE_READ("employe:read"),
    EMPLOYE_WRITE("employe:write");

    private String permission;
    Permissions(String permission){
        this.permission=permission;

    }

    public String getPermission() {
        return permission;
    }
}
