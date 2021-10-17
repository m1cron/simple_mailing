package ru.micron.service;

import java.time.LocalDate;
import java.time.Month;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.micron.entity.UserEntity;
import ru.micron.repository.UserRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class MailDeliveryService {

  private static final byte PAGEABLE_LIMIT = 20;

  private final UserRepository userRepository;

  @PostConstruct
  @Scheduled(cron = "0 0 0 * * ?")
  public void sendMessages() {
    int count = 0;
    Page<UserEntity> users;
    do {
      users = userRepository.findAll(PageRequest.of(count++, PAGEABLE_LIMIT));
      users.forEach(this::sendMessage);
    } while (PAGEABLE_LIMIT == users.getTotalElements());
  }

  private void sendMessage(UserEntity entity) {
    LocalDate now = LocalDate.now();
    int nowDay = now.getDayOfMonth();
    int nowMonth = now.getMonth().getValue();

    LocalDate userDate = entity.getDateOfBirth();
    int userDay = userDate.getDayOfMonth();
    int userMonth = userDate.getMonth().getValue();

    if (nowDay == userDay && nowMonth == userMonth) {
      log.info("Message delivered to {}", entity.getMail());
    }
  }
}
