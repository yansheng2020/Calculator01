package com.example.Calculator01.dao;

import com.example.Calculator01.entity.PostcodeData;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PostcodeDAOJpaImpl implements PostcodeDAO {

    private EntityManager entityManager;

    @Autowired
    public PostcodeDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public PostcodeData findByPostcode(String thePostcode) {

        TypedQuery<PostcodeData> theQuery = entityManager.createQuery(
                "FROM PostcodeData WHERE postcode =:PostcodeValue",
                PostcodeData.class);

        theQuery.setParameter("PostcodeValue",thePostcode);

        return theQuery.getSingleResult();
    }

    @Override
    public void updatePostcodeCoordinates(PostcodeData thePostcodeData) {
        entityManager.merge(thePostcodeData);
    }

}
