/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gamingequipmentrental;

import java.io.File;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.time.temporal.ChronoUnit;
import java.util.List;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.chart.XYChart;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 *
 * @author John
 */
public class DashboardController implements Initializable {
    
    @FXML
    private Button close;
    

    @FXML
    private TextField firstName;

    @FXML
    private Button homeFormButton;

    @FXML
    private Label homeNumCustomers;

    @FXML
    private Label homePeripherals;

    @FXML
    private BarChart<?, ?> homeRevenueChart;

    @FXML
    private Label homeTotalRevenue;

    @FXML
    private LineChart<?, ?> homeCustomersChart;
    
    @FXML
    private AnchorPane homeForm;

    @FXML
    private TextField lastName;

    @FXML
    private Button logoutButton;

    @FXML
    private AnchorPane mainForm;

    @FXML
    private Button minimize;

    @FXML
    private TextField peripheralsBrand;

    @FXML
    private Button peripheralsFormButton;

    @FXML
    private Button peripheralsClearButton;

    @FXML
    private TableColumn<EquipmentData, String> peripheralsColBrand;

    @FXML
    private TableColumn<EquipmentData, String> peripheralsColEqID;

    @FXML
    private TableColumn<EquipmentData, String> peripheralsColModel;

    @FXML
    private TableColumn<EquipmentData, String> peripheralsColPrice;

    @FXML
    private TableColumn<EquipmentData, String> peripheralsColStatus;

    @FXML
    private TableColumn<EquipmentData, String> peripheralsColType;

    @FXML
    private Button peripheralsDeleteButton;

    @FXML
    private TextField peripheralsEqID;

    @FXML
    private AnchorPane peripheralsForm;

    @FXML
    private ImageView peripheralsImageView;

    @FXML
    private Button peripheralsImportButton;

    @FXML
    private Button peripheralsInsertButton;

    @FXML
    private TextField peripheralsModel;

    @FXML
    private TextField peripheralsPrice;

    @FXML
    private TextField peripheralsSearch;

    @FXML
    private ComboBox<?> peripheralsStatus;

    @FXML
    private TableView<EquipmentData> peripheralsTableView;

    @FXML
    private TextField peripheralsType;

    @FXML
    private Button peripheralsUpdateButton;

    @FXML
    private TextField rentAmount;

    @FXML
    private ComboBox<?> rentBrand;

    @FXML
    private Button rentFormButton;
    
    @FXML
    private Button rentButton;

    @FXML
    private Label rentChange;

    @FXML
    private TableColumn<EquipmentData, String> rentColBrand;

    @FXML
    private TableColumn<EquipmentData, String> rentColEqID;

    @FXML
    private TableColumn<EquipmentData, String> rentColModel;

    @FXML
    private TableColumn<EquipmentData, String> rentColPrice;

    @FXML
    private TableColumn<EquipmentData, String> rentColStatus;

    @FXML
    private TableColumn<EquipmentData, String> rentColType;

    @FXML
    private DatePicker rentDate;

    @FXML
    private ComboBox<?> rentEqID;

    @FXML
    private AnchorPane rentForm;

    @FXML
    private ComboBox<?> rentModel;

    @FXML
    private DatePicker rentReturn;

    @FXML
    private TableView<EquipmentData> rentTableView;

    @FXML
    private Label rentTotal;

    @FXML
    private ComboBox<?> rentType;

    @FXML
    private Label username;
    
    private Connection connect;
    
    private PreparedStatement prepare;
    
    private ResultSet result;
    
    private Statement statement;
    
    private Image image;
    
