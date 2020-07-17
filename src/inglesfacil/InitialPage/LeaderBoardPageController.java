package inglesfacil.InitialPage;

import inglesfacil.ConnectionDB;
import inglesfacil.GameInformation.Profile;
import inglesfacil.InglesFacil;
import inglesfacil.PageAction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import static java.util.stream.Collectors.toMap;

public class LeaderBoardPageController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button btBack;

    @FXML
    private TableView<Profile> tbLeaderBoard;

    @FXML
    public TableColumn<Profile, String> username;

    @FXML
    public TableColumn<Profile, Integer> level;

    @FXML
    public TableColumn<Profile, Integer> position;

    Map<String, Integer> map;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //connection to database
        try {
            connection = ConnectionDB.conector();
        }catch (NullPointerException e) {
            e.printStackTrace();
        }
        position.setCellValueFactory(new PropertyValueFactory<Profile,Integer>("position"));
        username.setCellValueFactory(new PropertyValueFactory<Profile,String>("name"));
        level.setCellValueFactory(new PropertyValueFactory<Profile,Integer>("lvl"));
        display();
    }

    public void display() {
        try {
            map = new HashMap<String, Integer>();
            String querry = "select * from tbPlayer";

            preparedStatement = connection.prepareStatement(querry);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                map.put(resultSet.getString("username"), resultSet.getInt("level"));
            }
            //sort map in descending order
            Map<String, Integer> sorted = map
                    .entrySet()
                    .stream()
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .collect(
                            toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                    LinkedHashMap::new));
            ObservableList<Profile> profile = FXCollections.observableArrayList();
            //fill table
            int i = 1;
            for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
                Profile player = new Profile(i,entry.getKey(), entry.getValue());
                profile.add(player);
                ++i;
            }
            tbLeaderBoard.setItems(profile);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleButtonBackAction(ActionEvent event) throws IOException {
        Scene scene = btBack.getScene();
        PageAction.backScene(scene,anchorPane);
    }
}
