package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.io.File;  // Add this line

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.Block;
import model.Course;
import model.Module;
import model.Name;
import model.StudentProfile;
import view.FinalYearOptionsRootPane;
import view.OverviewSelectionPane;
import view.ReserveModulesPane;
import view.SelectModulesPane;
import view.CreateStudentProfilePane;
import view.FinalYearOptionsMenuBar;

public class FinalYearOptionsController {
	private Stage primaryStage;

	//fields to be used throughout class
	private FinalYearOptionsRootPane view;
	private StudentProfile model;
	
	private CreateStudentProfilePane cspp;
	private FinalYearOptionsMenuBar mstmb;
    private SelectModulesPane  cspp1;  
    private ReserveModulesPane rm;
    private OverviewSelectionPane os;

    

	public FinalYearOptionsController(FinalYearOptionsRootPane view, StudentProfile model) {
		//initialise view and model fields
		this.view = view;
		this.model = model;
		
		//initialise view subcontainer fields
		cspp = view.getCreateStudentProfilePane();
		mstmb = view.getModuleSelectionToolMenuBar();
	    cspp1 = view.getSelectModulesPane();
	    rm = view.getReserveModulesPane();
	    os = view.getOverviewSelectionPane();
	    //add courses to combobox in create student profile pane using the buildModulesAndCourses helper method below
		cspp.addCourseDataToComboBox(buildModulesAndCourses());
//        cspp1.addCourseDataToComboBox(buildModulesAndCourses());
//        rm.addCourseDataToComboBox(buildModulesAndCourses());
//        os.addCourseDataToComboBox(buildModulesAndCourses());
		//attach event handlers to view using private helper method
		this.attachEventHandlers();
	}

	




	//helper method - used to attach event handlers
	private void attachEventHandlers() {
		//attach an event handler to the create student profile pane
		cspp.addCreateStudentProfileHandler(new CreateStudentProfileHandler());
       cspp1.addAddModuleHandler(new AddModuleHandler());
       cspp1.addResetHandler(new ResetHandler());
       cspp1.addRemoveModuleHandler(new RemoveModuleHandler());
       cspp1.addSubmitHandler(new SubmitHandler());
       rm.setOnAddButtonAction(event -> handleAddAction());
      rm.setOnRemoveButtonAction(event -> handleRemoveAction());
       rm.setOnConfirmButtonAction(event -> handleConfirmAction());
		os.addSaveOverviewHandler(new SaveOverviewHandler());
		
       //attach an event handler to the menu bar that closes the application
		mstmb.addExitHandler(e -> System.exit(0));
		mstmb.addAboutHandler(e ->this.alertDialogBuilder(AlertType.INFORMATION, "Information Dialog", null, "Register MVC app v2.0"));;
	}
	
	//event handler (currently empty), which can be used for creating a profile
	public class CreateStudentProfileHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			
			            // Gather inputs from CreateStudentProfilePane
			            String studentPnumber = cspp.getStudentPnumber(); // Assuming a method to get student's P number
			            Name studentName = cspp.getStudentName(); // Assuming a method to get student's name
			            String studentEmail = cspp.getStudentEmail(); // Assuming a method to get student's email
			            LocalDate submissionDate = cspp.getStudentDate(); // Assuming a method to get the submission date
			            Course selectedCourse = cspp.getSelectedCourse(); // Assuming a method to get the selected course

			            // Update the StudentProfile model
			            StudentProfile newProfile = new StudentProfile();
			            newProfile.setStudentPnumber(studentPnumber);
			            newProfile.setStudentName(studentName);
			            newProfile.setStudentEmail(studentEmail);
			            newProfile.setSubmissionDate(submissionDate);
			            newProfile.setStudentCourse(selectedCourse);

			            model = newProfile; // Updating the model