    public void homeAvailablePeripherals() {
        String sql = "SELECT COUNT(id) FROM equipment WHERE status = 'Available'";
        
        int countAvailableEq = 0;
        
        connect = database.connectDb();
        
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            while(result.next()) {
                countAvailableEq = result.getInt("COUNT(id)");
            }
            
            homePeripherals.setText(String.valueOf(countAvailableEq));
        } catch(Exception e) {e.printStackTrace();}
    }
    
    public void homeTotalRevenue() {
        String sql = "SELECT SUM(total) FROM customer";
        
        double sumRevenue = 0;
        
        connect = database.connectDb();
        
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            while(result.next()) {
                sumRevenue = result.getDouble("SUM(total)");
            }
            
            homeTotalRevenue.setText("₱" + String.valueOf(sumRevenue));
        } catch(Exception e) {e.printStackTrace();}
    }
    
    public void homeNumOfCustomers() {
        String sql = "SELECT COUNT(id) FROM customer";
        
        int countUsers = 0;
        
        connect = database.connectDb();
        
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            while(result.next()) {
                countUsers = result.getInt("COUNT(id)");
            }
            
            homeNumCustomers.setText(String.valueOf(countUsers));
        } catch(Exception e) {e.printStackTrace();}
    }
    
    public void homeRevChart() {
        homeRevenueChart.getData().clear();
        
        String sql = "SELECT date_rent, SUM(total) FROM customer GROUP BY date_rent ORDER BY TIMESTAMP(date_rent) ASC LIMIT 6";
        
        connect = database.connectDb();
        
        try {
            XYChart.Series chart = new XYChart.Series();
            
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            while(result.next()) {
                chart.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
            }
            
            homeRevenueChart.getData().add(chart);
        } catch(Exception e) {e.printStackTrace();}
    }
    
    public void homeCustmChart() {
        homeCustomersChart.getData().clear();
        
        String sql = "SELECT date_rent, COUNT(id) FROM customer GROUP BY date_rent ORDER BY TIMESTAMP(date_rent) ASC LIMIT 4";
        
        connect = database.connectDb();
        
        try {
            XYChart.Series chart = new XYChart.Series();
            
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            while(result.next()) {
                chart.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
            }
            
            homeCustomersChart.getData().add(chart);
        } catch(Exception e) {e.printStackTrace();}
    }
    
    public void equipmentInsert() {
        String sql = "INSERT INTO equipment (eqid, type, brand, model, price, status, image, date) "
                + "VALUES(?,?,?,?,?,?,?,?)";
        
        connect = database.connectDb();
        
        try {
            Alert alert;
            
            if(peripheralsEqID.getText().isEmpty()
                    || peripheralsType.getText().isEmpty()
                    || peripheralsBrand.getText().isEmpty()
                    || peripheralsModel.getText().isEmpty()
                    || peripheralsStatus.getSelectionModel().getSelectedItem() == null
                    || peripheralsPrice.getText().isEmpty()
                    || GetData.path == null || GetData.path == "") {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields.");
                alert.showAndWait();
            } else {
                prepare = connect.prepareStatement(sql);
                prepare.setString(1, peripheralsEqID.getText());
                prepare.setString(2, peripheralsType.getText());
                prepare.setString(3, peripheralsBrand.getText());
                prepare.setString(4, peripheralsModel.getText());
                prepare.setString(5, peripheralsPrice.getText());
                prepare.setString(6, (String)peripheralsStatus.getSelectionModel().getSelectedItem());
                
                String uri = GetData.path;
                uri = uri.replace("\\", "\\\\");
                
                prepare.setString(7, uri);
                
                Date date = new Date();
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                
                prepare.setString(8, String.valueOf(sqlDate));
                
                prepare.executeUpdate();
                
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Added!");
                alert.showAndWait();
                
                equipmentShowListData();
                equipmentClear();
            }
        } catch(Exception e) {e.printStackTrace();}
    }
    
    public void equipmentUpdate() {
        
        String uri = GetData.path;
        
        if(uri != null) {
            uri = uri.replace("\\", "\\\\");
        }
        
        String sql = "UPDATE equipment SET type = '" + peripheralsType.getText() + "', brand = '"
                + peripheralsBrand.getText() + "', model = '"
                + peripheralsModel.getText() + "', status = '"
                + peripheralsStatus.getSelectionModel().getSelectedItem() + "', price = '"
                + peripheralsPrice.getText() + "', image = '" + uri
                + "' WHERE eqid = '" + peripheralsEqID.getText() + "'";
        
        connect = database.connectDb();
        
        try {
            Alert alert;
            
            if(peripheralsEqID.getText().isEmpty()
                    || peripheralsType.getText().isEmpty()
                    || peripheralsBrand.getText().isEmpty()
                    || peripheralsModel.getText().isEmpty()
                    || peripheralsStatus.getSelectionModel().getSelectedItem() == null
                    || peripheralsPrice.getText().isEmpty()
                    || GetData.path == null || GetData.path == "") {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields.");
                alert.showAndWait();
            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to update EqID: " + peripheralsEqID.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();
                
                if(option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(sql);
                    
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();
                    
                    equipmentShowListData();
                    equipmentClear();
                }
            }
        } catch(Exception e) {e.printStackTrace();} 
    }
    
    public void equipmentDelete() {
        String sql = "DELETE FROM equipment WHERE eqid = '" + peripheralsEqID.getText() + "'";
        
        connect = database.connectDb();
        
        try {
            Alert alert;
            
            if(peripheralsEqID.getText().isEmpty()
                    || peripheralsType.getText().isEmpty()
                    || peripheralsBrand.getText().isEmpty()
                    || peripheralsModel.getText().isEmpty()
                    || peripheralsStatus.getSelectionModel().getSelectedItem() == null
                    || peripheralsPrice.getText().isEmpty()
                    || GetData.path == null || GetData.path == "") {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields.");
                alert.showAndWait();
            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to delete EqID: " + peripheralsEqID.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();
                
                if(option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(sql);
                    
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();
                    
                    equipmentShowListData();
                    equipmentClear();
                }
            }
            
        } catch(Exception e) {e.printStackTrace();}
    }
    
    public void equipmentClear() {
        peripheralsEqID.setText("");
        peripheralsType.setText("");
        peripheralsBrand.setText("");
        peripheralsModel.setText("");
        peripheralsStatus.getSelectionModel().clearSelection();
        peripheralsPrice.setText("");
        
        GetData.path = "";
        
        peripheralsImageView.setImage(null);
    }
    
    private String[] statusList = {"Available", "Unavailable"};
    public void equipmentStatus() {
        List<String> statusL = new ArrayList<>();
        
        for(String data: statusList) {
            statusL.add(data);
        }
        
        ObservableList listData = FXCollections.observableArrayList(statusL);
        peripheralsStatus.setItems(listData);
    }
    
    public void equipmentImportImage() {
        
        FileChooser open = new FileChooser();
        open.setTitle("Open Image File");
        open.getExtensionFilters().add(new ExtensionFilter("Image File", "*jpg", "*png"));
        
        File file = open.showOpenDialog(mainForm.getScene().getWindow());
        
        if(file != null) {
            GetData.path = file.getAbsolutePath();
            
            image = new Image(file.toURI().toString(), 272, 167, false, true);
            peripheralsImageView.setImage(image);
        }
    }
    
    public ObservableList<EquipmentData> EquipmentListData() {
        
        ObservableList<EquipmentData> listData = FXCollections.observableArrayList();
        
        String sql = "SELECT * FROM equipment";
        
        connect = database.connectDb();
        
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            EquipmentData eqData;
            
            while(result.next()) {
                eqData = new EquipmentData(result.getInt("eqid")
                        , result.getString("type")
                        , result.getString("brand")
                        , result.getString("model")
                        , result.getDouble("price")
                        , result.getString("status")
                        , result.getString("image")
                        , result.getDate("date"));
                listData.add(eqData);
            }
        } catch(Exception e) {e.printStackTrace();}
        return listData;
    }
    
    private ObservableList<EquipmentData> equipmentList;
    public void equipmentShowListData() {
        equipmentList = EquipmentListData();
        
        peripheralsColEqID.setCellValueFactory(new PropertyValueFactory<>("eqID"));
        peripheralsColType.setCellValueFactory(new PropertyValueFactory<>("type"));
        peripheralsColBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        peripheralsColModel.setCellValueFactory(new PropertyValueFactory<>("model"));
        peripheralsColPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        peripheralsColStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        
        peripheralsTableView.setItems(equipmentList);
    }
    
    public void equipmentSearch() {
        
        FilteredList<EquipmentData> filter = new FilteredList<>(equipmentList, e -> true);
        
        peripheralsSearch.textProperty().addListener((Observable, oldValue, newValue) -> {
            
            filter.setPredicate(predicateEquipmentData -> {
                
                if(newValue == null || newValue.isEmpty()) {
                    return true;
                }
                
                String searchKey = newValue.toLowerCase();
                
                if(predicateEquipmentData.getEqID().toString().contains(searchKey)) {
                    return true; 
                } else if(predicateEquipmentData.getType().toLowerCase().contains(searchKey)) {
                    return true;
                } else if(predicateEquipmentData.getBrand().toLowerCase().contains(searchKey)) {
                    return true;
                } else if(predicateEquipmentData.getModel().toLowerCase().contains(searchKey)) {
                    return true;
                } else if(predicateEquipmentData.getPrice().toString().contains(searchKey)) {
                    return true;
                } else if(predicateEquipmentData.getStatus().toLowerCase().contains(searchKey)) {
                    return true;
                } else {
                    return false;
                }
            });
            SortedList<EquipmentData> sortList = new SortedList<>(filter);
        
            sortList.comparatorProperty().bind(peripheralsTableView.comparatorProperty());
            peripheralsTableView.setItems(sortList);
        });
    }
    
    public void equipmentSelect() {
        EquipmentData eqData = peripheralsTableView.getSelectionModel().getSelectedItem();
        int num = peripheralsTableView.getSelectionModel().getSelectedIndex();
        
        if((num - 1) < - 1) {
            return;
        }
        
        peripheralsEqID.setText(String.valueOf(eqData.getEqID()));
        peripheralsType.setText(eqData.getType());
        peripheralsBrand.setText(eqData.getBrand());
        peripheralsModel.setText(eqData.getModel());
        peripheralsPrice.setText(String.valueOf(eqData.getPrice()));
        
        GetData.path = eqData.getImage();
        
        String uri = "file:" + eqData.getImage();
        
        image = new Image(uri, 272, 167, false, true);
        
        peripheralsImageView.setImage(image);
        
    }
    
    private int countDate;
    public void rentCountDate() {
        Alert alert;
        
        if(firstName.getText().isEmpty()
                || lastName.getText().isEmpty()
                || rentEqID.getSelectionModel().getSelectedItem() == null
                || rentType.getSelectionModel().getSelectedItem() == null
                || rentBrand.getSelectionModel().getSelectedItem() == null
                || rentModel.getSelectionModel().getSelectedItem() == null) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in your neccessary infos.");
            alert.showAndWait();
            
            rentDate.setValue(null);
            rentReturn.setValue(null);
            
            rentClear();
        } else {
            if(rentReturn.getValue().isAfter(rentDate.getValue())) {
                long days = ChronoUnit.DAYS.between(rentDate.getValue(), rentReturn.getValue());
                countDate = (int) days;
            } else {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("A customer must rent at least 1 day.");
                alert.showAndWait();
            
                rentReturn.setValue(rentDate.getValue().plusDays(1));
            }
        }
    }
    
    private double totalPay;
    public void rentDisplayTotal() {
        rentCountDate();
        double price = 0;
        
        String sql = "SELECT price, model FROM equipment WHERE model = '"
                +rentModel.getSelectionModel().getSelectedItem()+"'";
        
        connect = database.connectDb();
        
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            if(result.next()) {
                price = result.getDouble("price");
            }
            
            totalPay = price * countDate;
            
            rentTotal.setText("₱" + String.valueOf(totalPay));
        } catch(Exception e) {e.printStackTrace();}
    }
    
    public void rentPay(){
        rentCustomerID();
        
        String sql = "INSERT INTO customer"
                + "(customerid, firstname, lastname, eqid, type, brand"
                + ", model, total, date_rent, date_return) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?)";
        
        connect = database.connectDb();
        
        try {
            Alert alert;
            
            if(firstName.getText().isEmpty()
                    || lastName.getText().isEmpty()
                    || rentEqID.getSelectionModel().getSelectedItem() == null
                    || rentType.getSelectionModel().getSelectedItem() == null
                    || rentBrand.getSelectionModel().getSelectedItem() == null
                    || rentModel.getSelectionModel().getSelectedItem() == null
                    || totalPay == 0 || rentAmount.getText().isEmpty()
                    || Double.parseDouble(rentAmount.getText()) < totalPay) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Invalid Action.");
                alert.showAndWait();
            } else {
                
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Press OK to complete the transaction.");
                Optional<ButtonType> option = alert.showAndWait();
                
                if(option.get().equals(ButtonType.OK)) {
                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, String.valueOf(customerID));
                    prepare.setString(2, firstName.getText());
                    prepare.setString(3, lastName.getText());
                    prepare.setString(4, (String)rentEqID.getSelectionModel().getSelectedItem());
                    prepare.setString(5, (String)rentType.getSelectionModel().getSelectedItem());
                    prepare.setString(6, (String)rentBrand.getSelectionModel().getSelectedItem());
                    prepare.setString(7, (String)rentModel.getSelectionModel().getSelectedItem());
                    prepare.setString(8, String.valueOf(totalPay));
                    prepare.setString(9, String.valueOf(rentDate.getValue()));
                    prepare.setString(10, String.valueOf(rentReturn.getValue()));

                    prepare.executeUpdate();
                    
                    String updateEq = "UPDATE equipment SET status = 'Unavailable' WHERE eqid = '"
                            +rentEqID.getSelectionModel().getSelectedItem()+"'";
                    
                    statement = connect.createStatement();
                    statement.executeUpdate(updateEq);
                    
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Transaction Complete.");
                    alert.showAndWait();
                    
                    rentEqShowListData();
                    rentClear();
                }
            }
        } catch(Exception e) {e.printStackTrace();}
    }
    
    public void rentClear() {
        totalPay = 0;
        firstName.setText("");
        lastName.setText("");
        amount = 0;
        change = 0;
        rentChange.setText("₱0.0");
        rentTotal.setText("₱0.0");
        rentAmount.setText("");
        rentEqID.getSelectionModel().clearSelection();
        rentType.getSelectionModel().clearSelection();
        rentBrand.getSelectionModel().clearSelection();
        rentModel.getSelectionModel().clearSelection();
    }
    
    private int customerID;
    public void rentCustomerID() {
        String sql = "SELECT id FROM customer";
        
        connect = database.connectDb();
        
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            while(result.next()) {
                customerID += result.getInt("id") + 1;
            }
        } catch(Exception e) {e.printStackTrace();}
    }
    
    private double amount;
    private double change;
    public void rentAmount() {
        Alert alert;
        
        if(totalPay == 0 || rentAmount.getText().isEmpty()) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Invalid Action.");
            alert.showAndWait();
            
            rentAmount.setText("");
        } else {
            amount = Double.parseDouble(rentAmount.getText());
            
            if(amount >= totalPay) {
                change = amount - totalPay;
                rentChange.setText("₱" + String.valueOf(change));
            } else {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("The amount is not sufficient.");
                alert.showAndWait();
            }
        }
    }
    
    public ObservableList<EquipmentData> RentEqListData() {
        ObservableList<EquipmentData> listData = FXCollections.observableArrayList();
        
        String sql = "SELECT * FROM equipment";
        
        connect = database.connectDb();
        
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            EquipmentData eqData;
            
            while(result.next()) {
                eqData = new EquipmentData(result.getInt("eqid")
                        , result.getString("type")
                        , result.getString("brand")
                        , result.getString("model")
                        , result.getDouble("price")
                        , result.getString("status")
                        , result.getString("image")
                        , result.getDate("date"));
                
                listData.add(eqData);
            }
        } catch(Exception e) {e.printStackTrace();}
        return listData;
    }
    
    public void rentEqID() {
        String sql = "SELECT * FROM equipment WHERE status = 'Available'";
        
        connect = database.connectDb();
        
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            ObservableList listData = FXCollections.observableArrayList();
            
            while(result.next()) {
                listData.add(result.getString("eqid"));
            }
            
            rentEqID.setItems(listData);
            rentEqType();
        } catch(Exception e) {e.printStackTrace();}
    }
    
    public void rentEqType() {
        String sql = "SELECT * FROM equipment WHERE eqid = '"
                +rentEqID.getSelectionModel().getSelectedItem()+"'";
        
        connect = database.connectDb();
        
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            ObservableList listData = FXCollections.observableArrayList();
            
            while(result.next()) {
                listData.add(result.getString("type"));
            }
            
            rentType.setItems(listData);
            
            rentEqBrand();
        } catch(Exception e) {e.printStackTrace();}
    }
    
    public void rentEqBrand() {
        String sql = "SELECT * FROM equipment WHERE type = '"
                +rentType.getSelectionModel().getSelectedItem()+"'";
        
        connect = database.connectDb();
        
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            ObservableList listData = FXCollections.observableArrayList();
            
            while(result.next()) {
                listData.add(result.getString("brand"));
            }
            
            rentBrand.setItems(listData);
            
            rentEqModel();
        } catch(Exception e) {e.printStackTrace();}
    }
    
    public void rentEqModel() {
        String sql = "SELECT * FROM equipment WHERE brand = '"
                +rentBrand.getSelectionModel().getSelectedItem()+"'";
        
        connect = database.connectDb();
        
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            ObservableList listData = FXCollections.observableArrayList();
            
            while(result.next()) {
                listData.add(result.getString("model"));
            }
            
            rentModel.setItems(listData);
        } catch(Exception e) {e.printStackTrace();}
    }
    
    private ObservableList<EquipmentData> rentEqList;
    public void rentEqShowListData() {
        rentEqList = RentEqListData();
        
        rentColEqID.setCellValueFactory(new PropertyValueFactory<>("eqID"));
        rentColType.setCellValueFactory(new PropertyValueFactory<>("type"));
        rentColBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        rentColModel.setCellValueFactory(new PropertyValueFactory<>("model"));
        rentColPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        rentColStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        
        rentTableView.setItems(rentEqList);
    }
    
    public void displayUsername() {
        String user = GetData.username;
        
        username.setText(user.substring(0, 1).toUpperCase() + user.substring(1));
    }
    
    private double x = 0;
    private double y = 0;
    
    public void logout() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to logout?");
        
        Optional<ButtonType> option = alert.showAndWait();
        
        try {
            if(option.get().equals(ButtonType.OK)) {
            
                logoutButton.getScene().getWindow().hide();
                
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                root.setOnMousePressed((MouseEvent event) -> {
                    x = event.getSceneX();
                    y = event.getSceneY();
                });

                root.setOnMouseDragged((MouseEvent event) -> {
                    stage.setX(event.getScreenX() - x);
                    stage.setY(event.getScreenY() - y);
                });

                stage.initStyle(StageStyle.TRANSPARENT);
                stage.setScene(scene);
                stage.show();
            
            }
        } catch(Exception e) {e.printStackTrace();} 
        
    }
    
    public void switchForm(ActionEvent e) {
        if(e.getSource() == homeFormButton) {
            
            homeForm.setVisible(true);
            peripheralsForm.setVisible(false);
            rentForm.setVisible(false);
            
            homeFormButton.setStyle("-fx-background-color: linear-gradient(to bottom right, #45145a, #ff5300);");
            peripheralsFormButton.setStyle("-fx-background-color: transparent;");
            rentFormButton.setStyle("-fx-background-color: transparent;");
            
            
            homeAvailablePeripherals();
            homeTotalRevenue();
            homeNumOfCustomers();
            homeRevChart();
            homeCustmChart();
            
            rentClear();
            equipmentClear();
            
        } else if(e.getSource() == peripheralsFormButton) {
            
            homeForm.setVisible(false);
            peripheralsForm.setVisible(true);
            rentForm.setVisible(false);
            
            homeFormButton.setStyle("-fx-background-color: transparent;");
            peripheralsFormButton.setStyle("-fx-background-color: linear-gradient(to bottom right, #45145a, #ff5300);");
            rentFormButton.setStyle("-fx-background-color: transparent;");
            
            equipmentShowListData();
            equipmentStatus();
            equipmentSearch();
            
            rentClear();
            
        } else if(e.getSource() == rentFormButton) {
            
            homeForm.setVisible(false);
            peripheralsForm.setVisible(false);
            rentForm.setVisible(true);
            
            homeFormButton.setStyle("-fx-background-color: transparent;");
            peripheralsFormButton.setStyle("-fx-background-color: transparent;");
            rentFormButton.setStyle("-fx-background-color: linear-gradient(to bottom right, #45145a, #ff5300);");
            
            rentEqShowListData();
            rentEqID();
            rentEqType();
            rentEqBrand();
            rentEqModel();
            
            equipmentClear();
        }
    }
    
    public void close() {
        System.exit(0);
    }
    
    public void minimize() {
        Stage stage = (Stage)mainForm.getScene().getWindow();
        stage.setIconified(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayUsername();
        
        homeAvailablePeripherals();
        homeTotalRevenue();
        homeNumOfCustomers();
        homeRevChart();
        homeCustmChart();
        
        equipmentShowListData();
        equipmentStatus();
        equipmentSearch();
        
        rentEqShowListData();
        rentEqID();
        rentEqType();
        rentEqBrand();
        rentEqModel();
    }
}
