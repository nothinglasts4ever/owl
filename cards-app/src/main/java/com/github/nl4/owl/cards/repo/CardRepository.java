package com.github.nl4.owl.cards.repo;

import com.github.nl4.owl.cards.domain.Card;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Repository
public interface CardRepository extends ReactiveMongoRepository<Card, UUID> {

    Flux<Card> findAllByAccessRoles_AccessRoleId(UUID accessRoleId);

}