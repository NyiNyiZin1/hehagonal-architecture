package io.reflectoring.buckpal.account.adapter.out.persistence.mapper;

import java.util.ArrayList;
import java.util.List;

import io.reflectoring.buckpal.account.adapter.out.persistence.entity.AccountJpaEntity;
import io.reflectoring.buckpal.account.adapter.out.persistence.entity.ActivityJpaEntity;
import io.reflectoring.buckpal.account.domain.Account;
import io.reflectoring.buckpal.account.domain.Account.AccountId;
import io.reflectoring.buckpal.account.domain.Activity;
import io.reflectoring.buckpal.account.domain.Activity.ActivityId;
import io.reflectoring.buckpal.account.domain.ActivityWindow;
import io.reflectoring.buckpal.account.domain.Money;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

	public Account mapToDomainEntity(AccountJpaEntity account, List<ActivityJpaEntity> activities,
			Long withdrawalBalance, Long depositBalance) {

		Money baselineBalance = Money.subtract(Money.of(depositBalance), Money.of(withdrawalBalance));

		return Account.withId(new AccountId(account.getId()), baselineBalance, mapToActivityWindow(activities));

	}

	ActivityWindow mapToActivityWindow(List<ActivityJpaEntity> activities) {
		List<Activity> mappedActivities = new ArrayList<>();

		for (ActivityJpaEntity activity : activities) {
			mappedActivities
					.add(new Activity(new ActivityId(activity.getId()), new AccountId(activity.getOwnerAccountId()),
							new AccountId(activity.getSourceAccountId()), new AccountId(activity.getTargetAccountId()),
							activity.getTransferTime(), Money.of(activity.getAmount())));
		}

		return new ActivityWindow(mappedActivities);
	}

	public ActivityJpaEntity mapToJpaEntity(Activity activity) {
		return new ActivityJpaEntity(activity.getId() == null ? null : activity.getId().getValue(),
				activity.getTimestamp(), activity.getOwnerAccountId().getValue(),
				activity.getSourceAccountId().getValue(), activity.getTargetAccountId().getValue(),
				activity.getMoney().getAmount().longValue());
	}

}
