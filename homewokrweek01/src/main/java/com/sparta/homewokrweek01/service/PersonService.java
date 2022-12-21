package com.sparta.homewokrweek01.service;

import com.sparta.homewokrweek01.models.Person;
import com.sparta.homewokrweek01.models.PersonRepository;
import com.sparta.homewokrweek01.models.PersonRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository repository;

    @Transactional
    public Long update(Long id, PersonRequestDto requestDto) {
        Person person1 = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        person1.update(requestDto);
        return person1.getId();
    }
}
