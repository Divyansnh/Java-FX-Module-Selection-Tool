package view;

import java.beans.EventHandler;
import java.util.Set;
import model.Module;
import controller.FinalYearOptionsController.CreateStudentProfileHandler;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import model.Course;
import model.StudentProfile;

public class OverviewSelectionPane extends GridPane {

    private Label profileLabel, selectedLabel, reservedLabel;
    private TextArea profileOverview, selectedOverview, reservedOverview;
    private Button saveBtn;

    public OverviewSelectionPane() {
        this.setPadding(new Insets(10));
        this.setVgap(10);
        this.setHgap(10);

        profileLabel = new Label("Profile Overview:");
        selectedLabel = new Label("Selected modules:");
        reservedLabel = new Label("Reserved modules:");

        profileOverview = new TextArea("Profile will be displayed here");
        selectedOverview = new TextArea("Selected modules will be displayed here");
        reservedOverview = new TextArea("Reserved modules will be displayed here");
        saveBtn = new Button("Save overview");

        this.add(profileLabel, 0, 0, 2, 1);
        this.add(profileOverview, 0, 1, 2, 1);

        this.add(selectedLabel, 0, 2);
        this.add(selectedOverview, 0, 3);

        this.add(reservedLabel, 1, 2);
        this.add(reservedOverview, 1, 3);

        this.add(saveBtn, 0, 4, 2, 1);
        GridPane.setHalignment(saveBtn, HPos.CENTER);}
        
        // Method to update the displayed information based on the student profile and module selection
     public void setProfile(String string) {
    	 profileOverview.setText(string);
    	 
     }
     public void setSelectedModules(String string) {
    	 selectedOverview.setText(string);
     }
     public void setReservedModules(String string) {
    	 reservedOverview.setText(string);
     }  

     public void updateWithReservedModules(ObservableList<Module> reservedModules) {
         StringBuilder reservedModulesString = new StringBuilder();
         if (reservedModules != null && !reservedModules.isEmpty()) {
             for (Module module : reservedModules) {
                 reservedModulesString.append(module.toString()).append("\n");
             }
         } else {
             reservedModulesString.append("No reserved modules");
         }

         setReservedModules(reservedModulesString.toString());
     }
     public void updateWithSelectedModules(ObservableList<Module> selectedModules) {
         StringBuilder selectedModulesString = new StringBuilder();
         if (selectedModules != null && !selectedModules.isEmpty()) {
             for (Module module : selectedModules) {
                 selectedModulesString.append(module.toString()).append("\n");
             }
         } else {
             selectedModulesString.append("No reserved modules");
         }

         setSelectedModules(selectedModulesString.toString());
     }

//
     // Method to populate the overview with student profile and module details
     public void populateOverview(StudentProfile profile) {
         if (profile != null) {
             // Assuming StudentProfile has methods to get details as a string
             String studentDetails = profile.getStudentDetailsAsString();
             String selectedModules = profile.getSelectedModulesAsString();
             String reservedModules = profile.getReservedModulesAsString();

             profileOverview.setText("Profile Details:\n" + studentDetails);
             selectedOverview.setText("Selected Modules:\n" + selectedModules);
             reservedOverview.setText("Reserved Modules:\n" + reservedModules);
         } else {
             profileOverview.setText("Profile details not available");
             selectedOverview.setText("Selected modules not available");
             reservedOverview.setText("Reserved modules not available");
         }
     }
     public void addSaveOverviewHandler (javafx.event.EventHandler<ActionEvent> handler) {
	    	saveBtn.setOnAction(handler);
	       }
   
//	public void addCreateStudentProfileHandler(CreateStudentProfileHandler createStudentProfileHandler) {
//		// TODO Auto-generated method stub
		
}

//	public void addCourseDataToComboBox(Course[] buildModulesAndCourses) {
//		// TODO Auto-generated method stub
//		
	
    