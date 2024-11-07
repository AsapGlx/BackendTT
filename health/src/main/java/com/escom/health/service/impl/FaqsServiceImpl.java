package com.escom.health.service.impl;

import com.escom.health.model.Faqs;
import com.escom.health.repository.FaqsRepository;
import com.escom.health.service.FaqsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FaqsServiceImpl implements FaqsService {

    @Autowired
    private FaqsRepository faqsRepository;

    @Override
    public boolean addFaqs(Faqs faqs) throws IOException {
        try {
            Faqs faqs1 = new Faqs(
                    faqs.getIdFaqs(),
                    faqs.getPregunta(),
                    faqs.getRespuesta()

            );

            faqsRepository.save(faqs1); // MongoRepository maneja la inserción
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Faqs> getFaqs() {
        return faqsRepository.findAll();

    }

    public Faqs getFaqsById(int id) {
        return faqsRepository.findById(id).orElse(null);
    }


    @Override
    public boolean updateFaqs(Faqs faqs , int id) throws IOException {
        try {
            Faqs faqsTest = faqsRepository.findById(id).orElse(null);

            if (faqsTest != null){

                faqsTest.setIdFaqs(faqs.getIdFaqs());
                faqsTest.setPregunta(faqs.getPregunta());
                faqsTest.setRespuesta(faqs.getRespuesta());

                faqsRepository.save(faqsTest);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean deleteFaqs(int id) {
        try {
            Faqs test = faqsRepository.findById(id).orElse(null);
            if ( test != null) {
                faqsRepository.delete(test);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}




