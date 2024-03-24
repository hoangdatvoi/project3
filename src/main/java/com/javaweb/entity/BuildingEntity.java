package com.javaweb.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "building")
public class BuildingEntity extends BaseEntity {

    @Column(name = "name")
    private String name;
    @Column(name = "street")
    private String street;
    @Column(name = "type")
    private String type;
    @Column(name = "district")
    private String district;
    @Column(name = "numberofbasement")
    private Integer numberofbasement;
    @Column(name = "ward")
    private String ward;
    @Column(name = "floorarea")
    private Integer floorarea;
    @Column(name = "managername")
    private String managername;
    @Column(name = "managerphone")
    private String managerphone;
    @Column(name = "rentprice")
    private Long rentprice;

    @Column(name = "direction")
    private String direction;
    @Column(name = "level")
    private String level;

    @Column(name = "servicefee")
    private Integer servicefee;
    @Column(name = "brokeragetee")
    private Integer brokeragefee;

    @Column(name = "image")
    private String image;
    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "building", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    private List<RentAreaEntity> items = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    @JoinTable(name = "assignmentbuilding",
            joinColumns = @JoinColumn(name = "buildingid", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "staffid", nullable = false)

    )
    private List<UserEntity> userEntities = new ArrayList<>();

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public List<RentAreaEntity> getItems() {
        return items;
    }

    public List<UserEntity> getUserEntities() {
        return userEntities;
    }

    public void setUserEntities(List<UserEntity> userEntities) {
        this.userEntities = userEntities;
    }

    public void setItems(List<RentAreaEntity> items) {
        this.items = items;
    }


    public Integer getBrokeragefee() {
        return brokeragefee;
    }

    public void setBrokeragefee(Integer brokeragefee) {
        this.brokeragefee = brokeragefee;
    }

    public Integer getServicefee() {
        return servicefee;
    }

    public void setServicefee(Integer servicefee) {
        this.servicefee = servicefee;
    }

    public String getName() {
        return name;
    }

    public String getManagerphone() {
        return managerphone;
    }

    public void setManagerphone(String managerphone) {
        this.managerphone = managerphone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumberofbasement() {
        return numberofbasement;
    }

    public void setNumberofbasement(Integer numberofbasement) {
        this.numberofbasement = numberofbasement;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }


    public void setFloorarea(Integer floorarea) {
        this.floorarea = floorarea;
    }


    public String getManagername() {
        return managername;
    }

    public void setManagername(String managername) {
        this.managername = managername;
    }

    public Long getRentprice() {
        return rentprice;
    }

    public void setRentprice(Long rentprice) {
        this.rentprice = rentprice;
    }

    public Integer getFloorarea() {
        return floorarea;
    }


    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
