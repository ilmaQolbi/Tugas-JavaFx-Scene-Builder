package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import java.time.LocalDate;

public class Riwayat {
    private final SimpleIntegerProperty no;
    private final SimpleObjectProperty<LocalDate> tanggalMulai;
    private final SimpleObjectProperty<LocalDate> tanggalSelesai;

    public Riwayat(int no, LocalDate tanggalMulai, LocalDate tanggalSelesai) {
        this.no = new SimpleIntegerProperty(no);
        this.tanggalMulai = new SimpleObjectProperty<>(tanggalMulai);
        this.tanggalSelesai = new SimpleObjectProperty<>(tanggalSelesai);
    }

    public int getNo() {
        return no.get();
    }

    public SimpleIntegerProperty noProperty() {
        return no;
    }

    public LocalDate getTanggalMulai() {
        return tanggalMulai.get();
    }

    public SimpleObjectProperty<LocalDate> tanggalMulaiProperty() {
        return tanggalMulai;
    }

    public LocalDate getTanggalSelesai() {
        return tanggalSelesai.get();
    }

    public SimpleObjectProperty<LocalDate> tanggalSelesaiProperty() {
        return tanggalSelesai;
    }
}
