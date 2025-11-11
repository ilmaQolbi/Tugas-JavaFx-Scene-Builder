
package controller;
import model.Riwayat;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author ilma
 */
public class FirstViewController implements Initializable {

    @FXML
    private DatePicker pilihTglMulai;
    @FXML
    private Label judul;
    @FXML
    private TableView<Riwayat> tabelRiwayat;
    @FXML
    private TableColumn<Riwayat, Integer> kolomNo;
    @FXML
    private TableColumn<Riwayat, LocalDate> kolomTglMulai;
    @FXML
    private TableColumn<Riwayat, LocalDate> kolomTglSelesai;
    @FXML
    private DatePicker pilihTglSelesai;
    private ObservableList<Riwayat> dataRiwayat;
    @FXML
    private Button btnHapus;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dataRiwayat = FXCollections.observableArrayList();
        
        kolomNo.setCellValueFactory(new PropertyValueFactory<>("no"));
        kolomTglMulai.setCellValueFactory(new PropertyValueFactory<>("tanggalMulai"));
        kolomTglSelesai.setCellValueFactory(new PropertyValueFactory<>("tanggalSelesai"));
        
        tabelRiwayat.setItems(dataRiwayat);
    }    
    
    @FXML
    private void handleAddRiwayat(ActionEvent event) {
        LocalDate tglMulai = pilihTglMulai.getValue();
        LocalDate tglSelesai = pilihTglSelesai.getValue();

        if (tglMulai == null || tglSelesai == null) {
           judul.setText("HARAP ISI KEDUA TANGGAL!");
            return;
        
        }
        if (tglSelesai.isBefore(tglMulai)) {
            judul.setText("TANGGAL SELESAI TIDAK BOLEH SEBELUM TANGGAL MULAI!");
            return;
        }
        int noUrut = dataRiwayat.size() + 1;
        Riwayat newRiwayat = new Riwayat(noUrut, tglMulai, tglSelesai);
        dataRiwayat.add(newRiwayat);
        updateNomorUrut();
        pilihTglMulai.setValue(null);
        pilihTglSelesai.setValue(null);
        
        judul.setText("DATA BERHASIL DITAMBAHKAN!");
    }
    
    @FXML
    private void handleDeleteRiwayat(ActionEvent event) {
        Riwayat selectedRiwayat = tabelRiwayat.getSelectionModel().getSelectedItem();
        if (selectedRiwayat != null) {
            dataRiwayat.remove(selectedRiwayat);
            updateNomorUrut(); 

            System.out.println("Riwayat berhasil dihapus.");
        } else {
            System.out.println("Pilih baris yang ingin dihapus terlebih dahulu.");
        }
    }
    private void updateNomorUrut() {
        for (int i = 0; i < dataRiwayat.size(); i++) {
            dataRiwayat.get(i).noProperty().set(i + 1);
        }
        tabelRiwayat.refresh();
    }
}
