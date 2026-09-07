package com.hospital.datastructure;

import com.hospital.model.Patient;

public class PatientBST {
    private class Node {
        Patient patient;
        Node left, right;
        
        Node(Patient patient) {
            this.patient = patient;
            left = right = null;
        }
    }
    
    private Node root;
    
    public PatientBST() {
        root = null;
    }
    
    // Insert a new patient
    public void insert(Patient patient) {
        root = insertRec(root, patient);
        System.out.println(" Patient inserted successfully!");
    }
    
    private Node insertRec(Node root, Patient patient) {
        if (root == null) {
            root = new Node(patient);
            return root;
        }
        
        if (patient.getPatientId() < root.patient.getPatientId()) {
            root.left = insertRec(root.left, patient);
        } else if (patient.getPatientId() > root.patient.getPatientId()) {
            root.right = insertRec(root.right, patient);
        }
        return root;
    }
    
    // Search for a patient
    public Patient search(int patientId) {
        return searchRec(root, patientId);
    }
    
    private Patient searchRec(Node root, int patientId) {
        if (root == null || root.patient.getPatientId() == patientId) {
            return root != null ? root.patient : null;
        }
        
        if (patientId < root.patient.getPatientId()) {
            return searchRec(root.left, patientId);
        }
        return searchRec(root.right, patientId);
    }
    
    // Delete a patient
    public void delete(int patientId) {
        if (search(patientId) == null) {
            System.out.println(" Patient not found!");
            return;
        }
        root = deleteRec(root, patientId);
        System.out.println(" Patient deleted successfully!");
    }
    
    private Node deleteRec(Node root, int patientId) {
        if (root == null) return root;
        
        if (patientId < root.patient.getPatientId()) {
            root.left = deleteRec(root.left, patientId);
        } else if (patientId > root.patient.getPatientId()) {
            root.right = deleteRec(root.right, patientId);
        } else {
            // Node with only one child or no child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            
            // Node with two children - get inorder successor
            root.patient = minValue(root.right);
            root.right = deleteRec(root.right, root.patient.getPatientId());
        }
        return root;
    }
    
    private Patient minValue(Node root) {
        Patient minPatient = root.patient;
        while (root.left != null) {
            minPatient = root.left.patient;
            root = root.left;
        }
        return minPatient;
    }
    
    // In-order traversal
    public void inorderTraversal() {
        if (root == null) {
            System.out.println(" No patients in the system.");
            return;
        }
        System.out.println("\n All Patients (Sorted by ID):");
        System.out.println("----------------------------------------");
        inorderRec(root);
        System.out.println("----------------------------------------");
    }
    
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.patient);
            inorderRec(root.right);
        }
    }
    
    // Check if BST is empty
    public boolean isEmpty() {
        return root == null;
    }
}