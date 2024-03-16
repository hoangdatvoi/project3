package com.javaweb.repository.custom.impl;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.repository.BuildingRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<BuildingEntity> buildingEntities(BuildingSearchRequest buildingSearchRequest) {
        StringBuilder sql = new StringBuilder("SELECT DISTINCT b.id, b.name, b.street, b.type, b.district, b.numberofbasement, b.ward, b.floorarea, b.managername, b.managerphonenumber, b.rentprice, b.direction, b.level, b.servicefee, b.brokeragefee FROM building b");
        StringBuilder where = new StringBuilder(" WHERE 1=1");
        sql.append(where);
        Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
        return query.getResultList();


    }

    @Override
    public List<BuildingEntity> findAll() {
        return null;
    }

    @Override
    public List<BuildingEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<BuildingEntity> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<BuildingEntity> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(BuildingEntity entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends BuildingEntity> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends BuildingEntity> S save(S entity) {
        return null;
    }

    @Override
    public <S extends BuildingEntity> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<BuildingEntity> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends BuildingEntity> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<BuildingEntity> entities) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public BuildingEntity getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends BuildingEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends BuildingEntity> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends BuildingEntity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends BuildingEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends BuildingEntity> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends BuildingEntity> boolean exists(Example<S> example) {
        return false;
    }
}
