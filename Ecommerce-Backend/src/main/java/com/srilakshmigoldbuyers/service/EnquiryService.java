package com.srilakshmigoldbuyers.service;



import com.srilakshmigoldbuyers.model.Enquiry;
import com.srilakshmigoldbuyers.repository.EnquiryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnquiryService {

    private final EnquiryRepository enquiryRepository;

    public EnquiryService(EnquiryRepository enquiryRepository) {
        this.enquiryRepository = enquiryRepository;
    }

    // Create a new enquiry
    public Enquiry createEnquiry(Enquiry enquiry) {
        return enquiryRepository.save(enquiry);
    }

    // Get all enquiries
    public List<Enquiry> getAllEnquiries() {
        return enquiryRepository.findAll();
    }

    // Get enquiry by ID
    public Optional<Enquiry> getEnquiryById(Long id) {
        return enquiryRepository.findById(id);
    }

    // Delete enquiry
    public void deleteEnquiry(Long id) {
        enquiryRepository.deleteById(id);
    }
}


