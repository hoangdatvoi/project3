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
    private String managerphonenumber;
    @Column(name = "rentprice")
    private Integer rentprice;

    @Column(name = "direction")
    private String direction;
    @Column(name = "level")
    private String level;

    @Column(name = "servicefee")
    private Integer servicefee;
    @Column(name = "brokeragefee")
    private Integer brokeragefee;

    @OneToMany(mappedBy = "building", fetch = FetchType.LAZY)
    private List<RentAreaEntity> items = new ArrayList<>();

    @OneToMany(mappedBy = "buildingEntity", fetch = FetchType.LAZY)
    private List<AssignmentBuildingEntity> assignmentBuildingEntities = new ArrayList<>();

    public List<AssignmentBuildingEntity> getAssignmentBuildingEntities() {
        return assignmentBuildingEntities;
    }

    public void setAssignmentBuildingEntities(List<AssignmentBuildingEntity> assignmentBuildingEntities) {
        this.assignmentBuildingEntities = assignmentBuildingEntities;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public List<RentAreaEntity> getItems() {
        return items;
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

    public void setManagerphonenumber(String managerphonenumber) {
        this.managerphonenumber = managerphonenumber;
    }

    public String getManagername() {
        return managername;
    }

    public void setManagername(String managername) {
        this.managername = managername;
    }


    public Integer getRentprice() {
        return rentprice;
    }

    public void setRentprice(Integer rentprice) {
        this.rentprice = rentprice;
    }

    public Integer getFloorarea() {
        return floorarea;
    }

    public String getManagerphonenumber() {
        return managerphonenumber;
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
}

