package view;

import java.util.ArrayList;
import java.util.List;

import controller.FinalYearOptionsController.CreateStudentProfileHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
//import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Block;
import model.Module;

public class SelectModulesPane extends GridPane {
	 private ObservableList<Module> selectedModules;

    private ListView<Module> lvBlock1Selected;
    private ListView<Module> lvBlock2Selected;
    private ListView<Module> lvBlock34Unselected;
    private ListView<Module> lvBlock34Selected;
    ;  
   
    private Label lblCredits;
    private Button btnAdd;
    private Button btnRemove;
    private Button btnReset;
    private Button btnSubmit;

    public SelectModulesPane() {
        initializeControls();
        layoutControls();
    }

    private void initializeControls() {
        lvBlock1Selected = new ListView<>();
        lvBlock2Selected = new ListView<>();
        lvBlock34Unselected = new ListView<>();
        lvBlock34Selected = new ListView<>();
        selectedModules = FXCollections.observableArrayList();
        lblCredits = new Label("Accumulated Credits: 0");
        btnAdd = new Button("Add");
        btnRemove = new Button("Remove");
        btnReset = new Button("Reset");
        btnSubmit = new Button("Submit");
    }

    private void layoutControls() {
        setPadding(new Insets(20));
        setHgap(8);
        setVgap(10);
        
        Label ds = new Label ("Block 3/4");
        Label lblSelectedBlock1 = new Label ("Selected Block 1 Modules");
        Label lblSelectedBlock2 = new Label ("Selected Block 2 Modules");
        Label lblUnselectedBlock34 = new Label ("Unselected Block 3/4 Modules");
        Label lblSelectedBlock34 = new Label ("Selected Block 3/4 Modules");

        VBox vboxBlock1 = new VBox (10, lblSelectedBlock1, lvBlock1Selected);
        VBox vboxBlock2 = new VBox (10, lblSelectedBlock2, lvBlock2Selected);
        VBox vboxBlock34Unselected = new VBox(6,lblUnselectedBlock34, lvBlock34Unselected);
        VBox vboxBlock34Selected = new VBox(6,lblSelectedBlock34, lvBlock34Selected);

        VBox vboxLeft = new VBox(vboxBlock1, vboxBlock2);
        HBox buttonsBox	= new HBox(10,ds,btnAdd, btnRemove);
		VBox vboxRight = new VBox(vboxBlock34Unselected,buttonsBox, vboxBlock34Selected);
        vboxLeft.setAlignment(Pos.CENTER);
        vboxRight.setAlignment(Pos.CENTER);
        
        HBox buttonBox = new HBox(10, btnReset, btnSubmit);
        
        HBox creditsBox = new HBox(10,lblCredits);
        buttonBox.setAlignment(Pos.CENTER);
        creditsBox.setAlignment(Pos.CENTER);
        buttonsBox.setAlignment (Pos.CENTER);
        add(vboxLeft, 0, 0);
        add(vboxRight, 1, 0);
        add(creditsBox, 0, 1, 2, 1);
        add(buttonBox, 0, 2, 2, 1);
    }
        // Additional methods for updating module lists and credits label based on the model
        public void updatelvBlock1Selected(ObservableList<Module> list1) {
            lvBlock1Selected.setItems(list1);
            updateCreditsLabel();
        }

        public void updateBlock2SelectedModules(ObservableList<Module> list1) {
            lvBlock2Selected.setItems(list1);
            updateCreditsLabel();
        }

        public void updateBlock34UnselectedModules(ObservableList<Module> list1) {
            lvBlock34Unselected.setItems(list1);
        }

        public void updateBlock34SelectedModules(ObservableList<Module> list1) {
            lvBlock34Selected.setItems(list1);
            updateCreditsLabel();
        }

        public void updateCreditsLabel() {
            int totalCredits = calculateTotalCredits();
            lblCredits.setText("Accumulated Credits: " + totalCredits);
        }
    
        
    
        // Method to calculate the total credits from selected modules
  
        public int calculateTotalCredits() {
            int totalCredits = 0;
            for (Module module : selectedModules) {
                totalCredits += module.getModuleCredits();
            }
            return totalCredits;
        }
        
//	public void addCourseDataToComboBox(Course[] buildModulesAndCourses) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void addCreateStudentProfileHandler(CreateStudentProfileHandler createStudentProfileHandler) {
//		// TODO Auto-generated method stub
//		
//	}
        public void addSelectedModule(Module module) {
            // Determine which block the module belongs to
            switch (module.getRunPlan()) {
                case BLOCK_1:
                    lvBlock1Selected.getItems().add(module);
                    break;
                case BLOCK_2:
                    lvBlock2Selected.getItems().add(module);
                    break;
                // Assuming BLOCK_3 and BLOCK_4 modules go to the same list
                case BLOCK_3_4:
                    lvBlock34Selected.getItems().add(module);
                    break;
                    default:
                    // Handle the case where the block is not recognized
                    // You might want to add some error handling or logging here
            }}


	

