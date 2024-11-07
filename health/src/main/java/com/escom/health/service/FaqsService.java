package com.escom.health.service;

import com.escom.health.model.Faqs;

import java.io.IOException;
import java.util.List;

public interface FaqsService {

    boolean addFaqs(Faqs faqs) throws IOException;

    List<Faqs> getFaqs();

    boolean updateFaqs(Faqs faqs, int id) throws  IOException;

    boolean deleteFaqs(int id);
}
