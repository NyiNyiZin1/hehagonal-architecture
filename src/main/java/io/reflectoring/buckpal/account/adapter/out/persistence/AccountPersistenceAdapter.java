package io.reflectoring.buckpal.account.adapter.out.persistence;

import jakarta.persistence.EntityNotFoundException;

import java.time.LocalDateTime;
import java.util.List;

import io.reflectoring.buckpal.account.adapter.out.persistence.entity.AccountJpaEntity;
import io.reflectoring.buckpal.account.adapter.out.persistence.entity.ActivityJpaEntity;
import io.reflectoring.buckpal.account.adapter.out.persistence.mapper.AccountMapper;
import io.reflectoring.buckpal.account.adapter.out.persistence.repository.ActivityRepository;
import io.reflectoring.buckpal.account.adapter.out.persistence.repository.SpringDataAccountRepository;
import io.reflectoring.buckpal.account.application.port.out.LoadAccountPort;
import io.reflectoring.buckpal.account.application.port.out.UpdateAccountStatePort;
import io.reflectoring.buckpal.account.domain.Account;
import io.reflectoring.buckpal.account.domain.Account.AccountId;
import io.reflectoring.buckpal.account.domain.Activity;
import io.reflectoring.buckpal.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter // we use @Component to make this a Spring bean that can be injected into the
					// use case service above.
class AccountPersistenceAdapter implements LoadAccountPort, UpdateAccountStatePort {

	private final SpringDataAccountRepository accountRepository;
	private final ActivityRepository activityRepository;
	private final AccountMapper accountMapper;

	@Override
	public Account loadAccount(AccountId accountId, LocalDateTime baselineDate) {

		AccountJpaEntity account = accountRepository.findById(accountId.getValue())
				.orElseThrow(EntityNotFoundException::new);

		List<ActivityJpaEntity> activities = activityRepository.findByOwnerSince(accountId.getValue(), baselineDate);

		Long withdrawalBalance = orZero(
				activityRepository.getWithdrawalBalanceUntil(accountId.getValue(), baselineDate));

		Long depositBalance = orZero(activityRepository.getDepositBalanceUntil(accountId.getValue(), baselineDate));

		return accountMapper.mapToDomainEntity(account, activities, withdrawalBalance, depositBalance);

	}

	private Long orZero(Long value) {
		return value == null ? 0L : value;
	}

	@Override
	public void updateActivities(Account account) {
		for (Activity activity : account.getActivityWindow().getActivities()) {
			if (activity.getId() == null) {
				activityRepository.save(accountMapper.mapToJpaEntity(activity));
			}
		}
	}

}
