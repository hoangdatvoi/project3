package com.javaweb.repository.custom.impl;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.custom.BuildingRepositoryCustom;
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
public class BuildingRepositoryImpl implements BuildingRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<BuildingEntity> buildingEntities(BuildingSearchRequest buildingSearchRequest, Pageable pageable) {
        StringBuilder sql = new StringBuilder("SELECT DISTINCT b.* FROM building b");
        joinTable(buildingSearchRequest, sql);
        System.out.println(sql);
        StringBuilder where = new StringBuilder(" WHERE 1=1");
        queryNormal(buildingSearchRequest, where);
        System.out.println(sql);
        querySpecial(buildingSearchRequest, where);
        sql.append(where);
        sql.append(" LIMIT ").append(pageable.getPageSize()).append("\n").append(" OFFSET ").append(pageable.getOffset());
        Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
        return query.getResultList();


    }

    private String buildQueryFilter() {
        String sql = "SELECT * FROM building u WHERE 1 = 1";

        return sql;
    }

    @Override
    public List<BuildingEntity> getAllBuildings(Pageable pageable) {
        StringBuilder sql = new StringBuilder(buildQueryFilter())
                .append(" LIMIT ").append(pageable.getPageSize()).append("\n")
                .append(" OFFSET ").append(pageable.getOffset());
        System.out.println("Final query: " + sql.toString());

        Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
        return query.getResultList();
    }

    @Override
    public int countTotalItem(BuildingSearchRequest buildingSearchRequest) {
        StringBuilder sql = new StringBuilder("SELECT DISTINCT b.* FROM building b");
        joinTable(buildingSearchRequest, sql);
        System.out.println(sql);
        StringBuilder where = new StringBuilder(" WHERE 1=1");
        queryNormal(buildingSearchRequest, where);
        System.out.println(sql);
        querySpecial(buildingSearchRequest, where);
        sql.append(where);
        Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
        return query.getResultList().size();
    }

    private static void queryNormal(BuildingSearchRequest buildingSearchRequest, StringBuilder where) {
        try {
            Field[] fields = BuildingSearchRequest.class.getDeclaredFields();
            for (Field item : fields) {
                item.setAccessible(true);
                String fieldName = item.getName();
                if (!fieldName.equals("staffId") && !fieldName.equals("typeCode") && !fieldName.startsWith("area")
                        && !fieldName.startsWith("rent")) {

                    Object value = item.get(buildingSearchRequest);
                    if (value != "" && value != null) {
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

}