        public void addSelectedModuleFromUnselected() {
            Module selectedModule = lvBlock34Unselected.getSelectionModel().getSelectedItem();

            if (selectedModule != null) {
               
                lvBlock34Selected.getItems().add(selectedModule);
                updateCreditsLabel();
            }
	                
	                updateCreditsLabel();}
	        
	// Method to remove a selected module
	    public void removeSelectedModule() {
	        // Assuming that only one module can be selected at a time in each ListView
	        Module selectedModuleInBlock1 = lvBlock1Selected.getSelectionModel().getSelectedItem();
	        Module selectedModuleInBlock2 = lvBlock2Selected.getSelectionModel().getSelectedItem();
	        Module selectedModuleInBlock34 = lvBlock34Selected.getSelectionModel().getSelectedItem();

	        // Remove the selected module from the respective ListView
	        if (selectedModuleInBlock1 != null) {
	            lvBlock1Selected.getItems().remove(selectedModuleInBlock1);
	        }
	        if (selectedModuleInBlock2 != null) {
	            lvBlock2Selected.getItems().remove(selectedModuleInBlock2);
	        }
	        if (selectedModuleInBlock34 != null) {
	            lvBlock34Selected.getItems().remove(selectedModuleInBlock34);
	        }

	        // Update the accumulated credits label
	        updateCreditsLabel();
	    }







	// Method to clear all module selections
    public  void clearSelections() {
       // Clear selections in each ListView
       lvBlock1Selected.getItems().clear();
       lvBlock2Selected.getItems().clear();
       lvBlock34Unselected.getItems().clear();
       lvBlock34Selected.getItems().clear();
    }

	public  void addUnselectedModule(Module module) {
		  lvBlock34Unselected.getItems().add(module);
		
	}

	public Object getbtnReset() {
		// TODO Auto-generated method stub
		return btnReset;
	}
	public Module getSelectedModule(Block block) {
        switch (block) {
            case BLOCK_1:
                return lvBlock1Selected.getSelectionModel().getSelectedItem();
            case BLOCK_2:
                return lvBlock2Selected.getSelectionModel().getSelectedItem();
            case BLOCK_3_4:
                return lvBlock34Selected.getSelectionModel().getSelectedItem();
            default:
                return null; // or handle differently if needed
        }
    }   
	public List<Module> getUnselectedModules() {
        List<Module> unselectedModules = new ArrayList<>();
        unselectedModules.addAll(lvBlock34Unselected.getItems()); // Add all unselected Block 3/4 modules

        // Add unselected modules from other blocks if applicable
        // Example: unselectedModules.addAll(lvBlockXUnselected.getItems());

        return unselectedModules;
    }
	 // Method to get all selected modules across blocks
    public List<Module> getSelectedModules() {
        List<Module> selectedModules = new ArrayList<>();

        // Add all selected modules from each block
        selectedModules.addAll(lvBlock1Selected.getItems());
        selectedModules.addAll(lvBlock2Selected.getItems());
        selectedModules.addAll(lvBlock34Selected.getItems());

        return selectedModules;
    }     
    public Module getSelectedModule() {
        if (lvBlock1Selected.getSelectionModel().getSelectedItem() != null) {
            return lvBlock1Selected.getSelectionModel().getSelectedItem();
        } else if (lvBlock2Selected.getSelectionModel().getSelectedItem() != null) {
            return lvBlock2Selected.getSelectionModel().getSelectedItem();
        } else if (lvBlock34Selected.getSelectionModel().getSelectedItem() != null) {
            return lvBlock34Selected.getSelectionModel().getSelectedItem();
        }

        return null; // No module is currently selected
    }   
    public Module getUnselectedModule() {
        return lvBlock34Unselected.getSelectionModel().getSelectedItem();
    }
    public void removeUnselectedModule(Module module) {
        lvBlock34Unselected.getItems().remove(module);
    }

	public void clearModules() {
        // Clear selected modules in each block
        lvBlock1Selected.getItems().clear();
        lvBlock2Selected.getItems().clear();
        lvBlock34Selected.getItems().clear();

        // Clear unselected modules in Block 3/4
        lvBlock34Unselected.getItems().clear();

        // Update any other necessary UI components
        updateCreditsLabel(); // Assuming this method updates the credits display
    }
		// TODO Auto-generated method stub
		
	    public void addAddModuleHandler(EventHandler<ActionEvent> handler) {
	btnAdd.setOnAction(handler);
   }
	   public void addResetHandler(EventHandler<ActionEvent> handler) {
	    	btnReset.setOnAction(handler);
	       }
	   public void addRemoveModuleHandler(EventHandler<ActionEvent> handler) {
	    	btnRemove.setOnAction(handler);
}
	   public void addSubmitHandler(EventHandler<ActionEvent> handler) {
	    	btnSubmit.setOnAction(handler);
}
}