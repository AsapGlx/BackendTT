package com.escom.health.controller;

import com.escom.health.model.Faqs;
import com.escom.health.model.ResponseData;

public interface FaqsController {

    ResponseData getAllFaqs();

    ResponseData getFaqsById(int id);

    ResponseData createFaqs(Faqs faqs);

    ResponseData updateFaqs(Faqs faqs, int id);

    ResponseData deleteFaqs(int id);
}
