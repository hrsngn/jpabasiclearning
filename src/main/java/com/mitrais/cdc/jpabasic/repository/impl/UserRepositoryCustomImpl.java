package com.mitrais.cdc.jpabasic.repository.impl;

import com.mitrais.cdc.jpabasic.model.User;
import com.mitrais.cdc.jpabasic.model.User_;
import com.mitrais.cdc.jpabasic.repository.custom.UserRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    //find data that have name like the input parameter
    public List<User> findByName(String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> user = cq.from(User.class);
        cq.where(cb.like(user.get(User_.name), "%"+name+"%"));
        return em.createQuery(cq).getResultList();
    }

    //update user name
    @Transactional
    public void updateName(User user){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaUpdate<User> update = cb.createCriteriaUpdate(User.class);
        Root e = update.from(User.class);
        update.set("name",user.getName());
        update.where(cb.equal(e.get("id"),user.getId()));
        em.createQuery(update).executeUpdate();
    }

    @Transactional
    public void deleteById(User user){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaDelete<User> q = cb.createCriteriaDelete(User.class);
        Root root = q.from(User.class);
        q.where(cb.equal(root.get("id"),user.getId()));
        em.createQuery(q).executeUpdate();
    }
}
