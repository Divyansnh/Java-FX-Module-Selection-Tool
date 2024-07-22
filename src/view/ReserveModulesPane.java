
	package view;

	
	import java.util.List;
import java.util.Set;

import controller.FinalYearOptionsController.CreateStudentProfileHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
	import javafx.geometry.Pos;
	import javafx.scene.control.Button;
	import javafx.scene.control.Label;
	import javafx.scene.control.ListView;
	import javafx.scene.layout.GridPane;
	import javafx.scene.layout.HBox;
	import javafx.scene.layout.VBox;
import model.Course;
import model.Module;

	public class ReserveModulesPane extends GridPane {

	    private ListView<Module> lvUnselectedBlock34;
	    private ListView<Module> lvSelectedBlock34;
	    private Button btnAdd;
	    private Button btnRemove;
	    private Button btnConfirm;
	    private ObservableList<Module> reservedModules;
	    public ReserveModulesPane() {
	        initializePane();
	        
	    }

	    private void initializePane() {
	        this.setPadding(new Insets(15));
	        this.setVgap(10);
	        this.setHgap(10);
	        reservedModules = FXCollections.observableArrayList();
	        
	        Label lblUnselectedBlock34 = new Label("Unselected Block 3/4 Modules");
	        Label lblSelectedBlock34 = new Label("Reserved Block 3/4 Modules");

	        lvUnselectedBlock34 = new ListView<>();
	        lvSelectedBlock34 = new ListView<>();

	        btnAdd = new Button("Add");
	        btnRemove = new Button("Remove");
	        btnConfirm = new Button("Confirm");
	

            HBox buttonsBox = new HBox(10, btnAdd, btnRemove, btnConfirm);
	        buttonsBox.setAlignment(Pos.CENTER);

	        VBox listsBox = new VBox(10, lblUnselectedBlock34, lvUnselectedBlock34);
	        		
	        listsBox.setAlignment(Pos.CENTER);
	        
	        VBox listBox = new VBox(10,lblSelectedBlock34, lvSelectedBlock34);
	        listBox.setAlignment(Pos.CENTER);
	        
            this.add(listBox, 1,0);
	        this.add(listsBox, 0, 0);
            this.add(buttonsBox, 0, 1, 2, 1);}
//	private Object onConfirmButtonClicked() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//	  public Module getReservedModule() {
//	        return lvSelectedBlock34.getSelectionModel().getSelectedItem();
//	    }

    // Placeholder method for Add button click event handle
	// Inside ReserveModulesPane class

    // ...

   // Placeholder method for Add button click event handler
//	     private void onAddButtonClicked() {
//	         Module selectedModule = lvUnselectedBlock34.getSelectionModel().getSelectedItem();
//	         if (selectedModule != null) 
//	        	 // Add the selected module to the selected list
//	             addModuleToSelectedList(selectedModule);
//
//	             // Remove the selected module from the unselected list
//	             removeModuleFromUnselectedList(selectedModule);
//	         }
//	     

     // Method to add a module to the selected list
	     public void addModuleToSelectedList(Module module) {
	         if (module != null) {
	             lvSelectedBlock34.getItems().add(module);
	         }
	     }   
	     public Module getUnselectedModule() {
	         return lvUnselectedBlock34.getSelectionModel().getSelectedItem();
	     }
	     public Module getSelectedModule() {
	         return lvSelectedBlock34.getSelectionModel().getSelectedItem();
	     }
	     // Method to remove a module from the unselected list
	     public void removeModuleFromUnselectedList(Module module) {
	         if (module != null) {
	             lvUnselectedBlock34.getItems().remove(module);
	         }
	     }
	         
//	       Placeholder method for Remove button click event handler
	       
	         public void setOnAddButtonAction(EventHandler<ActionEvent> handler) {
	             btnAdd.setOnAction(handler);
	         }

	         // Method to set the event handler for the "Remove" button
	         public void setOnRemoveButtonAction(EventHandler<ActionEvent> handler) {
	             btnRemove.setOnAction(handler);
	         }

	         // Method to set the event handler for the "Confirm" button
//	         public void setOnConfirmButtonAction(EventHandler<ActionEvent> handler) {
//	             btnConfirm.setOnAction(handler);
//	         }
	         public void setOnConfirmButtonAction(EventHandler<ActionEvent> handler) {
	             btnConfirm.setOnAction(handler);
	         } // Method to remove a module from the selected (reserved) list
	        
	         public void removeModuleFromSelectedList(Module module) {
	             if (module != null) {
	                 lvSelectedBlock34.getItems().remove(module);
	             }}
//	         // Method to add a module to the unselected list
	     public void addModuleToUnselectedList(Module module) {
	         if (module != null) {
	             lvUnselectedBlock34.getItems().add(module);
	         }
	     }
	         // Method to remove a module from the selected list
      
         public void updateReservedModulesView() {
             // Clear the current items in the ListView
           

             // Add the updated list of reserved modules
             if (reservedModules != null) {
                 lvSelectedBlock34.getItems().addAll(reservedModules);
                 updateCreditsLabel();
             }}

private void updateCreditsLabel() {
			// TODO Auto-generated method stub
			
		}

//		public void addCourseDataToComboBox(Course[] buildModulesAndCourses) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		public void addCreateStudentProfileHandler(CreateStudentProfileHandler createStudentProfileHandler) {
//			// TODO Auto-generated method stub
//			
//		}	 

 public ObservableList<Module> getReservedModules() {
    return lvSelectedBlock34.getItems();
}
     	
		public void addReservedModule(Module module) {
		    reservedModules.add(module);
		}

		public void removeReservedModule(Module module) {
		    reservedModules.remove(module);
		}

		
		 public void populateWithModules(Set<Module> unselectedModules, Set<Module> compulsoryModules) {
		        // Clear existing items from list views
		        lvUnselectedBlock34.getItems().clear();
		        lvSelectedBlock34.getItems().clear();

		        // Add the modules to the respective list views
		        lvUnselectedBlock34.getItems().addAll(unselectedModules);
		        lvSelectedBlock34.getItems().addAll(compulsoryModules);
		    }
		 public Module getReservedModule() {
		        return lvSelectedBlock34.getSelectionModel().getSelectedItem();
		    }

			// TODO Auto-generated method stub
		    public void populateWithModules(List<Module> unselectedModules) {
		        // Assuming lvUnselectedModules is your ListView for unselected modules
		        ObservableList<Module> modulesList = FXCollections.observableArrayList(unselectedModules);
		        lvUnselectedBlock34.setItems(modulesList);
		    }
		 
	}


    
    

