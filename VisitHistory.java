package com.hospital.datastructure;

import com.hospital.model.Visit;

public class VisitHistory {
    private class Node {
        Visit visit;
        Node next;
        
        Node(Visit visit) {
            this.visit = visit;
            next = null;
        }
    }
    
    private Node head;
    private int size;
    
    public VisitHistory() {
        head = null;
        size = 0;
    }
    
    // Add new visit to history
    public void addVisit(Visit visit) {
        Node newNode = new Node(visit);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        System.out.println(" Visit added to patient's history.");
    }
    
    // Remove a visit by Visit ID
    public boolean removeVisit(int visitId) {
        if (head == null) {
            System.out.println(" No visits to remove.");
            return false;
        }
        
        if (head.visit.getVisitId() == visitId) {
            head = head.next;
            size--;
            System.out.println(" Visit removed from history.");
            return true;
        }
        
        Node current = head;
        while (current.next != null && current.next.visit.getVisitId() != visitId) {
            current = current.next;
        }
        
        if (current.next == null) {
            System.out.println(" Visit with ID " + visitId + " not found.");
            return false;
        }
        
        current.next = current.next.next;
        size--;
        System.out.println(" Visit removed from history.");
        return true;
    }
    
    // Search for a visit by Visit ID
    public Visit searchVisit(int visitId) {
        Node current = head;
        while (current != null) {
            if (current.visit.getVisitId() == visitId) {
                return current.visit;
            }
            current = current.next;
        }
        System.out.println(" Visit with ID " + visitId + " not found.");
        return null;
    }
    
    // Display all visits
    public void displayVisits() {
        if (head == null) {
            System.out.println(" No visits in history.");
            return;
        }
        
        System.out.println("\n Patient Visit History:");
        System.out.println("==============================");
        Node current = head;
        int count = 1;
        while (current != null) {
            System.out.println(count + ". " + current.visit);
            current = current.next;
            count++;
        }
        System.out.println("Total visits: " + size);
        System.out.println("==============================");
    }
    
    // Get size
    public int size() {
        return size;
    }
    
    // Check if empty
    public boolean isEmpty() {
        return head == null;
    }
}