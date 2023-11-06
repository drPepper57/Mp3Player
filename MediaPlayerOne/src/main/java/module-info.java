module com.pepper.mediaplayerone {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires jakarta.persistence;

    opens com.pepper.mediaplayerone to javafx.fxml;
    exports com.pepper.mediaplayerone;
}
