package com.myorg.propertymanagement.entity.manager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
    Optional<Manager> findByEmailAndPassword(String email, String password);

    @Query("select m from Manager m join fetch m.role where m.email = :email")
    Optional<Manager> findByEmail(@Param("email") String email);


    @Query(value = "select jsonb_agg(managers)managers from (select  json_build_object('managerId', m.id, 'email', m.email, 'role', r.\"name\", 'properties', case when coalesce(count(p.id),0) > 0 then jsonb_agg(jsonb_build_object('propertyId', p.id, 'street', p.street, 'city', p.city, 'description', p.description)) else '[]' end)managers from manager m  left join property p on m.id = p.manager_id left join \"role\" r on r.id = m.role_id \n" +
            "group by m.email, r.name, m.id )", nativeQuery = true)
    Map<String, Object> findManagers();

}
