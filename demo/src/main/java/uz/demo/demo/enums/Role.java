package uz.demo.demo.enums;


import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    ADMIN(Set.of(Permissions.EMPLOYE_WRITE)),
    USER(Set.of(Permissions.EMPLOYE_READ));
    private final Set<Permissions> permissions;

    Role(Set<Permissions> permissions) {
        this.permissions = permissions;
    }

    public Set<Permissions> getPermissions() {
        return permissions;
    }
    public Set<SimpleGrantedAuthority> getAuthorities(){
        return getPermissions().stream().map(permissions -> new SimpleGrantedAuthority(permissions.getPermission()))
                .collect(Collectors.toSet());
    }
}
