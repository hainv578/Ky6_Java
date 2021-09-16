package com.poly.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.poly.Entity.Authority;

public interface AuthorityService {

	<S extends Authority> List<S> findAll(Example<S> example, Sort sort);

	<S extends Authority> List<S> findAll(Example<S> example);

	Authority getById(Integer id);

	void deleteAll();

	void deleteAll(Iterable<? extends Authority> entities);

	Authority getOne(Integer id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Integer> ids);

	void delete(Integer id);

	void deleteAllByIdInBatch(Iterable<Integer> ids);

//	void deleteById(Integer id);

	long count();

	void deleteAllInBatch(Iterable<Authority> entities);

	<S extends Authority> boolean exists(Example<S> example);

	<S extends Authority> long count(Example<S> example);

	void deleteInBatch(Iterable<Authority> entities);

	<S extends Authority> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Authority> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(Integer id);

	<S extends Authority> S saveAndFlush(S entity);

	void flush();

	<S extends Authority> List<S> saveAll(Iterable<S> entities);

	Optional<Authority> findById(Integer id);

	List<Authority> findAllById(Iterable<Integer> ids);

	List<Authority> findAll(Sort sort);

	List<Authority> findAll();

	Page<Authority> findAll(Pageable pageable);

	<S extends Authority> Optional<S> findOne(Example<S> example);

	<S extends Authority> S save(S entity);
	 Authority create (Authority auth);

	List<Authority> findAuthoritiesOfAdmintrators();

}
