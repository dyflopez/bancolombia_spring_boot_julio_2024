package com.ms.user.repository;

import com.ms.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserEntity,String> {


    // QUERY JPQL
    @Query(value = "SELECT u FROM UserEntity u WHERE u.email =:email and u.name =:name")
    Optional<UserEntity> getUserByEmailJPQL(String email , String name);


    //NativeQuery
    //@Query(value = "SELECT * FROM user WHERE email =?1 and name = ?2",nativeQuery = true)
    @Query(value = "SELECT * FROM user WHERE email =:email and =:name",nativeQuery = true)
    Optional<UserEntity> getUserByEmailNative(String email , String name);

    //JPA Query Methods

    Optional<UserEntity> findByEmailAndName(String email , String name);

    Optional<UserEntity> findByEmail(String email);

}
