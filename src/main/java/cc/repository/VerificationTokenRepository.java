package cc.repository;

import cc.model.User;
import cc.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.stream.Stream;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, String> {
	VerificationToken findByToken(String token);

	VerificationToken findByUser(User user);

	Stream<VerificationToken> findAllByExpiryDateLessThan(Date now);
	
	void deleteByExpiryDateLessThen(Date now);

	@Modifying
	@Query("delete from VerificationToken t where t.expiryDate <= ?1")
	void deleteAllExpiredSince(Date now);
}