import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class tableviewCargoController implements Initializable  {

    @FXML
    private TableView<userEntry> tableviewCargo;

    @FXML
    private TableColumn<userEntry, String> colCargoName;

    @FXML
    private TableColumn<userEntry, String> colCargoPrice;
    
    @FXML
    private Text txtSelectCommodity;
    
    @FXML
    private Text txtSelectIndex;
    
    ObservableList<userEntry> userEntryList =
    	     FXCollections.observableArrayList(
    	    	       new userEntry("Jessica", "14028"),
    	    	       new userEntry("Jon", "33077"),
    	    	       new userEntry("Adam", "183255"),
    	    	       new userEntry("Rachel", "65890"),
    	    	       new userEntry("Josselyn", "19890"),
    	    	       new userEntry("Chris", "69770"),
    	    	       new userEntry("Sasha", "85290")
             );
    
    //init phase   
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colCargoName.setCellValueFactory(new PropertyValueFactory("username"));
        colCargoPrice.setCellValueFactory(new PropertyValueFactory("password"));
        tableviewCargo.setItems(userEntryList);
        
        TableView.TableViewSelectionModel<userEntry> tvSelModel =
                                     tableviewCargo.getSelectionModel();
        
        tvSelModel.selectedIndexProperty().addListener(
                                      new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> changed,
                                Number oldVal, Number newVal) {
              // Display the index of the selection.
              txtSelectIndex.setText("Selected row is " + newVal);
            }
        });
        
        tvSelModel.selectedItemProperty().addListener(new ChangeListener() { 
            @Override  
                public void changed(ObservableValue observable,Object oldValue, Object newValue) {  
                    System.out.println("selection change"); 
                    //强制类型转换 (userEntry)newValue -> 
                    txtSelectCommodity.setText("Selected valur = " + ((userEntry)newValue).getUsername());
            }  
        });  
    }
    
    
}
