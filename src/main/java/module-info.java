module Baticonnect { // الاسم ديال الموديل ديالك (يمكن يكون ArtifactId ديال pom.xml)

    // المكتبات الضرورية
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql; // حيت عندك MySQL Connector

    // هنا كنسمحو لـ FXML يقرا الـ Controllers ديالنا
    opens Main_test to javafx.fxml; // (Main_test هو اسم الباكيج اللي فيه Main.java)

    // هنا كنقولو لـ Java منين تبدا تخدم التطبيق
    exports Main_test;
    exports controler;
    opens controler to javafx.fxml;
}