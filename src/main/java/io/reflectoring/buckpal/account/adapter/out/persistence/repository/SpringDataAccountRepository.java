package io.reflectoring.buckpal.account.adapter.out.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.reflectoring.buckpal.account.adapter.out.persistence.entity.AccountJpaEntity;

public interface SpringDataAccountRepository extends JpaRepository<AccountJpaEntity, Long> {
}
