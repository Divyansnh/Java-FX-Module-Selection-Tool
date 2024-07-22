package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;


public class StudentProfile {

	private String studentPnumber;
	private Name studentName;
	private String studentEmail;
	private LocalDate studentDate;
	private Course studentCourse;
	private Set<Module> selectedModules;
	private Set<Module> reservedModules;
	
	public StudentProfile() {
		studentPnumber = "";
		studentName = new Name();
		studentEmail = "";
		studentDate = null;
		studentCourse = null;
		selectedModules = new TreeSet<Module>();
		reservedModules = new TreeSet<Module>();
	}
	
	public String getStudentPnumber() {
		return studentPnumber;
	}
	
	public void setStudentPnumber(String studentPnumber) {
		this.studentPnumber = studentPnumber;
	}
	
	public Name getStudentName() {
		return studentName;
	}
	
	public void setStudentName(Name studentName) {
		this.studentName = studentName;
	}
	
	public String getStudentEmail() {
		return studentEmail;
	}
	
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	
	public LocalDate getSubmissionDate() {
		return studentDate;
	}
	
	public void setSubmissionDate(LocalDate studentDate) {
		this.studentDate = studentDate;
	}
	
	public  Course getStudentCourse() {
		return studentCourse;
	}
	
	public void setStudentCourse(Course studentCourse) {
		this.studentCourse = studentCourse;
	}
	
	public boolean addSelectedModule(Module m) {
		return selectedModules.add(m);
	}
	
	public Set<Module> getAllSelectedModules() {
		return selectedModules;
	}
	
	public void clearSelectedModules() {
		selectedModules.clear();
	}
	
	public boolean addReservedModule(Module m) {
		return reservedModules.add(m);
	}
	
	public Set<Module> getAllReservedModules() {
		return reservedModules;
	}
	
	public void clearReservedModules() {
		reservedModules.clear();
	}
	
	@Override
	public String toString() {
		return "StudentProfile:[Pnumber=" + studentPnumber + ", studentName="
				+ studentName + ", studentEmail=" + studentEmail + ", studentDate="
				+ studentDate + ", studentCourse=" + studentCourse.actualToString() 
				+ ", selectedModules=" + selectedModules
				+ ", reservedModules=" + reservedModules + "]";
	}
	   public void setSelectedModules(List<Module> compulsoryModules) {
	        this.selectedModules = new HashSet<>(compulsoryModules);
	    }

	public  void setOptionalModules(List<Module> optionalModules) {
		   
		        this.selectedModules = new HashSet<>(optionalModules);
		    }

	public void removeSelectedOrReservedModule(Module selectedModule) {
		// TODO Auto-generated method stub
		
	}


		// TODO Auto-generated method stub
	
	    // ... existing fields and methods ...

	    public String getStudentDetailsAsString() {
	        StringBuilder details = new StringBuilder();
	        details.append("Student P-Number: ").append(studentPnumber).append("\n");
	        details.append("Student Name: ").append(studentName.getFullName()).append("\n"); // Assuming Name class has a getFullName method
	        details.append("Student Email: ").append(studentEmail).append("\n");
	        details.append("Submission Date: ");
	        if (studentDate != null) {
	            details.append(studentDate.toString());
	        } else {
	            details.append("Not set");
	        }
	        if (studentCourse != null) {
	            details.append("Course: ").append(studentCourse.getCourseName()).append("\n");
	        } else {
	            details.append("Course: Not set\n");
	        }
	        details.append("Selected Modules: ");
	        if (selectedModules != null) {
	            for (Module module : selectedModules) {
	                if (module != null) {
	                    details.append(module.toString()).append(", ");
	                } else {
	                    details.append("Null Selected Module, ");
	                }
	            }
	        } else {
	            details.append("No Selected Modules, ");
	        }

	        // Handle unselected modules
	        details.append("\nUnselected Modules: ");
	        if (reservedModules != null) {
	            for (Module module : reservedModules) {
	                if (module != null) {
	                    details.append(module.toString()).append(", ");
	                } else {
	                    details.append("Null Unselected Module, ");
	                }
	            }
	        } else {
	            details.append("No Unselected Modules");
	        }


	        return details.toString().trim(); // Removes any trailing comma or whitespace
	    }

	    // ... rest of your class ...
	


	    public String getSelectedModulesAsString() {
	        if (selectedModules == null || selectedModules.isEmpty()) {
	            return "No selected modules";
	        }

	        StringBuilder modulesString = new StringBuilder();
	        for (Module module : selectedModules) {
	            modulesString.append(module.toString()).append(", "); // Assuming Module class has a meaningful toString implementation
	        }

	        // Remove the trailing comma and space
	        if (modulesString.length() > 2) {
	            modulesString.setLength(modulesString.length() - 2);
	        }

	        return modulesString.toString();
	    }
	   
	    
	    	  public String getReservedModulesAsString() {
	    	        if (reservedModules == null || reservedModules.isEmpty()) {
	    	            return "Reserved Modules: None";
	    	        }

	    	        String modulesString = reservedModules.stream()
	    	            .map(module -> module != null ? module.toString() : "Null Module")
	    	            .collect(Collectors.joining(", "));

	    	        return "Reserved Modules: " + modulesString;
	    	    }

	    // Overloaded method to accept a single Module
	    public void setReservedModule(Module reservedModule) {
	        this.reservedModules = new HashSet<>();
	        this.reservedModules.add(reservedModule);
	    }

	    // Overloaded method to accept a Set of Modules
	    public void setReservedModules(Set<Module> reservedModules) {
	        this.reservedModules = reservedModules;
	    }
	    public void removeReservedModule(Module module) {
	        if (module != null) {
	            reservedModules.remove(module);
	        }
	    }

}

