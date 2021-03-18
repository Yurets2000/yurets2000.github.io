package com.yube.preset;

import com.yube.utils.IOUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Component
@Slf4j
public class PresetDataConfiguration {

    private final EntityManagerFactory emf;

    @Value("${db.preset}")
    private String preset;

    public PresetDataConfiguration(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @PostConstruct
    void presetDatabase() {
        if (!StringUtils.isEmpty(preset) && !preset.equals("none")) {
            log.info("Database preset process started");
            long startTimeInMs = System.currentTimeMillis();
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            if ("basic".equals(preset)) {
                em.createNativeQuery(IOUtils.getResourceFileAsString("/queries/basic_preset.sql"))
                        .executeUpdate();
            } else {
                throw new IllegalArgumentException(String.format("Preset with type = '%s' can't be processed", preset));
            }
            em.getTransaction().commit();
            long endTimeInMs = System.currentTimeMillis();
            log.info("Database preset process finished successfully in {} sec",
                    (endTimeInMs - startTimeInMs) / 1000d);
        }
    }
}
