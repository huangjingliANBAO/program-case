package week5;

import lombok.Data;

import java.util.Date;

/**
 * @Description TODO
 * @Author jl_huang
 * @Date 2020-01-21
 **/
@Data
public class Admin {
    private String id;
    private String mobile;
    private String email;
    private String password;
    private String name;
    private String urlToken;
    private String avatarUrl;
    private String url;
    private String headline;
    private String description;
    private Integer gender;
    private String location;
    private String business;
    private String employment;
    private String education;
    private String userCover;
    private Date created;
}