package com.srilakshmigoldbuyers.service;


import com.srilakshmigoldbuyers.model.Appointment;
import com.srilakshmigoldbuyers.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    // Constructor
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    // Create a new appointment
    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    // Get all appointments
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    // Get appointment by ID
    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    // Update appointment
    public Appointment updateAppointment(
            Long id,
            Appointment updatedAppointment) {

        Optional<Appointment> existingAppointment =
                appointmentRepository.findById(id);

        if (existingAppointment.isPresent()) {

            Appointment appointment =
                    existingAppointment.get();

            appointment.setName(updatedAppointment.getName());
            appointment.setPhone(updatedAppointment.getPhone());
            appointment.setEmail(updatedAppointment.getEmail());
            appointment.setDate(updatedAppointment.getDate());
            appointment.setTime(updatedAppointment.getTime());
            appointment.setMessage(updatedAppointment.getMessage());

            return appointmentRepository.save(appointment);
        }

        return null;
    }

    // Delete appointment
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}

