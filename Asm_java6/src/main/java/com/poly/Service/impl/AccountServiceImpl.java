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
import com.poly.Entity.Account;
import com.poly.Service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	@Autowired 
	AccountDAO accountDAO;

	@Override
	public <S extends Account> S save(S entity) {
		return accountDAO.save(entity);
	}

	@Override
	public <S extends Account> Optional<S> findOne(Example<S> example) {
		return accountDAO.findOne(example);
	}

	@Override
	public Page<Account> findAll(Pageable pageable) {
		return accountDAO.findAll(pageable);
	}

	@Override
	public List<Account> findAll() {
		return accountDAO.findAll();
	}

	@Override
	public List<Account> findAll(Sort sort) {
		return accountDAO.findAll(sort);
	}

	@Override
	public List<Account> findAllById(Iterable<String> ids) {
		return accountDAO.findAllById(ids);
	}

	@Override
	public Account findById(String username) {
		return accountDAO.findById(username).get();
	}

	@Override
	public <S extends Account> List<S> saveAll(Iterable<S> entities) {
		return accountDAO.saveAll(entities);
	}

	@Override
	public void flush() {
		accountDAO.flush();
	}

	@Override
	public <S extends Account> S saveAndFlush(S entity) {
		return accountDAO.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(String username) {
		return accountDAO.existsById(username);
	}

	@Override
	public <S extends Account> List<S> saveAllAndFlush(Iterable<S> entities) {
		return accountDAO.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Account> Page<S> findAll(Example<S> example, Pageable pageable) {
		return accountDAO.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<Account> entities) {
		accountDAO.deleteInBatch(entities);
	}

	@Override
	public <S extends Account> long count(Example<S> example) {
		return accountDAO.count(example);
	}

	@Override
	public <S extends Account> boolean exists(Example<S> example) {
		return accountDAO.exists(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Account> entities) {
		accountDAO.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return accountDAO.count();
	}

	@Override
	public void deleteById(String username) {
		accountDAO.deleteById(username);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<String> ids) {
		accountDAO.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Account entity) {
		accountDAO.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		accountDAO.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		accountDAO.deleteAllInBatch();
	}

	@Override
	public Account getOne(String id) {
		return accountDAO.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Account> entities) {
		accountDAO.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		accountDAO.deleteAll();
	}

	@Override
	public Account getById(String username) {
		return accountDAO.getById(username);
	}

	@Override
	public <S extends Account> List<S> findAll(Example<S> example) {
		return accountDAO.findAll(example);
	}

	@Override
	public <S extends Account> List<S> findAll(Example<S> example, Sort sort) {
		return accountDAO.findAll(example, sort);
	};
	@Override
	public List <Account> getAdministrators(){
		return accountDAO.getAdministrators();
	}
}
