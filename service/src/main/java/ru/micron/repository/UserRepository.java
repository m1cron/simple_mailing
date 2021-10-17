package ru.micron.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.micron.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {}
