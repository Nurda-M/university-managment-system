package com.university.management.system;

import java.util.List;

public class ProfessorService {

    private DataPool dataPool;

    public ProfessorService(DataPool dataPool) {
        this.dataPool = dataPool;
    }

    // Create a new Professor
    public void addProfessor(Professor professor) {
        dataPool.add(professor);
    }

    // Retrieve a Professor by ID
    public Professor getProfessor(String id) {
        return dataPool.getProfessor(id);
    }

    // Update an existing Professor
    public void updateProfessor(Professor professor) {
        dataPool.update(professor);
    }

    // Delete a Professor
    public void deleteProfessor(String id) {
        dataPool.delete(id);
    }

    // Retrieve all Professors
    public List<Professor> getAllProfessors() {
        return dataPool.getAllProfessors();
    }
}