/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ict.blogger.repo;

import java.math.BigInteger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tseke
 */
@Repository
public class LikeRepository {
    
    @PersistenceContext
    private EntityManager em;
    
    public BigInteger getCount(int id) {
        return (BigInteger) em.createNativeQuery(""
                + "select "
                + "count(news_id) as cnt "
                + "from likes "
                + "where news_id = :id ")
                .setParameter("id", id)
                .getSingleResult();
    }
}

//public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
//	@Query(value = "SELECT * FROM todo_item e WHERE e.email LIKE %:keyword%", nativeQuery = true)
//
//	public List<TodoItem> search(String keyword);
//
//}