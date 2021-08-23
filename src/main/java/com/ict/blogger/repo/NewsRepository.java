/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ict.blogger.repo;

import com.ict.blogger.entities.News;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tseke
 */
@Repository
public class NewsRepository {

    @PersistenceContext
    private EntityManager em;

    public BigInteger getStateCnt(String state) {
        return (BigInteger) em.createNativeQuery(""
                + "select "
                + "count(state) as cnt "
                + "from news "
                + "where state = :state ")
                .setParameter("state", state)
                .getSingleResult();
    }
    
    public List<News> getState(String state){
        return (List<News>) em.createNativeQuery(""
                + "select "
                + "*"
                + "from news"
                + "where state = :state")
                .setParameter("state", state)
                .getResultList();
    }
//    public List<AddressResponse> getSumList(List<Long> id) {
//
//        List<AddressResponse> resultList = em
//                .createNativeQuery(""
//                        + "select "
//                        + "id as \"id\", "
//                        + "name \"name\" "
//                        + "from address_sum_duureg  "
//                        + "where aimag_id in (:id)")
//                .setParameter("id", id)
//                .unwrap(NativeQuery.class)
//                .setResultTransformer(Transformers.aliasToBean(AddressResponse.class))
//                .getResultList();
//
//        return resultList;
//    }

}
