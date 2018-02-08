package ru.alexandrstal.gsa.service.impl;

import org.springframework.stereotype.Service;
import ru.alexandrstal.gsa.domain.Application;
import ru.alexandrstal.gsa.service.ApplicationService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Application findByExtidappli(String extidappli) {
        List<Application> applicationList = entityManager.createQuery("select a from Application a where a.extidappli = :extidappli", Application.class).setParameter("extidappli", extidappli).getResultList();
        if (applicationList.isEmpty()) {
            return new Application();
        }
        return applicationList.get(0);
    }
}
