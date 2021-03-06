package com.poly.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.poly.Entity.Role;

public interface RoleService {

	<S extends Role> List<S> findAll(Example<S> example, Sort sort);

	<S extends Role> List<S> findAll(Example<S> example);

	Role getById(String id);

	void deleteAll();

	void deleteAll(Iterable<? extends Role> entities);

	Role getOne(String id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends String> ids);

	void delete(Role entity);

	void deleteAllByIdInBatch(Iterable<String> ids);

	void deleteById(String id);

	long count();

	void deleteAllInBatch(Iterable<Role> entities);

	<S extends Role> boolean exists(Example<S> example);

	<S extends Role> long count(Example<S> example);

	void deleteInBatch(Iterable<Role> entities);

//	<S extends Role> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Role> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(String id);

	<S extends Role> S saveAndFlush(S entity);

	void flush();

	<S extends Role> List<S> saveAll(Iterable<S> entities);

	Optional<Role> findById(String id);

	List<Role> findAllById(Iterable<String> ids);

	List<Role> findAll(Sort sort);

	List<Role> findAll();

//	Page<Role> findAll(Pageable pageable);

	<S extends Role> Optional<S> findOne(Example<S> example);

	<S extends Role> S save(S entity);

}