			            // Update SelectModulesPane with modules based on the chosen course
			            updateSelectModulesPane(selectedCourse);
			        }

			        private void updateSelectModulesPane(Course course) {
			            List<Module> compulsoryModules = course.getCompulsoryModules();
			            List<Module> optionalModules = course.getOptionalModules();

			            // Clear current selections in SelectModulesPane
			            cspp1.clearModules();

			            // Add compulsory modules to the selected list
			            for (Module module : compulsoryModules) {
			                cspp1.addSelectedModule(module);
			            }

			            // Optionally, handle the addition of optional modules to the unselected list
			            for (Module module : optionalModules) {
			                cspp1.addUnselectedModule(module);
			            }
			        }
			    }
			
		
		private class ResetHandler implements EventHandler<ActionEvent> {
		    @Override
		    public void handle(ActionEvent e) {
		  
		                // Get the current student's course
		                Course currentCourse = model.getStudentCourse();

		                if (currentCourse != null) {
		                    // Call the instance methods on the Course object
		                    List<Module> compulsoryModules = currentCourse.getCompulsoryModules();
		                    List<Module> optionalModules = currentCourse.getOptionalModules();
		            
		                
		        // Populate the UI with compulsory modules (selected by default)
		        for (Module module : compulsoryModules) {
		            cspp1.addSelectedModule(module);
		        }

		        // Populate the UI with optional modules (unselected)
		        for (Module module : optionalModules) {
		            cspp1.addUnselectedModule(module);
		        }

		        // Update the student profile with the reset selections
		        model.setSelectedModules(compulsoryModules);
		        model.setOptionalModules(optionalModules);

		
//		                SelectModulesPane.getbtnReset().setOnAction(new ResetHandler());
		                }}
		} 
