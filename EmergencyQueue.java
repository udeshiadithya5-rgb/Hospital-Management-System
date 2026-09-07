package com.hospital.datastructure;

import com.hospital.model.Patient;
import java.util.LinkedList;

public class EmergencyQueue {
    private LinkedList<Patient> queue;
    private int maxSize;
    
    public EmergencyQueue() {
        this(100);
    }
    
    public EmergencyQueue(int maxSize) {
        this.queue = new LinkedList<>();
        this.maxSize = maxSize;
    }
    
    // Enqueue - Add patient to waiting queue
    public boolean enqueue(Patient patient) {
        if (isFull()) {
            System.out.println("Queue is full! Cannot add more patients.");
            return false;
        }
        queue.addLast(patient);
        System.out.println("Patient " + patient.getName() + " added to emergency queue.");
        return true;
    }
    
    // Dequeue - Remove next patient for treatment
    public Patient dequeue() {
        if (isEmpty()) {
            System.out.println("No patients in queue!");
            return null;
        }
        Patient patient = queue.removeFirst();
        System.out.println(" Patient " + patient.getName() + " is now being treated.");
        return patient;
    }
    
    // Display all waiting patients
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println(" Emergency queue is empty.");
            return;
        }
        System.out.println("\n Emergency Waiting Queue:");
        System.out.println("==============================");
        int position = 1;
        for (Patient patient : queue) {
            System.out.println(position + ". " + patient.getName() + " (ID: " + patient.getPatientId() + ")");
            position++;
        }
        System.out.println("Total patients waiting: " + queue.size());
        System.out.println("==============================");
    }
    
    // Get queue size
    public int size() {
        return queue.size();
    }
    
    // Check if queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }
    
    // Check if queue is full
    public boolean isFull() {
        return queue.size() >= maxSize;
    }
    
    // Peek at next patient without removing
    public Patient peek() {
        if (isEmpty()) {
            System.out.println(" Queue is empty!");
            return null;
        }
        return queue.getFirst();
    }
}