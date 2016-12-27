package cn.edu.pku.lx.bean;

/**
 * Created by sun67 on 16.10.11.
 */

public class City {
    private String province;
    private String city;
    private String number;
    private String firstPY;
    private String allPY;
    private String allFirstPY;

    @Override
    public String toString() {
        return province + " - " + city + " " + allPY;
    }

    public City(String province, String city, String number, String
            firstPY, String allPY, String allFirstPY) {
        this.province = province;  //省份
        this.city = city;          //城市
        this.number = number;
        this.firstPY = firstPY;
        this.allPY = allPY;
        this.allFirstPY = allFirstPY;
    }
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFirstPY() {
        return firstPY;
    }

    public void setFirstPY(String firstPY) {
        this.firstPY = firstPY;
    }

    public String getAllPY() {
        return allPY;
    }

    public void setAllPY(String allPY) {
        this.allPY = allPY;
    }

    public String getallFirstPY() {
        return allFirstPY;
    }

    public void setallFirstPY(String allFirstPY) {
        this.allFirstPY = allFirstPY;
    }
}

