package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Course {
	
	private String courseName;
	private Map<String, Module> modulesOnCourse;
	
	public Course(String courseName) {
		this.courseName = courseName;
		modulesOnCourse = new HashMap<String, Module>();
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public void addModule(Module m) {
		modulesOnCourse.put(m.getModuleCode(), m);
	}
	
	public Module getModuleByCode(String code) {
		return modulesOnCourse.get(code);
	}
	
	public Collection<Module> getAllModulesOnCourse() {
		return modulesOnCourse.values();
	}
	
	@Override
	public String toString() {
		//a non-standard toString that simply returns the course name,
		//so as to assist in displaying courses correctly in a ComboBox<Course>
		return courseName;
	}
	
	public String actualToString() {
		return "Course:[courseName=" + courseName + ", modulesOnCourse=" + modulesOnCourse + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Course other)
				&& this.courseName.equals(other.courseName) 
				&& this.modulesOnCourse.equals(other.modulesOnCourse);
	}

	
	    // Method to get compulsory modules
	    public List<Module> getCompulsoryModules() {
	        List<Module> compulsoryModules = new ArrayList<>();
	        for (Module module : modulesOnCourse.values()) {
	            if (module.isMandatory()) {  // Assuming Module has isCompulsory method
	                compulsoryModules.add(module);
	            }
	        }
	        return compulsoryModules;
	    }
	

	public List<Module> getOptionalModules() {
	    // Method to get optional modules
	   
	        List<Module> optionalModules = new ArrayList<>();
	        for (Module module : modulesOnCourse.values()) {
	            if (!module.isMandatory()) {
	                optionalModules.add(module);
	            }
	        }
	        return optionalModules;
	    }

}



	

