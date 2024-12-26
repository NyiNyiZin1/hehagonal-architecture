package io.reflectoring.buckpal.account.application.port.in;

public interface SendMoneyUseCase {
	/*
	 * The code contains all the business rule validations and logic that are
	 * specific to the use case and thus cannot be implemented within the domain
	 * objects.
	 */
	boolean sendMoney(SendMoneyCommand command);

}
