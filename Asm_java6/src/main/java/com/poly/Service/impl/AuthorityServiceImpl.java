package com.poly.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.poly.DAO.AccountDAO;
import com.poly.DAO.AuthorityDAO;
import com.poly.Entity.Account;
import com.poly.Entity.Authority;
import com.poly.Service.AuthorityService;
@Service
public class AuthorityServiceImpl implements AuthorityService{
	@Autowired AuthorityDAO authorityDAO;
	@Autowired AccountDAO accountDAO;

	@Override
	public <S extends Authority> S save(S entity) {
		return authorityDAO.save(entity);
	}

	@Override
	public <S extends Authority> Optional<S> findOne(Example<S> example) {
		return authorityDAO.findOne(example);
	}

	@Override
	public Page<Authority> findAll(Pageable pageable) {
		return authorityDAO.findAll(pageable);
	}

	@Override
	public List<Authority> findAll() {
		return authorityDAO.findAll();
	}

	@Override
	public List<Authority> findAll(Sort sort) {
		return authorityDAO.findAll(sort);
	}

	@Override
	public List<Authority> findAllById(Iterable<Integer> ids) {
		return authorityDAO.findAllById(ids);
	}

	@Override
	public Optional<Authority> findById(Integer id) {
		return authorityDAO.findById(id);
	}

	@Override
	public <S extends Authority> List<S> saveAll(Iterable<S> entities) {
		return authorityDAO.saveAll(entities);
	}

	@Override
	public void flush() {
		authorityDAO.flush();
	}

	@Override
	public <S extends Authority> S saveAndFlush(S entity) {
		return authorityDAO.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Integer id) {
		return authorityDAO.existsById(id);
	}

	@Override
	public <S extends Authority> List<S> saveAllAndFlush(Iterable<S> entities) {
		return authorityDAO.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Authority> Page<S> findAll(Example<S> example, Pageable pageable) {
		return authorityDAO.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<Authority> entities) {
		authorityDAO.deleteInBatch(entities);
	}

	@Override
	public <S extends Authority> long count(Example<S> example) {
		return authorityDAO.count(example);
	}

	@Override
	public <S extends Authority> boolean exists(Example<S> example) {
		return authorityDAO.exists(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Authority> entities) {
		authorityDAO.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return authorityDAO.count();
	}

//	@Override
//	public void deleteById(Integer id) {
//		authorityDAO.deleteById(id);
//	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		authorityDAO.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Integer id) {
		authorityDAO.deleteById(id);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		authorityDAO.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		authorityDAO.deleteAllInBatch();
	}

	@Override
	public Authority getOne(Integer id) {
		return authorityDAO.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Authority> entities) {
		authorityDAO.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		authorityDAO.deleteAll();
	}

	@Override
	public Authority getById(Integer id) {
		return authorityDAO.getById(id);
	}

	@Override
	public <S extends Authority> List<S> findAll(Example<S> example) {
		return authorityDAO.findAll(example);
	}

	@Override
	public <S extends Authority> List<S> findAll(Example<S> example, Sort sort) {
		return authorityDAO.findAll(example, sort);
	}
	@Override
	public List<Authority> findAuthoritiesOfAdmintrators() {
		List<Account> accounts = accountDAO.getAdministrators();
		return authorityDAO.authoritiesOf(accounts);
	}
	@Override
	public Authority create(Authority auth) {
		return authorityDAO.save(auth);
	}
	
}
