package org.library.LLD.FitnessClassBookingSystem.services;

import org.library.LLD.FitnessClassBookingSystem.enums.ClassType;
import org.library.LLD.FitnessClassBookingSystem.exceptions.ClassNotFoundException;
import org.library.LLD.FitnessClassBookingSystem.models.FitnessClass;
import org.library.LLD.FitnessClassBookingSystem.utils.IDGenerator;
import org.library.LLD.FitnessClassBookingSystem.utils.ValidationUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ClassService {
    private Map<String, FitnessClass> classes;

    public ClassService(){
        this.classes = new ConcurrentHashMap<>();
    }

    public String createClass(String className, ClassType type, String instructor, LocalDateTime scheduledTime, int capacity){
        if(!ValidationUtils.isValidName(className)){
            throw new IllegalArgumentException("Invalid class name");
        }
        if(!ValidationUtils.isValidName(instructor)){
            throw new IllegalArgumentException("Invalid instructor name");
        }
        if(!ValidationUtils.isValidScheduledTime(scheduledTime)){
            throw new IllegalArgumentException("Invalid scheduled time");
        }
        if(!ValidationUtils.isValidCapacity(capacity)){
            throw new IllegalArgumentException("Invalid capacity");
        }

        String classId = IDGenerator.generateClassId();
        FitnessClass fitnessClass = new FitnessClass(classId, className, type, instructor, scheduledTime, capacity);
        classes.put(classId, fitnessClass);
        return classId;
    }

    public boolean cancelClass(String classId){
        FitnessClass fitnessClass = classes.get(classId);
        if(fitnessClass != null){
            fitnessClass.setActive(false);
            return true;
        }
        return false;
    }

    public FitnessClass getClassById(String classId){
        FitnessClass fitnessClass = classes.get(classId);
        if(fitnessClass == null){
            throw new ClassNotFoundException("Class not found for ID: " + classId);
        }
        return fitnessClass;
    }

    public List<FitnessClass> getAvailableClasses(){
        List<FitnessClass> availableClasses = new ArrayList<>();
        for(FitnessClass fitnessClass : classes.values()){
            if(fitnessClass.isActive() && fitnessClass.getScheduledTime().isAfter(LocalDateTime.now())){
                availableClasses.add(fitnessClass);
            }
        }
        return availableClasses;
    }

    public List<FitnessClass> getClassesByType(ClassType type){
        List<FitnessClass> classesByType = new ArrayList<>();
        for (FitnessClass fitnessClass : classes.values()){
            if(fitnessClass.isActive() && fitnessClass.getType() == type){
                classesByType.add(fitnessClass);
            }
        }
        return classesByType;
    }

    public boolean classExist(String classId){
        return classes.containsKey(classId);
    }
}