//		private class reserveRemoveModuleHandler implements EventHandler<ActionEvent> {
//	        @Override
//	        public void handle(ActionEvent event) {
//	            Module selectedModule = rm.getSelectedModule(); // Assuming a method to get the selected module
//
//	            if (selectedModule != null) {
//	                // Logic to remove the selected module from the reserved list
//	                // This might involve updating the model and the ReserveModulesPane view
//	                model.removeReservedModule(selectedModule); // Update the model
//	                rm.updateReservedModulesView(); // Refresh the view
//	            }
//	        }
//	    }
		private class AddModuleHandler implements EventHandler<ActionEvent> {
	        @Override
	        public void handle(ActionEvent event) {
	            // Assuming you have methods to get the currently selected unselected module
	            Module unselectedModule = cspp1.getUnselectedModule();

	            if (unselectedModule != null) {
	                // Remove the module from the unselected modules list
	                cspp1.removeUnselectedModule(unselectedModule);

	                // Add the module to the selected or reserved modules list
	                cspp1.addSelectedModule(unselectedModule);

	                
	            }
	        }
	    }
		 private class RemoveModuleHandler implements EventHandler<ActionEvent> {
		        @Override
		        public void handle(ActionEvent event) {
		            // Assuming you have methods to get the selected module
		            Module selectedModule = cspp1.getSelectedModule();

		            if (selectedModule != null) {
		                // Remove from selected or reserved modules
		                model.removeSelectedOrReservedModule(selectedModule);
		                
		                // Add back to unselected modules
		                cspp1.addUnselectedModule(selectedModule);
		            }
		        }
		    }
		 private class SubmitHandler implements EventHandler<ActionEvent> {
		        @Override
		        public void handle(ActionEvent event) {
		            // Assuming methods exist to get selected modules
		            List<Module> selectedModules = cspp1.getSelectedModules();
		            List<Module> unselectedModules = cspp1.getUnselectedModules();

		            // Update the model with selected modules
		            model.setSelectedModules(selectedModules);

		            // Dynamically populate the reserve modules tab
		            rm.populateWithModules(unselectedModules);
		        }
		    }

		 private class SaveOverviewHandler implements EventHandler<ActionEvent> {
	        @Override
	        public void handle(ActionEvent event) {
	            try {
	                PrintWriter writer = new PrintWriter(new File("StudentOverview.txt"));
	                
	                // Assuming methods exist to get the student's details and modules
	                String studentDetails = model.getStudentDetailsAsString();
	                String selectedModules = model.getSelectedModulesAsString();
	                String reservedModules = model.getReservedModulesAsString();

	                // Write to file
	                writer.println("Student Details:");
	                writer.println(studentDetails);
	                writer.println("\nSelected Modules:");
	                writer.println(selectedModules);
	                writer.println("\nReserved Modules:");
	                writer.println(reservedModules);

	                writer.close();
	            } catch (FileNotFoundException e) {
	                e.printStackTrace();
	                // Handle the error appropriately
	            }
	        }
	    }
		 private class SaveProfileHandler implements EventHandler<ActionEvent> {
	        @Override
	        public void handle(ActionEvent event) {
	            try {
	                FileOutputStream fileOut = new FileOutputStream("studentProfile.ser");
	                ObjectOutputStream out = new ObjectOutputStream(fileOut);
	                
	                // Assuming 'model' is your StudentProfile object
	                out.writeObject(model);

	                out.close();
	                fileOut.close();
	            } catch (IOException i) {
	                i.printStackTrace();
	                // Handle the error appropriately
	            }
	        }
	    }
		 private class LoadStudentDataHandler implements EventHandler<ActionEvent> {
	        @Override
	        public void handle(ActionEvent event) {
	            try {
	                FileInputStream fileIn = new FileInputStream("studentProfile.ser");
	                ObjectInputStream in = new ObjectInputStream(fileIn);
	                
	                // Assuming 'model' is your StudentProfile object
	                StudentProfile loadedProfile = (StudentProfile) in.readObject();

	                in.close();
	                fileIn.close();

	                // Update the model
	                model = loadedProfile;

	                // Update the GUI to reflect the loaded data
	                updateGUIWithLoadedData(model);

	            } catch (IOException | ClassNotFoundException e) {
	                e.printStackTrace();
	                // Handle the error appropriately
	            }
	        }
	    }

	    private void updateGUIWithLoadedData(StudentProfile profile) { 
	    	if (profile != null) {
//            // Update CreateStudentProfilePane with the student's details
//            cspp.setStudentName(profile.getStudentName());
//            cspp.setStudentPNumber(profile.getStudentPnumber());
//            cspp.setStudentEmail(profile.getStudentEmail());
//            cspp.setSubmissionDate(profile.getSubmissionDate());
//            cspp.setSelectedCourse(profile.getStudentCourse());
//
//            // Update SelectModulesPane with selected and unselected modules
//            cspp1.clearSelections();
//            cspp1.addSelectedModules(profile.getSelectedModules());
            // Here you might need to determine which modules should be unselected
            // This could depend on the course and the modules already selected
            // cspp1.addUnselectedModules(determinedUnselectedModules);
        }
    }
	        // Implement logic to update all the GUI components
	        // Example: cspp.setStudentDetails(profile.getDetails());
	        // Update other panes like SelectModulesPane, ReserveModulesPane, etc.
	    

	    private void alertDialogBuilder(AlertType type, String title, String header, String content) {
	            Alert alert = new Alert(AlertType.INFORMATION);
	            alert.setTitle("About");
	            alert.setHeaderText("Final Year Module Selection Tool");
	            alert.setContentText("Version 1.0\nDeveloped by [Your Name]\n\nThis application helps final year students select their modules.");

	            alert.showAndWait();
	        }
	    
