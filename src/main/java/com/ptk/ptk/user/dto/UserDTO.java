package com.ptk.ptk.user.dto;

import com.ptk.ptk.user.entity.UserEntity;

public class UserDTO {
    private Long uid;
    private String id;
    private String name;
    private String password;

    @Override
    public String toString() {
        return "UserDTO{" +
                "uid=" + uid +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public UserDTO(Long uid, String id, String name, String password) {
        this.uid = uid;
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public static UserDTO toUserDTO(UserEntity entity) {
        UserDTO user = new UserDTO(entity.getUid(), entity.getId(), entity.getName(), entity.getPassword());
        return user;
    }
}
