package com.javaweb.repository.custom.impl;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.CustomerEntity;
import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.repository.CustomerRepository;
import com.javaweb.repository.custom.CustomerRepositoryCustom;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CustomerEntity> customerEntities(CustomerDTO customerDTO, Pageable pageable) {
        StringBuilder sql = new StringBuilder("SELECT DISTINCT b.* FROM customer b");
        joinTable(customerDTO, sql);
        System.out.println(sql);
        StringBuilder where = new StringBuilder(" WHERE 1=1 and is_active=1");
        queryNormal(customerDTO, where);
        System.out.println(sql);
        sql.append(where);
        sql.append(" LIMIT ").append(pageable.getPageSize()).append("\n").append(" OFFSET ").append(pageable.getOffset());
        Query query = entityManager.createNativeQuery(sql.toString(), CustomerEntity.class);
        return query.getResultList();
    }

    @Override
    public int countTotalItem() {
        String sql = "select * from customer where 1=1 and is_active=1";
        Query query = entityManager.createNativeQuery(sql.toString());
        return query.getResultList().size();
    }

    private static void queryNormal(CustomerDTO customerDTO, StringBuilder where) {
        try {
            Field[] fields = CustomerDTO.class.getDeclaredFields();
            for (Field item : fields) {
                item.setAccessible(true);
                String fieldName = item.getName();

                Object value = item.get(customerDTO);
                if (value != "" && value != null) {
                    if (item.getType().getName().equals("java.lang.Long") || item.getType().getName().equals("java.lang.Integer")) {

                        where.append(" and " + fieldName + "=" + value);
                    } else {

                        where.append(" and b." + fieldName + " like '%" + value + "%' ");
                    }

                }


            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    private static void joinTable(CustomerDTO customerDTO, StringBuilder sql) {
        Long staffId = customerDTO.getStaffId();
        if (staffId != null) {
            sql.append(" inner join assignmentcustomer  on b.id=assignmentcustomer.customerid ");

        }


    }
}
