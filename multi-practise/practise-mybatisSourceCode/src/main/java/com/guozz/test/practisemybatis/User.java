package com.guozz.test.practisemybatis;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-6-9
 * Time: 上午9:48
 * To change this template use File | Settings | File Templates.
 */
public class User {

    public static final int MAN  = 0;   // 男生
    public static final int WOMAN = 1;  // 女生
    public static final int OTHER = 2;  // 其他

    /** 用户id */
    private int id;
    /** 用户名 */
    private String name;
    /** 用户密码 */
    private String password;
    /** 用户性别 */
    private int sex;
    /** 用户邮箱 */
    private String email;
    /** 用户手机 */
    private String phone;
    /** 用户是否是管理员，"admin"表示是管理员，其他为普通用户 */
    private String admin;


    public User() { }

    public User(String name, String password, int sex, String email, String phone) {
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.email = email;
        this.phone = phone;
        this.admin = "";
    }
    public User(String name, String password, String sex, String email, String phone) {
        this.name = name;
        this.password = password;
        setSex(sex); // this.sex = sex;
        this.email = email;
        this.phone = phone;
        this.admin = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public void setSex(String sexStr) {
        int sex = Integer.valueOf(sexStr);
        switch (Integer.valueOf(sexStr)) {
            case 0: {
                this.sex = MAN;
                break;
            }
            case 1: {
                this.sex = WOMAN;
                break;
            }
            default: {
                this.sex = OTHER;
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", admin='" + admin + '\'' +
                '}';
    }
}
