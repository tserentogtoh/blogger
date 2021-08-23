/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mn.ds.lend.uaa.serviceoauth2.repositories;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mn.ds.lend.uaa.serviceoauth2.entities.User;
import org.springframework.stereotype.Repository;

/**
 *
 * @author esuu
 */
@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager em;
    

    public Optional<User> findOneByUsername(String email) {

        List<User> resultList = em
                .createQuery("SELECT u FROM User u WHERE LOWER(u.username) = LOWER(:email)", User.class)
                .setParameter("email", email)
                .getResultList();
        if (resultList.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(resultList.get(0));
        }
    }

    public User findById(Long id) {
        return em.find(User.class, id);
    }
    

}