//	    private void handleExit() {
//	        primaryStage.close(); // Close the main application window
//	        Platform.exit();      // Terminate the application
//	    }



	//helper method - builds modules and course data and returns courses within an array
	private Course[] buildModulesAndCourses() {
		Module ctec3701 = new Module("CTEC3701", "Software Development: Methods & Standards", 30, true, Block.BLOCK_1);

		Module ctec3702 = new Module("CTEC3702", "Big Data and Machine Learning", 30, true, Block.BLOCK_2);
		Module ctec3703 = new Module("CTEC3703", "Mobile App Development and Big Data", 30, true, Block.BLOCK_2);

		Module ctec3451 = new Module("CTEC3451", "Development Project", 30, true, Block.BLOCK_3_4);

		Module ctec3704 = new Module("CTEC3704", "Functional Programming", 30, false, Block.BLOCK_3_4);
		Module ctec3705 = new Module("CTEC3705", "Advanced Web Development", 30, false, Block.BLOCK_3_4);

		Module imat3711 = new Module("IMAT3711", "Privacy and Data Protection", 30, false, Block.BLOCK_3_4);
		Module imat3722 = new Module("IMAT3722", "Fuzzy Logic and Inference Systems", 30, false, Block.BLOCK_3_4);

		Module ctec3706 = new Module("CTEC3706", "Embedded Systems and IoT", 30, false, Block.BLOCK_3_4);


		Course compSci = new Course("Computer Science");
		compSci.addModule(ctec3701);
		compSci.addModule(ctec3702);
		compSci.addModule(ctec3451);
		compSci.addModule(ctec3704);
		compSci.addModule(ctec3705);
		compSci.addModule(imat3711);
		compSci.addModule(imat3722);

		Course softEng = new Course("Software Engineering");
		softEng.addModule(ctec3701);
		softEng.addModule(ctec3703);
		softEng.addModule(ctec3451);
		softEng.addModule(ctec3704);
		softEng.addModule(ctec3705);
		softEng.addModule(ctec3706);

		Course[] courses = new Course[2];
		courses[0] = compSci;
		courses[1] = softEng;

		return courses;
	}
	private void handleAddAction() {
	    // Retrieve the selected module from the unselected list
	    Module selectedModule = rm.getUnselectedModule();

	    // Check if a module is actually selected
	    if (selectedModule != null) {
	        // Add the module to the reserved (selected) list
	        rm.addModuleToSelectedList(selectedModule);

	        // Optionally, remove the module from the unselected list
	        rm.removeModuleFromUnselectedList(selectedModule);

	        // Update the view if necessary, for instance, updating a label showing the number of selected modules
	        rm.updateReservedModulesView();
	    }
	}
	private void handleRemoveAction() {
	    // Retrieve the selected module from the selected (reserved) list
	    Module selectedModule = rm.getSelectedModule();

	    // Check if a module is actually selected
	    if (selectedModule != null) {
	        // Remove the module from the reserved (selected) list
	        rm.removeModuleFromSelectedList(selectedModule);

	        // Optionally, add the module back to the unselected list
	        rm.addModuleToUnselectedList(selectedModule);

	        // Update the view, for example, updating labels or lists to reflect the current state
	       rm.updateReservedModulesView();
	    }
	}
	private void handleConfirmAction() {
	    // Retrieve all modules from the reserved (selected) list
	    ObservableList<Module> reservedModules = rm.getReservedModules();

	    // Check if there are reserved modules
	    if (reservedModules != null && !reservedModules.isEmpty()) {
	        // Update the model with the reserved modules
	        // Assuming model is your data model and has a method to set reserved modules
	        model.setReservedModules(new HashSet<>(reservedModules));

	        // Optionally, update other parts of the UI
	        // For example, update an overview pane or confirm the selection in the UI
	        os.updateWithReservedModules(reservedModules);
	    } else {
	        // Handle the case where no modules are reserved
	        // For example, show an alert or a message to the user
	        showAlert("No modules have been reserved.");
	    }
	}
	  private void showAlert(String message) {
	        Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("Information");
	        alert.setHeaderText(null); // No header text
	        alert.setContentText(message);

	        alert.showAndWait();
	    }


}

		

