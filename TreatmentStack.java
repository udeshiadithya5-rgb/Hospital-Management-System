package com.hospital.datastructure;

import com.hospital.model.TreatmentRecord;
import java.util.ArrayList;

public class TreatmentStack {
    private ArrayList<TreatmentRecord> stack;
    private int maxSize;
    
    public TreatmentStack() {
        this(100);
    }
    
    public TreatmentStack(int maxSize) {
        this.stack = new ArrayList<>();
        this.maxSize = maxSize;
    }
    
    // Push - add completed treatment record
    public boolean push(TreatmentRecord record) {
        if (isFull()) {
            System.out.println(" Stack is full! Cannot add more treatment records.");
            return false;
        }
        stack.add(record);
        System.out.println(" Treatment record saved successfully!");
        return true;
    }
    
    // Pop - remove most recent treatment record
    public TreatmentRecord pop() {
        if (isEmpty()) {
            System.out.println(" No treatment records in stack!");
            return null;
        }
        TreatmentRecord record = stack.remove(stack.size() - 1);
        System.out.println(" Most recent treatment record removed.");
        return record;
    }
    
    // Peek - view most recent treatment record without removing
    public TreatmentRecord peek() {
        if (isEmpty()) {
            System.out.println(" No treatment records in stack!");
            return null;
        }
        return stack.get(stack.size() - 1);
    }
    
    // Display all treatment records
    public void displayStack() {
        if (isEmpty()) {
            System.out.println(" Treatment history stack is empty.");
            return;
        }
        System.out.println("\n Treatment History (Most Recent First):");
        System.out.println("==========================================");
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.println((stack.size() - i) + ". " + stack.get(i));
        }
        System.out.println("Total treatment records: " + stack.size());
        System.out.println("==========================================");
    }
    
    // Get stack size
    public int size() {
        return stack.size();
    }
    
    // Check if stack is empty
    public boolean isEmpty() {
        return stack.isEmpty();
    }
    
    // Check if stack is full
    public boolean isFull() {
        return stack.size() >= maxSize;
    }
}