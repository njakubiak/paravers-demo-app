package com.parasoft.demoapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.parasoft.demoapp.model.global.RoleEntity;
import com.parasoft.demoapp.repository.global.RoleRepository;

public class TestFactory {
	/**
	 * @jtest.factory
	 */
	public static RoleRepository createRoleRepository() {
		RoleRepository repo = new RoleRepository()
			{
				private List<RoleEntity> roleEntities = new ArrayList<RoleEntity>();
					@Override
					public List<RoleEntity> findAll() {
						return null;
					}

					@Override
					public List<RoleEntity> findAll(Sort sort) {
						return null;
					}

					@Override
					public List<RoleEntity> findAllById(Iterable<Long> ids) {
						return null;
					}

					@Override
					public <S extends RoleEntity> List<S> saveAll(Iterable<S> entities) {
						return null;
					}

					@Override
					public void flush() {
					}

					@Override
					public <S extends RoleEntity> S saveAndFlush(S entity) {
						return null;
					}

					@Override
					public void deleteInBatch(Iterable<RoleEntity> entities) {
					}

					@Override
					public void deleteAllInBatch() {
					}

					@Override
					public RoleEntity getOne(Long id) {
						return null;
					}

					@Override
					public <S extends RoleEntity> List<S> findAll(Example<S> example) {
						return null;
					}

					@Override
					public <S extends RoleEntity> List<S> findAll(Example<S> example, Sort sort) {
						return null;
					}

					@Override
					public Page<RoleEntity> findAll(Pageable pageable) {
						return null;
					}

					@Override
					public RoleEntity save(RoleEntity entity) {
						if (!roleEntities.contains(entity)) {
							roleEntities.add(entity);
						}
						return entity;
					}

					@Override
					public Optional<RoleEntity> findById(Long id) {
						return null;
					}

					@Override
					public boolean existsById(Long id) {
						return false;
					}

					@Override
					public long count() {
						return 0;
					}

					@Override
					public void deleteById(Long id) {
						
					}

					@Override
					public void delete(RoleEntity entity) {
						
					}

					@Override
					public void deleteAll(Iterable<? extends RoleEntity> entities) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void deleteAll() {
						
					}

					@Override
					public <S extends RoleEntity> Optional<S> findOne(Example<S> example) {
						return null;
					}

					@Override
					public <S extends RoleEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
						return null;
					}

					@Override
					public <S extends RoleEntity> long count(Example<S> example) {
						return 0;
					}

					@Override
					public <S extends RoleEntity> boolean exists(Example<S> example) {
						return false;
					}

					@Override
					public boolean existsByName(String roleName) {
						boolean ret = false;
						for (RoleEntity role : roleEntities) {
							if (role.getName().equals(roleName)) {
								ret = true;
							}
						}
						return ret;
					}

					@Override
					public RoleEntity findByName(String roleName) {
						for (RoleEntity role : roleEntities) {
							if (role.getName().equals(roleName)) {
								return role;
							}
						}
						return null;
					}
			
				};
		return repo;
	}
}
