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
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<BuildingEntity> buildingEntities(BuildingSearchRequest buildingSearchRequest) {
        StringBuilder sql = new StringBuilder("SELECT DISTINCT b.* FROM building b");
        joinTable(buildingSearchRequest, sql);
        StringBuilder where = new StringBuilder(" WHERE 1=1");
        queryNormal(buildingSearchRequest, where);
        querySpecial(buildingSearchRequest, where);
        sql.append(where);
        Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
        return query.getResultList();


    }

    private static void queryNormal(BuildingSearchRequest buildingSearchRequest, StringBuilder where) {
        try {
            Field[] fields = BuildingSearchRequest.class.getDeclaredFields();
            for (Field item : fields) {
                item.setAccessible(true);
                String fieldName = item.getName();
                if (!fieldName.equals("staffId") && !fieldName.startsWith("area")
                        && !fieldName.startsWith("rent") && !fieldName.equals("typeCode")) {

                    Object value = item.get(buildingSearchRequest);
                    if (value != null) {
                        if (item.getType().getName().equals("java.lang.Long") || item.getType().getName().equals("java.lang.Integer")) {

                            where.append(" and b." + fieldName + "=" + value);
                        } else {

                            where.append(" and b." + fieldName + " like '%" + value + "%' ");
                        }

                    }
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    private static void querySpecial(BuildingSearchRequest buildingSearchRequest, StringBuilder where) {
        Long staffId = buildingSearchRequest.getStaffId();
        if (staffId != null) {
            where.append(" and assignmentbuilding.staffid = " + staffId);
        }
        Long rentAreaTo = buildingSearchRequest.getAreaTo();
        Long rentAreaFrom = buildingSearchRequest.getAreaFrom();
        if (rentAreaTo != null || rentAreaFrom != null) {
            if (rentAreaFrom != null) {
                where.append(" and rentarea.value >=" + rentAreaFrom);
            }
            if (rentAreaTo != null) {
                where.append(" and rentarea.value <=" + rentAreaTo);
            }

        }
        Long rentPriceFrom = buildingSearchRequest.getRentPriceFrom();
        Long rentPriceTo = buildingSearchRequest.getRentPriceTo();
        if (rentPriceFrom != null || rentPriceTo != null) {
            if (rentPriceFrom != null) {
                where.append(" and b.rentprice >=" + rentPriceFrom);
            }
            if (rentPriceTo != null) {
                where.append(" and b.rentprice <=" + rentPriceTo);
            }

        }
        List<String> typeCode = buildingSearchRequest.getTypeCode();
        if (typeCode != null && typeCode.size() != 0) {
            List<String> code = new ArrayList<>();
            for (String item : typeCode) {
                code.add("'" + item + "'");

            }
            where.append(" and type IN (" + String.join(",", code) + ")");
        }

    }

    private static void joinTable(BuildingSearchRequest buildingSearchBuilder, StringBuilder sql) {
        Long staffId = buildingSearchBuilder.getStaffId();
        if (staffId != null) {
            sql.append(" inner join assignmentbuilding  on b.id=assignmentbuilding.buildingid ");

        }
        List<String> typeCode = buildingSearchBuilder.getTypeCode();

        Long rentAreaTo = buildingSearchBuilder.getAreaTo();
        Long rentAreaFrom = buildingSearchBuilder.getAreaFrom();
        if (rentAreaFrom != null || rentAreaTo != null) {

            sql.append(" inner join rentarea on rentarea.buildingid=b.id ");
        }

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
