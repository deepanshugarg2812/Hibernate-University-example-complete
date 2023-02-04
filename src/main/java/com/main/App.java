package com.main;

import com.main.entities.Department;
import com.main.entities.University;
import com.main.entities.UniversityPhoneNumbers;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.text.html.Option;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App 
{
    public static void main( String[] args )
    {

    }

    //fetch the university from the name
    public static University getByName(String name,Session session,SessionFactory sessionFactory){
        //use the criteria language of hibernate design the criteria
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<University> criteriaQuery = criteriaBuilder.createQuery(University.class);
        //set the root from where the data need to be picked
        Root<University> root = criteriaQuery.from(University.class);
        //set the result
        criteriaQuery.where(criteriaBuilder.equal(root.get("univName"),name));

        //build the query
        Query query = session.createQuery(criteriaQuery);
        List<University> universities = query.getResultList();
        System.out.println(universities);

        return universities.size()>0?universities.get(0):null;
    }
}
